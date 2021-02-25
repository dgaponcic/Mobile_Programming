package com.project.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.project.lab1.feed.FeedActivity
import com.project.lab1.feed.models.FeedItem
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var posts = intent.getSerializableExtra("posts")

        val messageText: TextView = findViewById(R.id.messageText)
        if (posts == null) {
            posts = arrayOf(
                    FeedItem(
                            "user1",
                            "HAHa funny",
                            "https://images.unsplash.com/photo-1505673542670-a5e3ff5b14a3?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
                    ),
                    FeedItem(
                            "user2",
                            "HAHa funny2",
                            "https://images.unsplash.com/photo-1612240498936-65f5101365d2?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
                    ),
                    FeedItem(
                            "user3",
                            "HAHa funny3",
                            "https://images.unsplash.com/photo-1614092859936-a1ec05a607e4?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80"
                    )
            )
        }

        recyclerListExampleButton.setOnClickListener {
            val intent = Intent(this, FeedActivity::class.java)
            intent.putExtra("posts", posts);
            startActivity(intent)
        }
    }
}

