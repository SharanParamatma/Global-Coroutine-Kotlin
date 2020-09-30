package com.srkpindia.coroutine

import dagger.Component

@Component
interface ApplicationComponent {

    fun getApi(): ApiClient
    fun inject(coroutineActivity: CoroutineActivity)




}