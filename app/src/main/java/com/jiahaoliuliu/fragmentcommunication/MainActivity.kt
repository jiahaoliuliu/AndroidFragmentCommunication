package com.jiahaoliuliu.fragmentcommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataFromFragmentTextView = findViewById<TextView>(R.id.data_from_fragment_tv)
        supportFragmentManager.setFragmentResultListener(ASimpleFragment.REQUEST_KEY, this) {
            _, bundle ->
            val result = bundle.getString(ASimpleFragment.CONTENT_KEY)
            dataFromFragmentTextView.text = result
        }
    }
}