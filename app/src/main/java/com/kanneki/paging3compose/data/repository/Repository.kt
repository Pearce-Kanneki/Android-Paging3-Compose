package com.kanneki.paging3compose.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kanneki.paging3compose.data.local.UnsplashImageDatabase
import com.kanneki.paging3compose.data.paging.SearchPagingSource
import com.kanneki.paging3compose.data.paging.UnsplashRemoteMediator
import com.kanneki.paging3compose.data.remote.UnsplashApi
import com.kanneki.paging3compose.model.UnsplashImage
import com.kanneki.paging3compose.util.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashImageDatabase: UnsplashImageDatabase
) {


    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { unsplashImageDatabase.unsplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = Constants.ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashImageDatabase = unsplashImageDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    fun searchImages(query: String): Flow<PagingData<UnsplashImage>> {
        return Pager(
            config = PagingConfig(pageSize = Constants.ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchPagingSource(unsplashApi = unsplashApi, query = query)
            }
        ).flow
    }
}