package com.example.gptchatbotapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gptchatbotapp.ui.home.HomeFragment
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.ArrayList
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

class GptActivity : AppCompatActivity() {

    private lateinit var recycler_view: RecyclerView
    private lateinit var tv_welcome: TextView
    private lateinit var et_msg: EditText
    private lateinit var btn_send: ImageButton

    private var messageList: MutableList<Message> = ArrayList()
    private lateinit var messageAdapter: MessageAdapter

    private val JSON = "application/json; charset=utf-8".toMediaType()
    private val client = OkHttpClient()

    private val MY_SECRET_KEY = BuildConfig.GPT_KEY
    private lateinit var prompt: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gpt)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        prompt = intent.getStringExtra("prompt") ?: ""

        recycler_view = findViewById(R.id.recycler_view)
        tv_welcome = findViewById(R.id.tv_welcome)
        et_msg = findViewById(R.id.et_msg)
        btn_send = findViewById(R.id.btn_send)

        recycler_view.setHasFixedSize(true)
        val manager = LinearLayoutManager(this)
        manager.stackFromEnd = true
        recycler_view.layoutManager = manager

        messageList = ArrayList()
        messageAdapter = MessageAdapter(messageList)
        recycler_view.adapter = messageAdapter

        btn_send.setOnClickListener(View.OnClickListener {
            val question = et_msg.text.toString().trim()
            addToChat(question, Message.SENT_BY_ME)
            et_msg.text.clear()
            callAPI(question)
            tv_welcome.visibility = View.GONE
        })
    }

    private fun addToChat(message: String, sentBy: String) {
        runOnUiThread {
            messageList.add(Message(message, sentBy))
            messageAdapter.notifyDataSetChanged()
            recycler_view.smoothScrollToPosition(messageAdapter.itemCount)
        }
    }

    private fun addResponse(response: String) {
        messageList.removeAt(messageList.size - 1)
        addToChat(response, Message.SENT_BY_BOT)
    }

    private fun callAPI(question: String) {
        messageList.add(Message("...", Message.SENT_BY_BOT))

        val jsonObject = JSONObject()
        try {
            jsonObject.put("model", "text-davinci-003")
            jsonObject.put("prompt", prompt + question + "너는 \"예\", \"아니오\", \"정답입니다.\", \"제대로 된 질문을 해주십시오\"만 말할 수 있다.")
            jsonObject.put("max_tokens", 50)
            jsonObject.put("temperature", 0)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        val body = jsonObject.toString().toRequestBody(JSON)
        val request = Request.Builder()
            .url("https://api.openai.com/v1/completions")
            .header("Authorization", "Bearer $MY_SECRET_KEY")
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                addResponse("Failed to load response due to " + e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    var jsonObject: JSONObject? = null
                    try {
                        jsonObject = JSONObject(response.body!!.string())
                        val jsonArray = jsonObject.getJSONArray("choices")
                        val result = jsonArray.getJSONObject(0).getString("text")
                        addResponse(result.trim())
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                } else {
                    addResponse("Failed to load response due to " + response.body!!.string())
                }
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {

                // HomeFragment로 이동
                val fragmentManager = supportFragmentManager
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, HomeFragment())

                // 뒤로가기 버튼이 클릭되었을 때 현재 Activity를 종료
                finish()

                transaction.addToBackStack(null)
                transaction.commit()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
