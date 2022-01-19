package com.kanneki.paging3compose.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kanneki.paging3compose.model.UnsplashRemoteKeys

@Dao
interface UnsplashRemoteKeyDao {

    @Query("SELECT * FROM unsplash_remote_keys_table WHERE id=:id")
    fun getRemoteKeys(id: String): UnsplashRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoKeys(remoteKeys: List<UnsplashRemoteKeys>)

    @Query("DELETE FROM unsplash_remote_keys_table")
    suspend fun deleteAllRemoteKeys()
}