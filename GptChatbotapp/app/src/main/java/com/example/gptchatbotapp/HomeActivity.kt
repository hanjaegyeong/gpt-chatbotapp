package com.example.gptchatbotapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.gptchatbotapp.GptActivity
import com.example.gptchatbotapp.R

// Home으로 intent하려면(뒤로가기 위해) Fragment가 아니라 Activity 필요
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)
        val button1 = findViewById<View>(R.id.button1)
        val button2 = findViewById<View>(R.id.button2)
        val button3 = findViewById<View>(R.id.button3)

        button1.setOnClickListener {
            val intent = Intent(this@HomeActivity, GptActivity::class.java)
            intent.putExtra("prompt", "bye")
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this@HomeActivity, GptActivity::class.java)
            intent.putExtra("prompt", "hello")
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this@HomeActivity, GptActivity::class.java)
            intent.putExtra("prompt", "Hello from button 3")
            startActivity(intent)
        }
    }
}
