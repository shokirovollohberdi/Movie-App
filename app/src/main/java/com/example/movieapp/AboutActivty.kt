package com.example.movieapp

import Cash.MySharePreference
import RvModels.Position
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieapp.databinding.ActivityAboutActivtyBinding

class AboutActivty : AppCompatActivity() {
    lateinit var binding: ActivityAboutActivtyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAboutActivtyBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        MySharePreference.init(this)
        var list = MySharePreference.obektString
        val position = Position.position

        binding.name.text = "Movie Name: ${list[position].name}"
        binding.about.text = "About movie: ${list[position].info}"
        binding.actor.text = "Movie Authors: ${list[position].actor}"
        binding.date.text = "Date:  "+list[position].date

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}