package com.github.kimhun456.memoapplication.data.repository

import com.github.kimhun456.memoapplication.domain.entity.Memo
import com.github.kimhun456.memoapplication.domain.repository.MemoRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class MemoRepositoryImpl @Inject constructor() : MemoRepository {

    override fun createMemo(memo: Memo): Completable {
        TODO("Not yet implemented")
    }

    override fun modifyMemo(memo: Memo): Completable {
        TODO("Not yet implemented")
    }

    override fun deleteMemo(id: Long): Completable {
        TODO("Not yet implemented")
    }

    override fun deleteMemos(idList: List<Long>): Completable {
        TODO("Not yet implemented")
    }

    override fun loadMemos(): Flowable<List<Memo>> {
        TODO("Not yet implemented")
    }
}