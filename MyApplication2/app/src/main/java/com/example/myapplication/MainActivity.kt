package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding // "yourpackage"를 실제 패키지 이름으로 변경

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 버튼 클릭 이벤트 처리
        binding.button.setOnClickListener {
            // EditText에서 입력한 텍스트 가져오기
            val inputText = binding.editText.text.toString()

            // TextView에 입력한 텍스트 설정
            binding.textView.text = inputText
        }
    }
}
