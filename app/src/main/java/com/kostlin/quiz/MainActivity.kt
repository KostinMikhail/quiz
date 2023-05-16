package com.kostlin.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner







class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val difficulties = arrayOf("легко", "средне", "сложно")
        val difficultyIds = intArrayOf(0, 1, 2)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, difficulties)
        val spinner = findViewById<Spinner>(R.id.spinner)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.setSelection(0) // по умолчанию - лёгкий уровень
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedDifficultyId = difficultyIds[position]
                // тут будем по сложности передавать интент в квизфрагмент
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

            val startQuizButton = findViewById<Button>(R.id.button)
            startQuizButton.setOnClickListener {
                val quizFragment = QuizFragment()
                val fragmentManager = supportFragmentManager
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, quizFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }



















    }

}