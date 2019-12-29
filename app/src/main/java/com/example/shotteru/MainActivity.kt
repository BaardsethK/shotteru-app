package com.example.shotteru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.qualifiedName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startGameButton = findViewById<Button>(R.id.startGameButton)
        var settingsButton = findViewById<Button>(R.id.settingsButton)
        var quitButton = findViewById<Button>(R.id.quitButton)

        startGameButton.setOnClickListener {
            val intent = Intent(this, PlayerInputActivity::class.java)
            startActivity(intent)
        }

        settingsButton.setOnClickListener{
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        quitButton.setOnClickListener {
            finishAffinity()
        }

    }
}
