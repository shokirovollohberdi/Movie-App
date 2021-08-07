package com.example.movieapp

import Cash.MySharePreference
import RvModels.RvModels
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movieapp.databinding.ActivityAddMovioBinding

class AddMovio : AppCompatActivity() {
    lateinit var binding: ActivityAddMovioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMovioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharePreference.init(this)
        binding.btnAdd.setOnClickListener {
            var name = binding.edtName.text.toString()
            var actor = binding.edtAuthors.text.toString()
            var info = binding.edtAbout.text.toString()
            var date = binding.edtData.text.toString()

            var list = MySharePreference.obektString

            if (name!=""&&actor!=""&&info!=""&&date!=""){
                list.add(RvModels(name, actor, date, info))
                MySharePreference.obektString = list
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "the data is incomplete", Toast.LENGTH_SHORT).show()
            }

        }

    }
}