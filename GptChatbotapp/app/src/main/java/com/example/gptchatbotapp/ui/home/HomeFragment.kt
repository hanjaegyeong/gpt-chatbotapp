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
            intent.putExtra("prompt", "너는 \"예\", \"아니오\", \"정답입니다.\", \"제대로 된 질문을 해주십시오\"만 말할 수 있어." +
                    "맞는 질문에는 \"예\", 틀리면 \"아니오\"라고 답하고 [정답]을 빠짐 없이 맞히면 \"정답입니다\"라고 답해" +
                    "질문이 아닌 말에는 \"제대로 된 질문을 해주십시오.\"라고 말해." +
                    "[내용] A와 B와 C는 오랜 친구 사이다.\n" +
                    "A의 생일날 A는 B,C를 집에 초대했다.\n" + 
                    "A의 집에 도착한 B,C는 A에게 준비한 선물을 주었다.\n" +
                    "B,C는 불을 끈 다음 초를 붙인후 생일축하 노래를 부르고 박수치며 A의 생일을 축하했다.\n" +
                    "그후 A는 B,C를 칼로 찔러 죽였다.\n" +
                    "[정답] ABC는 과거에 조난을 당한 적이 있다.\n" +
                    "먹을 것이 없어서 셋은 팔을 하나씩 잘라서 먹으며 버티기로 했다.\n" +
                    "시각장애를 가지고 있던 A는 모두의 팔 한 짝씩을 잘라서\n" +
                    "음식을 만들었다는 B와 C의 말을 믿고 음식을 먹으며 버텼다.\n" +
                    "그들은 그 후 무사히 구조되었고 A의 생일 파티 날이 되었다.\n" +
                    "A는 B와 C의 축하 인사와 박수 소리를 들었는데 각각 두 사람의 박수 소리가 들렸다.\n" +
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
