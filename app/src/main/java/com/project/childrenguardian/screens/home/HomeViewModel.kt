package com.dicoding.mybook_sc.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.project.childrenguardian.data.models.ChildrenModel
import com.project.childrenguardian.data.remote.repository.ChildrenRepository
import com.project.childrenguardian.screens.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class HomeViewModel(
    private val repository: ChildrenRepository,
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<ChildrenModel>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<ChildrenModel>>> get() = _uiState

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

}