package com.example.choreapp.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.choreapp.R
import com.example.choreapp.model.Chore

class ChoreListAdapter(private val list: ArrayList<Chore>,
                        private val context: Context): RecyclerView.Adapter<ChoreListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var choreName = itemView.findViewById(R.id.listChoreName) as TextView
        var assignedBy = itemView.findViewById(R.id.listAssignedBy) as TextView
        var assignedDate = itemView.findViewById(R.id.listDate) as TextView
        var assignedTo = itemView.findViewById(R.id.listAssignedTo) as TextView

        fun bindViews(chore: Chore) {
            choreName.text = chore.choreName
            assignedBy.text = chore.assignedBy
            assignedDate.text = chore.showHumanDate(chore.timeAssigned!!)
            assignedTo.text = chore.assignedTo
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        //Create our view from our xml file
        val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ChoreListAdapter.ViewHolder, position: Int) {

        holder?.bindViews(list[position])
    }
}