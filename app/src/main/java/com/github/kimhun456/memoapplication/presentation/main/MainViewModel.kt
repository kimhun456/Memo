package com.github.kimhun456.memoapplication.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.github.kimhun456.memoapplication.domain.entity.Memo
import com.github.kimhun456.memoapplication.domain.interactor.memo.CreateMemoUseCase
import com.github.kimhun456.memoapplication.domain.interactor.memo.FlowAllMemoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(
    private val createMemoUseCase: CreateMemoUseCase,
    private val flowAllMemoUseCase: FlowAllMemoUseCase
) : ViewModel() {

    private val _memoList = flowAllMemoUseCase.flowMemos().toLiveData()

    val memoList: LiveData<List<Memo>> = _memoList

    fun addMemo() {
        createMemoUseCase.createMemo(generateRandomMemo())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                // TODO : add timber for logging
                {}, { throwable -> }
            )
    }

    private fun generateRandomMemo(): Memo {
        val titles = listOf("To do", "Tonight we party", "My wishList")
        val messages = listOf("Do coding", "party receipt", "do!!!!!")
        val index = Random.nextInt(0, titles.size)
        val currentTime = System.currentTimeMillis()
        return Memo(
            id = 0L,
            title = titles[index],
            message = messages[index],
            createdTime = currentTime,
            lastModifiedTime = currentTime
        )
    }
}