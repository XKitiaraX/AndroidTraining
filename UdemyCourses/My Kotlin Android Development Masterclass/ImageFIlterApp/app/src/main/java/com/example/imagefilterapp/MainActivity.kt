package com.example.imagefilterapp

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorArray = arrayOf(Color.BLACK, Color.CYAN, Color.BLUE, Color.GREEN, Color.DKGRAY, Color.GRAY, Color.TRANSPARENT, Color.RED, Color.WHITE)

        ivCat.setOnClickListener {

            ivCat.setColorFilter(colorArray[getRandom(colorArray.size)], PorterDuff.Mode.OVERLAY)

        }
    }

    fun getRandom(arraySize: Int): Int {

        var rand = Random
        var randomNum = rand.nextInt(arraySize)

        return randomNum

    }

}
