package br.com.joselaine.tvseriesandmovies.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.joselaine.tvseriesandmovies.models.Serie
import br.com.joselaine.tvseriesandmovies.repository.SeriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
@Inject
constructor(private val repository: SeriesRepository) : ViewModel() {

    private val _responseSearch = MutableLiveData<List<Serie>>()
    val responseSearch: LiveData<List<Serie>>
        get() = _responseSearch


    fun searchSerie(query: String) = viewModelScope.launch {
        repository.search(query).let { response ->
            if (response.isSuccessful) {
                _responseSearch.postValue(response.body()!!.series)
            } else {
                Log.d("tag", "getSearch Error: ${response.code()}")
            }
        }
    }
}

//teste push2