package com.project.lab1.presentation.feedImage

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.project.lab1.R
import com.project.lab1.databinding.ActivityImagePostBinding
import com.project.lab1.network.APICommunication
import com.project.lab1.presentation.feedImage.models.FeedImage
import com.squareup.picasso.Picasso

class ImageActivity : ImageInput, AppCompatActivity() {

    private lateinit var binding: ActivityImagePostBinding
    private lateinit var link: String;
    private var presenter = ImagePresenter(this, APICommunication())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImagePostBinding.inflate(layoutInflater)
        this.setVisible(false)
        setContentView(binding.root)
        val id = intent.getSerializableExtra("id") as String


        val addButton: Button = binding.addNote
        val pref = getSharedPreferences("tokens", MODE_PRIVATE)
        val token = pref.getString("auth", "")

        if (token != null) {
            presenter.getImage(token, id)
        }

        addButton.setOnClickListener {
            if (token != null) {
                presenter.addNote(token, link)
            }
        }
    }

    override fun updateUI(data: FeedImage) {
        link = data.url
        binding.imageId.setText(data.user)
        binding.imageDescription.setText(data.alt_description)
        Picasso.get()
            .load(data.url)
            .error(R.drawable.placeholder)
            .fit()
            .into(binding.image)
        this.setVisible(true)
    }
}
