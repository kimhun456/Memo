package com.github.kimhun456.memoapplication.domain.entity

data class NoteBook(
    val contents: List<Memo>,
    val createTime: Long,
    val modifiedTime: Long,
    val author: User,
    val sharedAuthor: List<User>
)
