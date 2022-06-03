package com.a2r.codereview.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.a2r.codereview.entity.Resident
import kotlinx.coroutines.flow.Flow

@Dao
interface ResidentsDao{
    @Query("SELECT * FROM resident_table")
    suspend fun getResidents(): List<Resident>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(resident: Resident)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(residents:List<Resident>)
}