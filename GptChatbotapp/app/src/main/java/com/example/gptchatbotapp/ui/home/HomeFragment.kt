package com.example.gptchatbotapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.gptchatbotapp.ChatActivity
import com.example.gptchatbotapp.R
import com.example.gptchatbotapp.ui.notifications.NotificationsFragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button1 = view.findViewById<View>(R.id.button1)
        val button2 = view.findViewById<View>(R.id.button2)
        val button3 = view.findViewById<View>(R.id.button3)

        button1.setOnClickListener {
            val intent = Intent(requireActivity(), ChatActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(requireActivity(), ChatActivity::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(requireActivity(), ChatActivity::class.java)
            startActivity(intent)
        }
    }
}
