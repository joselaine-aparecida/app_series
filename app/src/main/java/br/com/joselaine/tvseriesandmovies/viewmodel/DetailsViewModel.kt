package br.com.joselaine.tvseriesandmovies.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.joselaine.tvseriesandmovies.models.Detail
import br.com.joselaine.tvseriesandmovies.repository.SeriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel
@Inject
constructor(private val repository: SeriesRepository) : ViewModel() {

    private var _responseDetail = MutableLiveData<Detail>()
    val detail: LiveData<Detail>
        get() = _responseDetail

    fun getDetails(id: Int) = viewModelScope.launch {
        repository.getDetails(id).let { response ->
            if (response.isSuccessful) {
                _responseDetail.value = response.body()
            } else {
                Log.d("tag", "getSearch Error: ${response.code()}")
            }
        }
    }

}