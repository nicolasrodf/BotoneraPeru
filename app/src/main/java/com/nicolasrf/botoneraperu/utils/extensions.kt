package com.nicolasrf.botoneraperu.utils

import android.net.Uri
import androidx.core.net.toUri

fun String.toFirebaseUrl() : Uri =
    "https://firebasestorage.googleapis.com/v0/b/root-blueprint-178315.appspot.com/o/$this.aac?alt=media&token=9e96b33c-95b6-4a9a-bf66-3e54c889ee80".toUri()