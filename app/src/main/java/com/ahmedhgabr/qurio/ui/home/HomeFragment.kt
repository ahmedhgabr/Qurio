package com.ahmedhgabr.qurio.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmedhgabr.qurio.QurioApplication
import com.ahmedhgabr.qurio.databinding.FragmentHomeBinding
import com.ahmedhgabr.qurio.presenter.HomePresenter
import com.ahmedhgabr.qurio.presenter.HomePresenterI
import com.ahmedhgabr.qurio.presenter.entity.Category
import com.ahmedhgabr.qurio.ui.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeView, HomePresenter>(), HomeView {

    @Inject
    lateinit var presenter: HomePresenterI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as QurioApplication).appComponent.inject(this)
        presenter.attachView(this)
    }

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }


//    override fun initPresenter(
//        inflater: LayoutInflater,
//        container: ViewGroup?
//    ): HomePresenter {
//        return HomePresenter(
//            this,
//            repo = triviaRepository
//        )
//    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        presenter.loadCategories()
    }

    override fun showCategories(categories: List<Category>) {
        binding.questionText.text = categories.toString()
    }
}