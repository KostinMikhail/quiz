package com.kostlin.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val spinner = view.findViewById<Spinner>(R.id.spinner)
        val items = arrayOf("легко", "средне", "сложно")
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, items)
        spinner.adapter = adapter
        spinner?.setSelection(0) // по умолчанию - лёгкий уровень
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // val selectedDifficultyId = difficultyIds[position]
                // тут будем по сложности передавать интент в квизфрагмент
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinner?.setSelection(0)
            }
        }

        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val QuizFragment = QuizFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, QuizFragment)
            transaction?.addToBackStack(null)
            transaction?.commit()

}


        return view
    }


}


