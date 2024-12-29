package com.example.playtab.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val USERID = "12994"

private const val BASE_URL =
    "https://www.stands4.com/services/v2/"

private const val TOKEN = "5w2A0h27d6WZZm9O"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface PlaytabApiService {
    @GET("lyrics.php")
    suspend fun getLyrics(
        @Query("uid") userid: String = USERID,
        @Query("tokenid") token: String = TOKEN,
        @Query("term") term: String,
        @Query("artist") artist: String = "",
        @Query("format") format: String = "json",
    ): String
}

object PlayTabApi {
    val retrofitService: PlaytabApiService by lazy {
        retrofit.create(PlaytabApiService::class.java)
    }
}