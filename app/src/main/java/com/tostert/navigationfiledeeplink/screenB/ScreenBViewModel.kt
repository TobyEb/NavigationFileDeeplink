package com.tostert.navigationfiledeeplink.screenB

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenBViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val deeplinkUri: Uri? = savedStateHandle.get<Intent>(NavController.KEY_DEEP_LINK_INTENT)?.let { if (it.action != null) it.data else null }

}
