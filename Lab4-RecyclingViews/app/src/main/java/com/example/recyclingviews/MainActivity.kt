package com.example.recyclingviews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        // LayoutManager: positions items in a vertical scrolling list
        recyclerView.layoutManager = LinearLayoutManager(this)

        // List of 50 random names
        val people = listOf(
            Person("John Doe"),
            Person("Jane Smith"),
            Person("Michael Johnson"),
            Person("Emily Davis"),
            Person("David Wilson"),
            Person("Sarah Brown"),
            Person("Daniel White"),
            Person("Anna Taylor"),
            Person("James Lee"),
            Person("Olivia Harris"),
            Person("Emma Clark"),
            Person("Ethan Lewis"),
            Person("Sophia Martinez"),
            Person("Liam Allen"),
            Person("Isabella Young"),
            Person("Noah Hall"),
            Person("Mia King"),
            Person("Aiden Scott"),
            Person("Chloe Adams"),
            Person("Mason Baker"),
            Person("Grace Nelson"),
            Person("Lucas Carter"),
            Person("Ava Mitchell"),
            Person("Logan Perez"),
            Person("Ella Roberts"),
            Person("Alexander Turner"),
            Person("Madison Phillips"),
            Person("Jacob Walker"),
            Person("Lily Ward"),
            Person("William Hughes"),
            Person("Zoe Murphy"),
            Person("Benjamin Foster"),
            Person("Layla Simmons"),
            Person("Jackson Reed"),
            Person("Scarlett Brooks"),
            Person("Oliver Bennett"),
            Person("Amelia Gray"),
            Person("Henry Bryant"),
            Person("Hannah Russell"),
            Person("Samuel Peterson"),
            Person("Victoria Powell"),
            Person("Sebastian Howard"),
            Person("Leah Morgan"),
            Person("Jack Kim"),
            Person("Ellie Cox"),
            Person("Owen Kelly"),
            Person("Violet Richardson"),
            Person("Caleb Cooper"),
            Person("Lucy Reed"),
            Person("Carter Jenkins")
        )

        recyclerView.adapter = PersonAdapter(people)
    }
}
