package com.maxataliyev_01.floatingactionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.maxataliyev_01.floatingactionbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val rotateOpen:Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.rotate_open_anim) }
    private val rotateClose:Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.rotate_close_anim) }
    private val fromBottom:Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.from_bottom_anim) }
    private val toBottom:Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.to_bottom_anim) }
    private var clicked=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.floatingActionButton.setOnClickListener {
            onAddButtonClicked()
        }
        binding.editButton.setOnClickListener {
            Toast.makeText(this, "Edit Button Clicked", Toast.LENGTH_SHORT).show()
        }
        binding.imageButton.setOnClickListener {
            Toast.makeText(this, "Image Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }


    private fun setVisibility(clicked:Boolean) {
        if (!clicked){
            binding.editButton.visibility=View.VISIBLE
            binding.imageButton.visibility=View.VISIBLE
        }else{
            binding.editButton.visibility=View.INVISIBLE
            binding.imageButton.visibility=View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked){
            binding.editButton.startAnimation(fromBottom)
            binding.imageButton.startAnimation(fromBottom)
            binding.floatingActionButton.startAnimation(rotateOpen)
        }else{
            binding.editButton.startAnimation(toBottom)
            binding.imageButton.startAnimation(toBottom)
            binding.floatingActionButton.startAnimation(rotateClose)
        }
    }

    private fun setClickable(clicked: Boolean) {
        if (!clicked){
            binding.editButton.isClickable=true
            binding.imageButton.isClickable=true
        }else{
            binding.editButton.isClickable=false
            binding.imageButton.isClickable=false
        }

    }


}