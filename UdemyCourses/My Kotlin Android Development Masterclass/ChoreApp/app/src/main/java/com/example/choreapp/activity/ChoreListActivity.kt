package com.example.choreapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.choreapp.R
import com.example.choreapp.data.ChoreDatabaseHandler
import com.example.choreapp.data.ChoreListAdapter
import com.example.choreapp.model.Chore
import kotlinx.android.synthetic.main.activity_chore_list.*

class ChoreListActivity : AppCompatActivity() {
    private var adapter: ChoreListAdapter? = null
    private var choreList: ArrayList<Chore>? = null
    private var choreListItems: ArrayList<Chore>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    var dbHandler: ChoreDatabaseHandler? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chore_list)

        dbHandler = ChoreDatabaseHandler(this)

        choreList = ArrayList<Chore>()
        layoutManager = LinearLayoutManager(this)
        adapter = ChoreListAdapter(choreListItems!!, this)

        // setup list = recyclerview
        recyclerViewId.layoutManager = layoutManager
        recyclerViewId.adapter = adapter

        //Chore list view
        choreList = dbHandler!!.readChores()

        adapter!!.notifyDataSetChanged()

        for (c in choreList!!.iterator()) {
            val chore = Chore()
            chore.choreName = c.choreName
            chore.assignedBy = c.assignedBy
            chore.assignedTo = c.assignedTo
            chore.showHumanDate(c.timeAssigned!!)

            choreListItems!!.add(chore)

        }

    }
}
