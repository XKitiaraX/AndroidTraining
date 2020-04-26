package com.example.buttonstextviewedittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val marsGravity = 0.38
    val venusGravity = 0.91
    val jupiterGravity = 2.34

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var weight = ptWeight.text

        btnShowWeight.setOnClickListener {
            //var result = calculateWeight(weight.toString().toDouble())

            //tvResult.text = result.toString()
        }

        cbMars.setOnClickListener(this)
        cbJupiter.setOnClickListener(this)
        cbVenus.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked: Boolean = v.isChecked

        when(v.id) {
//            R.id.cbMars -> if (isChecked) {Log.d("Setup Mars", "Mars")}
//            R.id.cbVenus -> if (isChecked) {Log.d("Setup Venus", "Venus")}
//            R.id.cbJupiter -> if (isChecked) {Log.d("Setup Jupiter", "Jupiter")}
            R.id.cbMars -> if (isChecked && !TextUtils.isEmpty(ptWeight.text.toString()))
                                {
                                    calculateWeight(ptWeight.text.toString().toDouble(), v)
                                    cbVenus.isChecked = false
                                    cbJupiter.isChecked = false
                                }
            R.id.cbVenus -> if (isChecked && !TextUtils.isEmpty(ptWeight.text.toString()))
                                {
                                    calculateWeight(ptWeight.text.toString().toDouble(), v)
                                    cbMars.isChecked = false
                                    cbJupiter.isChecked = false
                                }
            R.id.cbJupiter -> if (isChecked && !TextUtils.isEmpty(ptWeight.text.toString()))
                                {
                                    calculateWeight(ptWeight.text.toString().toDouble(), v)
                                    cbVenus.isChecked = false
                                    cbMars.isChecked = false
                                }
        }
    }

    fun calculateWeight(earthWeight: Double, checkBox: CheckBox) {
        var result: Double?
        when(checkBox.id) {
            R.id.cbMars -> {
                result = earthWeight * marsGravity
                tvResult.text = "Weight is " + result.format(2) + " on Mars"
            }
            R.id.cbJupiter -> {
                result = earthWeight * jupiterGravity
                tvResult.text = "Weight is " + result.format(2) + " on Jupiter"
            }
            R.id.cbVenus -> {
                result = earthWeight * venusGravity
                tvResult.text = "Weight is " + result.format(2) + " on Venus"
            }
            else -> {
                result = earthWeight
                tvResult.text = "Weight is " + result.format(2) + " on Earth"
            }
        }

    }

    fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)
}
