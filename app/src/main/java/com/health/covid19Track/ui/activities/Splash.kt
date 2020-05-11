package com.health.covid19Track.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.health.covid19Track.R
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class Splash : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Observable.timer(2000, TimeUnit.MILLISECONDS)
            .subscribe {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
    }

}

