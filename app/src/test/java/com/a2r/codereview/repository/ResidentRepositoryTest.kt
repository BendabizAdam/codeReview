package com.a2r.codereview.repository

import com.a2r.codereview.data.ResidentsDao
import com.a2r.codereview.entity.Resident
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class ResidentRepositoryTest {
    //used mockk to mock dependencies
    @get:Rule
    val mockkRule = MockKRule(this)

    @RelaxedMockK
    lateinit var residentsDao: ResidentsDao

    @InjectMockKs
    lateinit var repository: ResidentRepository

    @Test
    fun `should return a list of residents`() {
        coEvery { repository.getResidents() }.returnsMany(listOf(Resident("nom", 25)))
        runBlocking {
            assertEquals("size is equal to 1",1,repository.getResidents().size)
        }
        coVerify { residentsDao.getResidents() }
    }
}