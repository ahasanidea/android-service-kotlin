package com.ahasanidea.kotlin.androidservice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ahasanidea.kotlin.androidservice.ui.second.SecondFragment

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment.newInstance())
                .commitNow()
        }
    }

}
