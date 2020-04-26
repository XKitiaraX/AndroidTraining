package com.example.animalbios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main.view.ivCheetah
import kotlinx.android.synthetic.main.activity_main.view.ivLion

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cheetah = ivCheetah
        var lion = ivLion

        var intent =

        //register our views to receive onClickListener events
        cheetah.setOnClickListener(this)
        lion.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        var intent = Intent(this, Details::class.java)

        when(v!!.id) {
            ivCheetah.id -> {
                Toast.makeText(this, "Cheetah", Toast.LENGTH_LONG).show()
                intent.putExtra("animal","Cheetah")
                startActivity(intent)
            }
            ivLion.id -> {
                Toast.makeText(this, "Lion", Toast.LENGTH_LONG).show()
                intent.putExtra("animal","Lion")
                startActivity(intent)
            }
        }
    }
}
