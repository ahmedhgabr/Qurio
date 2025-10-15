package com.ahmedhgabr.qurio.model.remote

import com.ahmedhgabr.qurio.model.remote.dto.CategoriesResponse
import com.ahmedhgabr.qurio.model.remote.dto.QuestionsResponse
import com.ahmedhgabr.qurio.model.remote.dto.TokenResponse
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
        @Query("token") token: String? = null
    ): QuestionsResponse

    @GET("api_token.php?command=request")
    suspend fun getToken(): TokenResponse

    @GET("api_category.php")
    suspend fun getCategories(): CategoriesResponse
}

object TriviaApi {
    val retrofitService: TriviaApiService by lazy {
        retrofit.create(TriviaApiService::class.java)
    }
}
