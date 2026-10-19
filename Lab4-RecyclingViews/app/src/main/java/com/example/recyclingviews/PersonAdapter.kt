package com.example.recyclingviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter: connects the list of Person objects to the RecyclerView
class PersonAdapter(private val personList: List<Person>) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    // Called only when a NEW row view is needed (inflates item_person.xml)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    // Called every time a (possibly recycled) row is shown: puts the data into it
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = personList[position]
        holder.personName.text = person.name
    }

    override fun getItemCount() = personList.size

    // ViewHolder: caches the TextView so findViewById isn't repeated on every scroll
    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView = itemView.findViewById(R.id.personName)
    }
}
