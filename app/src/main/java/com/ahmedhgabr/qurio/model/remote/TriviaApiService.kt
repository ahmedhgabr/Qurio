package com.ahmedhgabr.qurio.model.remote

import com.ahmedhgabr.qurio.model.remote.dto.CategoriesResponse
import com.ahmedhgabr.qurio.model.remote.dto.QuestionsResponse
import com.ahmedhgabr.qurio.model.remote.dto.TokenResponse
import retrofit2.http.GET
import retrofit2.http.Query

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
