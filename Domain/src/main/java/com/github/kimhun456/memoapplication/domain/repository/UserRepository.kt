package com.github.kimhun456.memoapplication.domain.repository

import io.reactivex.rxjava3.core.Completable

interface UserRepository {

    fun createUser(): Completable
}