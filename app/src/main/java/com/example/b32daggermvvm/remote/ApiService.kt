package com.example.b32daggermvvm.repository.remote

import com.example.b32daggermvvm.model.LoginRequestData
import com.example.b32daggermvvm.model.LoginResponseData
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Content-type: Application/json")
    @POST("auth/login")
    fun login(@Body loginRequestData: LoginRequestData): Observable<LoginResponseData>

}