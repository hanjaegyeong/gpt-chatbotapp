package com.example.gptchatbotapp

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChatActivity : AppCompatActivity() {

    private lateinit var memoEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_notifications)

        memoEditText = findViewById(R.id.memoEditText)
    }

    fun showMemoDialog(view: View) {
        val memoText = memoEditText.text.toString().trim()

        if (memoText.isNotEmpty()) {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("메모 내용")
            alertDialogBuilder.setMessage(memoText)
            alertDialogBuilder.setPositiveButton("확인") { dialog, _ ->
                dialog.dismiss()
            }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }
}
