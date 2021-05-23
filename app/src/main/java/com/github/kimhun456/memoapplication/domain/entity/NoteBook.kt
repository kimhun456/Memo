package com.github.kimhun456.memoapplication.domain.entity

import com.github.kimhun456.memoapplication.domain.entity.user.User

data class NoteBook(
    val contents: List<Memo>,
    val createTime: Long,
    val modifiedTime: Long,
    val author: User,
    val sharedAuthor: List<User>
)
