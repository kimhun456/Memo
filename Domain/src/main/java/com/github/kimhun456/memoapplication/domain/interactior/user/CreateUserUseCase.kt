package com.github.kimhun456.memoapplication.domain.interactior.user

import com.github.kimhun456.memoapplication.domain.entity.User
import com.github.kimhun456.memoapplication.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Completable

class CreateUserUseCase constructor(
    private val userRepository: UserRepository
) {

    fun execute(user: User): Completable = userRepository.createUser()

}