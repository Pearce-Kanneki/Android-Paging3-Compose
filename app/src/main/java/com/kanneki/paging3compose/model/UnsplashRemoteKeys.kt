package com.kanneki.paging3compose.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kanneki.paging3compose.util.Constants.UNSPLASH_REMOTE_KEYS

@Entity(tableName = UNSPLASH_REMOTE_KEYS)
data class UnsplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)
