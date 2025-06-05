package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class home : AppCompatActivity() {
    private lateinit var add: FloatingActionButton
    private lateinit var backButton: ImageButton
    private lateinit var profileButton: ImageButton
    private lateinit var myTrack: TextView

    private fun initComponents() {
        add = findViewById(R.id.add)
        backButton = findViewById(R.id.backButton)
        myTrack = findViewById(R.id.myTrack)
        profileButton = findViewById(R.id.profileButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()

        add.setOnClickListener {
            val intent = Intent(this, addTransaction::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        myTrack.setOnClickListener{
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        profileButton.setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

    }
}
