package com.project.childrenguardian.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.childrenguardian.data.models.HistoryModel
import com.project.childrenguardian.data.remote.repository.HistoryRepository
import com.project.childrenguardian.screens.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


class HistoryViewModel(
    private val repository: HistoryRepository,
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<HistoryModel>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<HistoryModel>>> get() = _uiState

    private val _query = mutableIntStateOf(0)
    val query: State<Int> get() = _query

//    fun getChildHistory(childId: Int): LiveData<Result<Error>> {
//        return repository.getChildHistory(childId)
//    }

}