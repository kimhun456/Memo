package com.github.kimhun456.memoapplication.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.kimhun456.memoapplication.domain.entity.Memo
import com.github.kimhun456.memoapplication.domain.entity.user.Gender
import com.github.kimhun456.memoapplication.domain.entity.user.User
import com.github.kimhun456.memoapplication.domain.interactor.CreateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(
    private val createUserUseCase: CreateUserUseCase
) : ViewModel() {

    private val _memoList = MutableLiveData<List<Memo>>(listOf())

    val memoList: LiveData<List<Memo>> = _memoList

    fun addMemo() {
        val memo = generateRandomMemo()
        val currentList = _memoList.value!!
        _memoList.value = currentList.toMutableList().apply { add(memo) }.toList()
    }

    private fun generateRandomMemo(): Memo {
        val titles = listOf("To do", "Tonight we party", "My wishList")
        val messages = listOf("Do coding", "party receipt", "do!!!!!")
        val index = Random.nextInt(0, titles.size)
        val user = User("id", "hyunjae", "kimhun456@gmail.com", Gender.MAN)
        val currentTime = System.currentTimeMillis()
        return Memo(
            title = titles[index],
            message = messages[index],
            author = user,
            createdTime = currentTime,
            lastModifiedTime = currentTime
        )
    }
}