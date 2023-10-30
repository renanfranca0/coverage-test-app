package com.example.coveragetestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.coveragetestapp.databinding.ActivityMainBinding

internal class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        updateCounter()
        setupClicks()
    }

    private fun setupClicks() {
        binding.incrementButton.setOnClickListener {
            counter += 1
            updateCounter()
        }

        binding.decrementButton.setOnClickListener {
            counter -= 1
            updateCounter()
        }

        binding.navigateToPicPayButton.setOnClickListener {
            navigateToPicPay()
        }

        binding.navigateToSecond.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    private fun updateCounter() {
        binding.counterTextView.text = counter.toString()
    }

    private fun navigateToPicPay() {
        val intent = packageManager.getLaunchIntentForPackage("com.picpay.debug")
        startActivity(intent)
    }
}