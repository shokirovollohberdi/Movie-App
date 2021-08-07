package com.example.movieapp

import Cash.MySharePreference
import RvAdapters.RvAdapters
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.movieapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var rvAdapters: RvAdapters
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharePreference.init(this)
        var list = MySharePreference.obektString
        rvAdapters = RvAdapters(this, list)
        rvAdapters.notifyDataSetChanged()
        binding.rv.adapter = rvAdapters
        rvAdapters.notifyDataSetChanged()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_option -> {
                startActivity(Intent(this, AddMovio::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onResume() {
        MySharePreference.init(this)
        var list = MySharePreference.obektString
        rvAdapters = RvAdapters(this, list)
        rvAdapters.notifyDataSetChanged()
        binding.rv.adapter = rvAdapters
        rvAdapters.notifyDataSetChanged()
        super.onResume()
    }

}