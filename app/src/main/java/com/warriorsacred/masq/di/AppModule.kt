package com.warriorsacred.masq.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // все зависимости внутри модуля будут жить, пока приложение будет работать
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth () = FirebaseAuth.getInstance()
}