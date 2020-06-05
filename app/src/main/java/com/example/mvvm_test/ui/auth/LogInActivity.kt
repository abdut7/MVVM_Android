package com.example.mvvm_test.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_test.R
import com.example.mvvm_test.databinding.ActivityMainBinding
import com.example.mvvm_test.utils.hide
import com.example.mvvm_test.utils.show
import com.example.mvvm_test.utils.showToast
import kotlinx.android.synthetic.main.activity_main.*

class LogInActivity : AppCompatActivity(), AuthListner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   setContentView(R.layout.activity_main)
        val bind: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewmodel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        bind.viewmodel = viewmodel
        viewmodel.authListner = this
    }

    override fun onStarted() {
       progress_bar.show()
    }

    override fun onSuccess(logInResponse: MutableLiveData<String>) {
        logInResponse.observe(this, Observer {
            showToast(it)

            Log.d(">...................",it)
            progress_bar.hide()
        })


    }

    override fun onFailiur(strMessage: String) {
        showToast("Fail" + strMessage)
        progress_bar.hide()

    }
}
