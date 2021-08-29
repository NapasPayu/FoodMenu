package com.hellofresh.task2.ui.recipelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hellofresh.task2.domain.usecase.GetRecipesUseCase
import com.hellofresh.task2.ui.common.BaseViewModel
import com.hellofresh.task2.ui.common.util.DateUtils
import com.hellofresh.task2.ui.recipelist.mapper.RecipeViewMapper
import com.hellofresh.task2.ui.recipelist.model.RecipeView
import kotlinx.coroutines.launch
import java.util.Date

class RecipeListViewModel(
    private val getRecipesUseCase: GetRecipesUseCase,
    private val recipeViewMapper: RecipeViewMapper,
) : BaseViewModel() {

    val currentDate = MutableLiveData(DateUtils.toDisplayFormat(Date()))
    val recipes = MutableLiveData<List<RecipeView>>()

    init {
        showLoading()
        viewModelScope.launch {
            getRecipesUseCase()
                .onSuccess {
                    recipes.value = it.map(recipeViewMapper::mapToView)
                }
                .onFailure {
                    alert(message = it.message)
                }
            hideLoading()
        }
    }
}