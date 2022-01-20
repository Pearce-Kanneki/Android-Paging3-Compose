package com.kanneki.paging3compose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kanneki.paging3compose.data.local.dao.UnsplashImageDao
import com.kanneki.paging3compose.data.local.dao.UnsplashRemoteKeyDao
import com.kanneki.paging3compose.model.UnsplashImage
import com.kanneki.paging3compose.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashImageDatabase: RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeyDao
}