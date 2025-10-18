package com.ahmedhgabr.qurio.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmedhgabr.qurio.QurioApplication
import com.ahmedhgabr.qurio.databinding.FragmentGameBinding
import com.ahmedhgabr.qurio.presenter.entity.question.Difficulty
import com.ahmedhgabr.qurio.presenter.entity.question.Question
import com.ahmedhgabr.qurio.presenter.game.GamePresenter
import com.ahmedhgabr.qurio.presenter.game.GamePresenterI
import com.ahmedhgabr.qurio.ui.BaseFragment
import javax.inject.Inject

class GameFragment : BaseFragment<FragmentGameBinding, GameView, GamePresenter>(), GameView  {

    @Inject
    lateinit var presenter: GamePresenterI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as QurioApplication).appComponent.inject(this)
        presenter.attachView(this)
    }

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGameBinding {
        return FragmentGameBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        val categoryId = GameFragmentArgs.fromBundle(requireArguments()).categoryId
        // TODO: Make difficulty selectable
        presenter.loadQuestions(12, categoryId, Difficulty.MEDIUM.value,)
    }

    override fun showQuestions(questions: List<Question>) {
        binding.questionText.text = questions[0].question
    }


}