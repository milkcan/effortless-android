package io.milkcan.effortlessandroidsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import io.milkcan.effortlessandroid.d
import io.milkcan.effortlessandroid.getDrawableCompat
import io.milkcan.effortlessandroid.toastLong

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        toastLong("Toasty!")
    }

}
