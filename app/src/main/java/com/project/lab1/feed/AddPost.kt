package com.project.lab1.feed

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.project.lab1.R
import com.project.lab1.feed.models.FeedItem

class AddPost : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)
//        setSupportActionBar(findViewById(R.id.toolbar))
//

        var posts = intent.getSerializableExtra("posts") as Array<FeedItem>
        var newPost = FeedItem(
            "user4",
            "HAHa funny4",
            "https://images.unsplash.com/photo-1505673542670-a5e3ff5b14a3?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"
        )

        posts += newPost

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val intent = Intent(this, FeedActivity::class.java)
            intent.putExtra("posts", posts);
            startActivity(intent)
        }

//        addPostButton.setOnClickListener {
//            val intent = Intent(this, AddPost::class.java)
//            intent.putExtra("posts", posts);
//            startActivity(intent)
//        }
    }
}
