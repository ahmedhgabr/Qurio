package com.ahmedhgabr.qurio.model.remote

import com.ahmedhgabr.qurio.model.remote.dto.QuestionsResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.http.Query

private const val BASE_URL =
    "https://opentdb.com"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .build()


interface TriviaApiService {

    @GET("api.php")
    suspend fun getQuestions(
        @Query("amount") amount: Int,
        @Query("category") category: Int? = null,
        @Query("difficulty") difficulty: String? = null,
        @Query("token") type: String? = null
    ): QuestionsResponse
}

object TriviaApi {
    val retrofitService : TriviaApiService by lazy {
        retrofit.create(TriviaApiService::class.java)
    }
}
