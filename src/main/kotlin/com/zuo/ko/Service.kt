package com.zuo.ko

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GithubServiec{

    @GET("/repos/enbandari/Kotlin-Tutorials/stargazers")
    fun getStarts():Call<List<User>>
}

object Service{
    val githubService:GithubServiec by lazy {
        Retrofit.Builder().baseUrl("https://api.github.com").
                addConverterFactory(GsonConverterFactory.create()).build().create(GithubServiec::class.java)
    }
}

fun main(args:Array<String>){
    Service.githubService.getStarts().execute().body().map(::println)
}