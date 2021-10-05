package com.example.b32daggermvvm.repository

import com.example.b32daggermvvm.data.NetworkDataSource
import com.example.b32daggermvvm.model.LoginRequestData
import com.example.b32daggermvvm.model.LoginResponseData
import io.reactivex.Observable
import javax.inject.Inject

class MainRepository @Inject constructor(val networkDataSource: NetworkDataSource){

    fun fetchDataFromNetwork(loginRequestData: LoginRequestData): Observable<LoginResponseData> {
        return networkDataSource.fetchUserData(loginRequestData)
    }
}