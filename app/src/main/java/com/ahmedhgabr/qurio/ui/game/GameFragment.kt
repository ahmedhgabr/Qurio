package com.ahmedhgabr.qurio.ui.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmedhgabr.qurio.R

class GameFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val categoryId = GameFragmentArgs.fromBundle(requireArguments()).categoryId
        android.widget.Toast.makeText(
            requireContext(),
            "Category id: $categoryId",
            android.widget.Toast.LENGTH_SHORT
        ).show()

        return inflater.inflate(R.layout.fragment_game, container, false)
    }

}