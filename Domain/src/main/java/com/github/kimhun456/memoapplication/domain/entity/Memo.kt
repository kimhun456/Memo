package com.github.kimhun456.memoapplication.domain.entity

data class Memo(
    val title: String,
    val message: String,
    val author: User,
    val createdTime: Long,
    val lastModifiedTime: Long
)
