package com.github.kimhun456.memoapplication.domain.user

import com.github.kimhun456.memoapplication.domain.entity.user.User
import com.github.kimhun456.memoapplication.domain.repository.UserRepository
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    fun execute(user: User): Completable = userRepository.createUser(user)

}