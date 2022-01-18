package com.kanneki.paging3compose.model

import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("links")
    @Embedded
    val userLinks: UserLink,
    val userName: String
)
