package com.example.tbc_course_24.di

import com.example.tbc_course_24.domain.repository.ApiRepository
import com.example.tbc_course_24.network.ApiInterface
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .addLast(KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .build()


    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): ApiInterface = retrofit.create(ApiInterface::class.java)

    @Provides
    @Singleton
    fun provideMemeRepository(api: ApiInterface): ApiRepository = ApiRepository(api)
}