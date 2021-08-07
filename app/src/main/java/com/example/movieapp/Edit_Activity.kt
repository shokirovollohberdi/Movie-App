package com.example.movieapp

import Cash.MySharePreference
import RvModels.RvModels
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movieapp.databinding.ActivityEditBinding

class Edit_Activity : AppCompatActivity() {
    lateinit var list: ArrayList<RvModels>
    lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        MySharePreference.init(this)

        list = ArrayList()
        list = MySharePreference.obektString

        val model = intent.getSerializableExtra("model")
        val position = intent.getIntExtra("position", -1)

        if (model != null && position != -1) {
            binding.edtName.setText(list[position].name)
            binding.edtAuthors.setText(list[position].actor)
            binding.edtAbout.setText(list[position].info)
            binding.edtData.setText(list[position].date)
        }
        binding.btnEdt.setOnClickListener {
            val name = binding.edtName.text.toString().trim()
            val actors = binding.edtAuthors.text.toString().trim()
            val about = binding.edtAbout.text.toString().trim()
            val date = binding.edtData.text.toString().trim()
            if (name != "" && actors != "" && about != "" && date != "") {
                list = MySharePreference.obektString
                list.remove(list[position])
                list.add(RvModels(name, actors, date, about))
                MySharePreference.obektString = list
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "the data is incomplete", Toast.LENGTH_SHORT).show()
            }
        }

    }
}