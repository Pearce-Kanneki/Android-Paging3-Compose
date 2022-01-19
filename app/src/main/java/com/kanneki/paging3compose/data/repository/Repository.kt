package com.kanneki.paging3compose.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kanneki.paging3compose.data.local.UnsplashImageDatabse
import com.kanneki.paging3compose.data.paging.UnsplashRemoteMediator
import com.kanneki.paging3compose.data.remote.UnsplashApi
import com.kanneki.paging3compose.model.UnsplashImage
import com.kanneki.paging3compose.util.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashImageDatabse: UnsplashImageDatabse
) {


    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { unsplashImageDatabse.unsplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = Constants.ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(unsplashApi, unsplashImageDatabse),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}