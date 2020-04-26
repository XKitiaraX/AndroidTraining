package com.example.animalbios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class Details : AppCompatActivity() {

    val cheetahInfo = "Tienen manchitas"
    val lionInfo = "Tienen pelazo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var animal = intent.extras
        if (animal != null) {
            if (animal.get("animal") == "Cheetah") {
                ivDetails.setImageDrawable(application.getDrawable(R.drawable.cheetah))
                tvDetails.text = cheetahInfo
            }
            else {
                ivDetails.setImageDrawable(application.getDrawable(R.drawable.lion))
                tvDetails.text = lionInfo
            }
        }
    }
}
