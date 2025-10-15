package com.ahmedhgabr.qurio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ahmedhgabr.qurio.databinding.ActivityMainBinding
import com.ahmedhgabr.qurio.presenter.BasePresenter
import com.ahmedhgabr.qurio.ui.BaseView

class MainActivity : AppCompatActivity() , BaseView {

    lateinit var binding: ActivityMainBinding
    private val presenter = BasePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup(){
        presenter.view = this
        presenter.getInfo()
        binding.button.setOnClickListener {
            presenter.getWisdom()
        }
    }

    override fun onInfoReceived(info: String) {
        binding.textView.text = info
    }

    override fun onRandomInfoReceived(info: String) {
        binding.textView.text = info
    }


}