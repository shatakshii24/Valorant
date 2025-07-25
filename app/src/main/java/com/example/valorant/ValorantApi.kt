package com.example.valorant

import com.example.valorant.AgentsResponse
import com.example.valorant.AgentDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ValorantApi {
    @GET("agents")
    suspend fun getAgents(
        @Query("isPlayableCharacter") isPlayable: Boolean = true
    ): AgentsResponse

    @GET("agents/{uuid}")
    suspend fun getAgentDetail(
        @Path("uuid") uuid: String
    ): AgentDetailResponse
}
