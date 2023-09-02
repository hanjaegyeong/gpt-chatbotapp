package com.example.myapplication

import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding // 패키지 이름을 실제로 사용하는 패키지로 변경

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val chatLayout = binding.chatLayout
        val messageEditText = binding.messageEditText
        val sendButton = binding.sendButton

        sendButton.setOnClickListener {
            // EditText에서 입력한 메시지 가져오기
            val messageText = messageEditText.text.toString().trim()

            if (messageText.isNotEmpty()) {
                // 새로운 TextView를 생성하고 메시지 표시
                val messageView = TextView(this)
                messageView.text = messageText
                messageView.gravity = Gravity.START

                // 메시지를 채팅 레이아웃에 추가
                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                layoutParams.setMargins(0, 0, 0, 16) // 메시지 간의 간격 조정
                messageView.layoutParams = layoutParams
                chatLayout.addView(messageView)

                // EditText 비우기
                messageEditText.text.clear()
            }
        }
    }
}
