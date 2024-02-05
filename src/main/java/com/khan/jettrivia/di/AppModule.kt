package com.khan.jettrivia.di

import com.khan.jettrivia.model.Question
import com.khan.jettrivia.model.QuestionItem
import com.khan.jettrivia.network.QuestionApi
import com.khan.jettrivia.repository.QuestionRepository
import com.khan.jettrivia.util.Constants
import com.khan.jettrivia.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

        @Singleton
        @Provides
        fun provideQuesionRepository(api: QuestionApi) = QuestionRepository(api)


        @Singleton
        @Provides
        //this is to create dependency injection
        fun provideQuestionApi(): QuestionApi {
            return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(QuestionApi::class.java)
        }
}