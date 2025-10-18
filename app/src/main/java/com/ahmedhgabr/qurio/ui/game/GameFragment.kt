package com.ahmedhgabr.qurio.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.parseAsHtml
import com.ahmedhgabr.qurio.QurioApplication
import com.ahmedhgabr.qurio.databinding.FragmentGameBinding
import com.ahmedhgabr.qurio.presenter.entity.question.Difficulty
import com.ahmedhgabr.qurio.presenter.entity.question.Question
import com.ahmedhgabr.qurio.presenter.game.GamePresenter
import com.ahmedhgabr.qurio.presenter.game.GamePresenterI
import com.ahmedhgabr.qurio.ui.BaseFragment
import javax.inject.Inject
import androidx.core.graphics.toColorInt

class GameFragment : BaseFragment<FragmentGameBinding, GameView, GamePresenter>(), GameView {

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
        presenter.loadQuestions(12, categoryId, Difficulty.MEDIUM.value)

        binding.answer1.setOnClickListener {
            binding.answer1.setBackgroundColor("#e12f32".toColorInt())
        }
        binding.answer2.setOnClickListener {
            binding.answer2.setBackgroundColor("#e12f32".toColorInt())
        }
        binding.answer3.setOnClickListener {
            binding.answer3.setBackgroundColor("#e12f32".toColorInt())
        }

        binding.correctAnswer.setOnClickListener {
            binding.correctAnswer.setBackgroundColor("#739e61".toColorInt())
        }

        binding.checkButton
            .setOnClickListener {
                binding.correctAnswer.setBackgroundColor(android.graphics.Color.GREEN)
            }
        binding.skipButton
            .setOnClickListener {
                onNextQuestionClicked()
            }
    }

    override fun onNextQuestionClicked() {
        binding.answer1.setBackgroundColor(android.graphics.Color.TRANSPARENT)
        binding.answer2.setBackgroundColor(android.graphics.Color.TRANSPARENT)
        binding.answer3.setBackgroundColor(android.graphics.Color.TRANSPARENT)
        binding.correctAnswer.setBackgroundColor(android.graphics.Color.TRANSPARENT)
        presenter.showNextQuestion()
    }

    override fun showNextQuestion(question: Question) {
        binding.questionText.text = question.question.parseAsHtml().toString()
        setOption(question.options, binding.answer1, 0)
        setOption(question.options, binding.answer2, 1)
        setOption(question.options, binding.answer3, 2)
        binding.correctAnswer.text = question.correctAnswer.parseAsHtml().toString()
    }

    override fun goBack() {
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }


    private fun setOption(opts: List<String>, view: android.widget.TextView, index: Int) {
        if (index < opts.size && !opts[index].isNullOrBlank()) {
            view.visibility = View.VISIBLE
            view.text = opts[index]!!.parseAsHtml().toString()
        } else {
            view.visibility = View.GONE
        }
    }


}