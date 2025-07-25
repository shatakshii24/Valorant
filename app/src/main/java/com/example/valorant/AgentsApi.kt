package com.example.valorant

import retrofit2.Response
import retrofit2.http.GET

interface AgentsApi {
    @GET("agents?isPlayableCharacter=true")
    suspend fun getAgents(): Response<AgentsResponse>
}
