package com.project.lab1.feed

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.project.lab1.R
import com.project.lab1.feed.models.FeedItem

class AddPost : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            var posts = intent.getSerializableExtra("posts") as Array<FeedItem>

            val postUsername = findViewById<TextView>(R.id.AddPostUsername).text.toString()
            val postDescription = findViewById<TextView>(R.id.AddPostDescription).text.toString()
            val postImage = findViewById<TextView>(R.id.AddPostImage).text.toString()
            if (!postUsername.isNullOrEmpty() && !postDescription.isNullOrEmpty() && !postImage.isNullOrEmpty()) {
                var newPost = FeedItem(
                        postUsername,
                        postDescription,
                        postImage
                )
                posts = arrayOf(newPost) + posts

                val intent = Intent(this, FeedActivity::class.java)
                intent.putExtra("posts", posts);
                startActivity(intent)
            }
        }

    }
}
