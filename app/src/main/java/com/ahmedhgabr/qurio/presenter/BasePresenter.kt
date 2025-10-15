package com.ahmedhgabr.qurio.presenter

import android.util.Log
import com.ahmedhgabr.qurio.model.TriviaRepositoryImpl
import com.ahmedhgabr.qurio.presenter.repository.TriviaRepository
import com.ahmedhgabr.qurio.ui.BaseView
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BasePresenter {
    private val repository: TriviaRepository = TriviaRepositoryImpl()
    lateinit var view: BaseView
    fun getInfo() {
        val data = repository.getInfo()
        view.onInfoReceived(data)
    }

    fun getWisdom() {
        tryToExecute(
            function = {
                val data = repository.getRandomInfo()
                view.onRandomInfoReceived(data)
            },
            onSuccess = {},
            onError = view::onError
        )
    }

    protected fun <T> tryToExecute(
        function: suspend () -> T,
        onSuccess: ((T) -> Unit)? = null,
        onError: (Throwable) -> Unit,
        scope: CoroutineScope = CoroutineScope(Dispatchers.Main),
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ): Job = runWithErrorHandling(onError, scope, dispatcher) {
        function().let { result ->
            onSuccess?.invoke(result)
        }
    }

    private fun runWithErrorHandling(
        onError: (Throwable) -> Unit,
        scope: CoroutineScope,
        dispatcher: CoroutineDispatcher,
        function: suspend () -> Unit,
    ): Job {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.d("BasePresenter", "Exception caught: ${throwable::class.simpleName}", throwable)
            onError(throwable)
        }
        return scope.launch(dispatcher + coroutineExceptionHandler) {
            function()
        }
    }

}