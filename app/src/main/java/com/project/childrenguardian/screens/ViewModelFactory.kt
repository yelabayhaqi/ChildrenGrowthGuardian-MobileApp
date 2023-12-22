package com.project.childrenguardian.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.childrenguardian.data.remote.repository.ChildrenRepository
import com.project.childrenguardian.data.remote.repository.HistoryRepository
import com.project.childrenguardian.screens.home.HistoryViewModel

class ViewModelFactory(
    private val repository: HistoryRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoryViewModel::class.java)) {
            return HistoryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}