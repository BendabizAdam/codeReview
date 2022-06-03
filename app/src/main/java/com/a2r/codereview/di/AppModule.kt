package com.a2r.codereview.di

import android.content.Context
import com.a2r.codereview.data.ResidentsDao
import com.a2r.codereview.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getAppDB(@ApplicationContext context: Context): AppDataBase{
        return AppDataBase.getAppDB(context)
    }
    @Singleton
    @Provides
    fun getDao(appDB:AppDataBase): ResidentsDao {
        return appDB.getDAO()
    }

}