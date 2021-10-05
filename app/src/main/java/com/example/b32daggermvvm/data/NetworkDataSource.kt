package com.example.b32daggermvvm.data

import com.example.b32daggermvvm.di.component.ApplicationComponent
import com.example.b32daggermvvm.di.component.DaggerApplicationComponent
import com.example.b32daggermvvm.di.module.ApplicationModule
import com.example.b32daggermvvm.model.LoginRequestData
import com.example.b32daggermvvm.model.LoginResponseData
import com.example.b32daggermvvm.repository.remote.ApiService
import io.reactivex.Observable
import javax.inject.Inject

class NetworkDataSource @Inject constructor() {

    @Inject
    lateinit var apiService: ApiService

    init {
        val daggerApplicationComponent: ApplicationComponent =
            DaggerApplicationComponent.builder().applicationModule(
                ApplicationModule()).build()

        daggerApplicationComponent.inject(this)
    }

    fun fetchUserData(loginRequestData: LoginRequestData): Observable<LoginResponseData> {
        return apiService.login(loginRequestData)
    }
}