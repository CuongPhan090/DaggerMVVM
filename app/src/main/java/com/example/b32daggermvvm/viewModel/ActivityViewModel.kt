package com.example.b32daggermvvm.viewModel

import android.util.Patterns
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.b32daggermvvm.data.NetworkDataSource
import com.example.b32daggermvvm.model.LoginRequestData
import com.example.b32daggermvvm.model.LoginResponseData
import com.example.b32daggermvvm.repository.MainRepository
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

// no livedata, view model, no application component
class ActivityViewModel : ViewModel() {

    val email = ObservableField<String>()
    val password = ObservableField<String>()
    val loading = ObservableField<Boolean>()

    val emailError = ObservableField<String>()
    val passwordError = ObservableField<String>()

    val error = MutableLiveData<String>()
    val userInfo = MutableLiveData<LoginResponseData>()

    val success = MutableLiveData<String>()

    fun getObservers(): Observer<LoginResponseData> {
        return object : Observer<LoginResponseData> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: LoginResponseData) {
                t.token.let {
                    success.postValue("Login Successfully")
                }
            }

            override fun onError(e: Throwable) {
                error.postValue("Invalid email/password, please try again!")
                e.printStackTrace()
            }

            override fun onComplete() {
            }
        }
    }


    fun logIn() {
        if (isValid()) {
            val loginInfo = LoginRequestData(email.get().toString(), password.get().toString())
            val observableLogin = MainRepository(NetworkDataSource()).fetchDataFromNetwork(loginInfo)
            observableLogin.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObservers())



//            val call = ApiClient.apiService.login(loginInfo)
//            call.enqueue(object : Callback<LoginResponseData> {
//                override fun onResponse(
//                    call: Call<LoginResponseData>,
//                    response: Response<LoginResponseData>,
//                ) {
//                    loading.set(false)
//                    if (!response.isSuccessful) {
//                        error.postValue("")
//                        error.postValue("Unable to login, please try again!")
//                        return
//                    }
//                    userInfo.postValue(response.body())
//                }
//
//                override fun onFailure(call: Call<LoginResponseData>, t: Throwable) {
//                    loading.set(false)
//                    error.postValue("")
//                    error.postValue("Invalid email/password, please try again!")
//                    t.printStackTrace()
//                }
//            })
//            loading.set(true)
        }
    }

    private fun isValid(): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(email.get().toString()).matches()) {
            emailError.set("")
            emailError.set("Invalid email address")
            return false
        }

        if (password.get().toString().length < 6) {
            passwordError.set("")
            passwordError.set("Invalid password")
            return false
        }
        return true
    }
}