package com.example.b32daggermvvm.di.component

import com.example.b32daggermvvm.data.NetworkDataSource
import com.example.b32daggermvvm.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules= [ApplicationModule::class])
interface ApplicationComponent {

    // the class I want to ict, pass it here
    fun inject(networkDataSource: NetworkDataSource)
}