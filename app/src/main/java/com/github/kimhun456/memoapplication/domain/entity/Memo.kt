package com.github.kimhun456.memoapplication.domain.entity

import com.github.kimhun456.memoapplication.domain.entity.user.User

data class Memo(
    val title: String,
    val message: String,
    val author: User,
    val createdTime: Long,
    val lastModifiedTime: Long
)
