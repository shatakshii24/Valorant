package com.example.valorant

data class AgentDetailResponse(
    val status: Int,
    val data: AgentDetail
)

data class AgentDetail(
    val displayName: String,
    val description: String,
    val fullPortrait: String?,
    val role: Role?,
    val abilities: List<Ability>
)

data class Role(
    val displayName: String,
    val description: String,
    val displayIcon: String?
)

data class Ability(
    val slot: String,
    val displayName: String,
    val description: String,
    val displayIcon: String?
)
