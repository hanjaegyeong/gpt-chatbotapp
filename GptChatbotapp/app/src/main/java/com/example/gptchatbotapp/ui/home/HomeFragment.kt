package com.example.gptchatbotapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.gptchatbotapp.GptActivity
import com.example.gptchatbotapp.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button1 = view.findViewById<View>(R.id.button1)
        val button2 = view.findViewById<View>(R.id.button2)
        val button3 = view.findViewById<View>(R.id.button3)

        button1.setOnClickListener {
            val intent = Intent(requireActivity(), GptActivity::class.java)
            intent.putExtra("prompt", "bye") // "prompt" 키에 값을 전달
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(requireActivity(), GptActivity::class.java)
            intent.putExtra("prompt", "hello") // "prompt" 키에 값을 전달
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(requireActivity(), GptActivity::class.java)
            intent.putExtra("prompt", "Hello from button 3") // "prompt" 키에 값을 전달
            startActivity(intent)
        }
    }
}
