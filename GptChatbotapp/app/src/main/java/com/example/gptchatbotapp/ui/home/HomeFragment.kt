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
            intent.putExtra("prompt", "너는 \"예\", \"아니오\", \"정답입니다.\", \"제대로 된 질문을 해주십시오\"로만 말할 수 있다. " +
                    "사용자가 [정답]을 맞히면 \"정답입니다\"라고 하고, 부분적으로 맞히면 \"예\", 틀리면 \"아니오\"라고 답해라.\n" +
                    "정답: " +
                    "시각장애를 가지고 있던 A는 모두의 팔 한 짝씩을 잘라서 음식을 만들었다는 B와 C의 말을 믿고 음식을 먹으며 버텼다. " +
                    "그런데 A는 B와 C의 박수 소리가 들려서 살해를 했다.\n" +
                    "사용자의 질문: ") // "prompt" 키에 값을 전달
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
