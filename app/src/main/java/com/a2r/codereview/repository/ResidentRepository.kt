package com.a2r.codereview.repository

import com.a2r.codereview.data.ResidentsDao
import com.a2r.codereview.entity.Resident
import javax.inject.Inject

//injecting dao dependency
class ResidentRepository @Inject constructor(private val residentsDao: ResidentsDao) {
    suspend fun getResidents(): List<Resident> {
        return residentsDao.getResidents()
    }

    suspend fun insertAll(residents: List<Resident>) {
        residentsDao.insertAll(residents)
    }
}