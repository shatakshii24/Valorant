package com.example.valorant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AgentsViewModel : ViewModel() {

    private val _agents = MutableStateFlow<List<Agent>>(emptyList())
    val agents: StateFlow<List<Agent>> = _agents

    private val _selectedAgent = MutableStateFlow<AgentDetail?>(null)
    val selectedAgent: StateFlow<AgentDetail?> = _selectedAgent

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchAgents() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val response = RetrofitInstance.api.getAgents()
                _agents.value = response.data
            } catch (e: Exception) {
                _error.value = "Failed to fetch agents"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchAgentDetail(uuid: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val response = RetrofitInstance.api.getAgentDetail(uuid)
                _selectedAgent.value = response.data
            } catch (e: Exception) {
                _error.value = "Failed to load agent detail"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
