package com.example.myapplication

import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var messageEditText: EditText
    private lateinit var chatLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        chatLayout = binding.chatLayout
        messageEditText = binding.messageEditText
        val sendButton = binding.sendButton

        sendButton.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        // EditText에서 입력한 메시지 가져오기
        val messageText = messageEditText.text.toString().trim()

        if (messageText.isNotEmpty()) {
            // 사용자가 보낸 메시지는 오른쪽 정렬 및 오른쪽 말풍선
            displayMessage(messageText, Gravity.END, R.drawable.user_bubble)

            // 상대방의 응답은 좌측 정렬 및 좌측 말풍선
            val responseText = if (messageText.toLowerCase() == "hello") {
                "hello"
            } else {
                "no"
            }
            displayMessage(responseText, Gravity.START, R.drawable.opponent_bubble)

            // EditText 비우기
            messageEditText.text.clear()
        }
    }

    private fun displayMessage(message: String, gravity: Int, backgroundDrawable: Int) {
        // 새로운 TextView를 생성하고 메시지 표시
        val messageView = TextView(this)
        messageView.text = message
        messageView.gravity = gravity // 정렬 설정
        messageView.setBackgroundResource(backgroundDrawable) // 말풍선 배경 설정

        // 메시지를 채팅 레이아웃에 추가
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.gravity = gravity // layout_gravity 설정
        layoutParams.setMargins(0, 0, 0, 16) // 메시지 간의 간격 조정
        messageView.layoutParams = layoutParams
        chatLayout.addView(messageView)
    }
}

