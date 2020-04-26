package com.example.shareprefsapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val PREFS_NAME = "myPrefs"
    var myPref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener {
            myPref = getSharedPreferences(PREFS_NAME, 0)
            var editor: SharedPreferences.Editor = (myPref as SharedPreferences?)!!.edit()

            if (!TextUtils.isEmpty(etxtEnterInfo.text.toString())) {
                var message = etxtEnterInfo.text.toString()
                editor.putString("message", message)
                editor.commit()

            } else {
                Toast.makeText(this, "Please Enter Something", Toast.LENGTH_LONG).show()
            }
        }


        //Get data back

        var dataBack: SharedPreferences = getSharedPreferences(PREFS_NAME, 0)

        if (dataBack.contains("message")) {
            var myMessage = dataBack.getString("message", "Not found!")

            txtvResult.text = myMessage
        }

    }
}
