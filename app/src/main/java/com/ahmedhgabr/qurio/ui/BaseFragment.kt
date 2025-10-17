package com.ahmedhgabr.qurio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.ahmedhgabr.qurio.presenter.BasePresenter

abstract class BaseFragment<VB : ViewBinding, VIEW : BaseView, PRESENTER : BasePresenter<VIEW>> :
    Fragment() {

    private lateinit var _binding: VB
    protected val binding get() = _binding

    protected abstract fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = initViewBinding(inflater, container)
        return binding.root
    }

    fun startLoading() {
        // TODO("Show loading animation")
    }

    fun endLoading() {
        // TODO("Hide loading animation")
    }

    fun showError(message: Throwable) {
        // TODO("Not yet implemented")
    }
}
