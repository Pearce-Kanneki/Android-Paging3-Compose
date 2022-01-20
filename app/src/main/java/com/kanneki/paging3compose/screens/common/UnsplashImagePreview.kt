package com.kanneki.paging3compose.screens.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import com.kanneki.paging3compose.model.UnsplashImage
import com.kanneki.paging3compose.model.Urls
import com.kanneki.paging3compose.model.User
import com.kanneki.paging3compose.model.UserLink

@ExperimentalCoilApi
@Composable
@Preview
fun UnsplashImagePreview() {
    UnsplashItem(unsplashImage = UnsplashImage(
        id = "1",
        urls = Urls(regular = ""),
        likes = 100,
        user = User(username = "Kanneki", userLinks = UserLink(html = ""))

    ))
}