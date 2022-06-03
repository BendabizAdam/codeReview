package com.a2r.codereview.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.a2r.codereview.data.ResidentsDao
import com.a2r.codereview.entity.Resident

@Database(entities = [Resident::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getDAO(): ResidentsDao

    companion object {
        @Volatile
        private var dbINSTANCE: AppDataBase? = null
        fun getAppDB(context: Context): AppDataBase {
            if (dbINSTANCE == null) {
                dbINSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "AppDB"
                )
                    .build()
            }
            return dbINSTANCE!!
        }
    }
}