package com.github.kimhun456.memoapplication.domain.repository

import com.github.kimhun456.memoapplication.domain.entity.Memo
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface MemoRepository {

    fun createMemo(memo: Memo): Completable
    fun modifyMemo(memo: Memo): Completable
    fun deleteMemo(id: Long): Completable
    fun deleteMemos(idList: List<Long>): Completable
    fun loadMemos(): Flowable<List<Memo>>
}