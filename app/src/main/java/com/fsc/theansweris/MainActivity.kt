package com.fsc.theansweris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // when the app loads ... it waits for 4 seconds and then it goes to the actual main screen
        Handler().postDelayed({
            var goWelcome: Intent = Intent(applicationContext,WelcomePage::class.java)
            startActivity(goWelcome)
        },4000)

    }
}