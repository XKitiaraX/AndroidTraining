package com.example.choreapp.activity

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.choreapp.R
import com.example.choreapp.data.ChoreDatabaseHandler
import com.example.choreapp.data.ChoreListAdapter
import com.example.choreapp.model.Chore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var dbHandler: ChoreDatabaseHandler? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = ChoreDatabaseHandler(this)

//        var chore = Chore()
//        chore.choreName = "Clean Room 2"
//        chore.assignedTo = "James"
//        chore.assignedBy = "Carlos"
//
//        dbHandler!!.createChore(chore)
//
//
//        //Read from database
//        var chores: Chore = dbHandler!!.readAChore(2)
//
//        Log.d("Item", chore.choreName)

        saveChore.setOnClickListener {


            if (!TextUtils.isEmpty(enterChoreId.text.toString())
                && !TextUtils.isEmpty(assignedById.text.toString())
                && !TextUtils.isEmpty(assingToId.text.toString())) {

                // save to database

                var chore = Chore()
                chore.choreName = enterChoreId.text.toString()
                chore.assignedTo = assingToId.text.toString()
                chore.assignedBy = assignedById.text.toString()

                saveToDB(chore)

                Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, ChoreListActivity::class.java))

            } else {
                Toast.makeText(this, "Please enter a chore", Toast.LENGTH_LONG).show()
            }

        }

    }

    fun saveToDB(chore: Chore) {
        dbHandler!!.createChore(chore)
    }
}
