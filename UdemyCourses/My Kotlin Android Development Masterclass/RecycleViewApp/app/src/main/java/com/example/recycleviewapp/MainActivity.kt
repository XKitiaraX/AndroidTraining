package com.example.recycleviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewapp.data.PersonListAdapter
import com.example.recycleviewapp.model.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapter: PersonListAdapter? = null
    private var personList: ArrayList<Person>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personList = ArrayList<Person>()
        layoutManager = LinearLayoutManager(this)
        adapter = PersonListAdapter(personList!!, this)

        //setup list (RecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        //load data
        for (i in 0..20) {
            val person = Person()
            person.name = "Paula" + i
            person.tweet = "Que bonita es mi novia" + i
            personList!!.add(person)

        }
        adapter!!.notifyDataSetChanged()
    }
}
