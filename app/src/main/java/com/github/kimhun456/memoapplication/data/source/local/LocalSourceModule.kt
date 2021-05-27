package com.github.kimhun456.memoapplication.data.source.local

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModule {

    @Binds
    abstract fun provideUserDao(userDaoImpl: UserDaoImpl): UserDao
}