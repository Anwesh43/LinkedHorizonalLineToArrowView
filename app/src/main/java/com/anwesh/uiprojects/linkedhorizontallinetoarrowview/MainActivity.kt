package com.anwesh.uiprojects.linkedhorizontallinetoarrowview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.horizontallinetoarrowview.HorizontalLineToArrowView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HorizontalLineToArrowView.create(this)
    }
}
