package com.example.namegame

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.namegame.model.NameGameResponse
import com.example.namegame.repository.NameGameRepository
import com.example.namegame.service.ServiceFactory
import com.example.namegame.viewmodel.PracticeActivityViewModel
import com.example.namegame.viewmodel.PracticeModeActivityViewModelFactory

class PracticeModeActivity : AppCompatActivity() {
    private val viewModel: PracticeActivityViewModel by viewModels {
        PracticeModeActivityViewModelFactory(NameGameRepository(ServiceFactory.createService()))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice_mode)

        viewModel.getNameGame().observe(this, { nameGameResponse ->
            when (nameGameResponse) {
                is NameGameResponse.Success -> {
                    nameGameResponse.data.subList(0, 6).forEachIndexed() { index, data ->
                        val resourceId = when (index) {
                            0 -> R.id.image1
                            1 -> R.id.image2
                            2 -> R.id.image3
                            3 -> R.id.image4
                            4 -> R.id.image5
                            else -> R.id.image6
                        }
                        val imageView = findViewById<ImageView>(resourceId)
                        fetchImage(data.headshot.url, imageView)
                    }
                }

                is NameGameResponse.Failure -> {
                    val message = nameGameResponse.exception
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                }

                is NameGameResponse.Loading -> {
                    Toast.makeText(this, "Loading Data...", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun fetchImage(imageUrl: String, imageView: ImageView) {
        Glide.with(this)
            .load(imageUrl)
            .into(imageView)
    }
}