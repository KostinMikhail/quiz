package com.kostlin.quiz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity


private var mActivity: AppCompatActivity? = null

class QuizFragment : Fragment() {


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as? AppCompatActivity
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onDetach() {
        super.onDetach()
        mActivity = null
    }

}