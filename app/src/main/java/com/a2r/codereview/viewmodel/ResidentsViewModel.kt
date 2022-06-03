package com.a2r.codereview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a2r.codereview.entity.Resident
import com.a2r.codereview.repository.ResidentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//injecting repository dependency
@HiltViewModel
class ResidentsViewModel @Inject constructor(private val residentRepository: ResidentRepository) :
    ViewModel() {
    private var residents: MutableLiveData<List<Resident>> = MutableLiveData()

    init {
        //inserting some data on init
        insertAll()
    }

    // used dependency injection for repository
    fun getResidents() = viewModelScope.launch{
        residents.value= residentRepository.getResidents()
    }

    fun getResidentsObservable(): LiveData<List<Resident>> {
        return residents
    }

    private fun insertAll() = viewModelScope.launch {
        val residentList: MutableList<Resident> = ArrayList()
        for (i in 0..9) {
            residentList.add(Resident(String.format("name: %s", i), i + 20))
        }
        residentRepository.insertAll(residentList)
    }
}