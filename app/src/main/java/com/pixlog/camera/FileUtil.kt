package com.pixlog.camera

import android.content.Context
import android.net.Uri
import java.io.File
import java.io.IOException
import java.util.*

import android.os.Environment.*
import java.io.FileOutputStream
import java.text.SimpleDateFormat

class FileUtil (private val context: Context) {

    @Throws(IOException::class)
    fun urisToFiles(uris: List<Uri>): List<File> {
        val files = ArrayList<File>(uris.size)
        for (uri in uris) {
            files.add(File(uri.path.toString()))
        }
        return files
    }
}