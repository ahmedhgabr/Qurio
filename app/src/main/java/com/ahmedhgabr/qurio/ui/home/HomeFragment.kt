package com.ahmedhgabr.qurio.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmedhgabr.qurio.R
import com.ahmedhgabr.qurio.databinding.FragmentHomeBinding
import com.ahmedhgabr.qurio.presenter.HomePresenter
import com.ahmedhgabr.qurio.presenter.PresenterFactory
import com.ahmedhgabr.qurio.presenter.entity.Category
import com.ahmedhgabr.qurio.ui.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeView, HomePresenter>(), HomeView {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun initPresenter(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): HomePresenter {
        val presenterFactory = PresenterFactory()
        return presenterFactory.providePresenter(this) as HomePresenter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setup()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun setup() {
        presenter.loadCategories()
    }

    override fun showCategories(categories: List<Category>) {
        binding.questionText.text = categories.toString()
    }
}