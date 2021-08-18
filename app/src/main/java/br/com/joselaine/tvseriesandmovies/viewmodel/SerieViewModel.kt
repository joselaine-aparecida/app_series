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
class SerieViewModel
@Inject
constructor(private val repository: SeriesRepository) : ViewModel() {

    private val _responsePopular = MutableLiveData<List<Serie>>()
    val responsePopular: LiveData<List<Serie>>
        get() = _responsePopular

    private val _responseTop = MutableLiveData<List<Serie>>()
    val responseSeriesTop: LiveData<List<Serie>>
        get() = _responseTop

    private val _responseAction = MutableLiveData<List<Serie>>()
    val responseAction: LiveData<List<Serie>>
        get() = _responseAction

    private val _responseAnimation = MutableLiveData<List<Serie>>()
    val responseAnimation: LiveData<List<Serie>>
        get() = _responseAnimation

    init {
        getAllPopular()
        getAllTop()
        getActionTV()
        getAnimationTV()
    }

    private fun getAllPopular() = viewModelScope.launch {
        repository.getTvShowsPopular().let { response ->
            if (response.isSuccessful) {
                _responsePopular.postValue(response.body()!!.series)
            } else {
                Log.d("tag", "getPopular Error: ${response.code()}")
            }
        }
    }

    private fun getAllTop() = viewModelScope.launch {
        repository.getTvShowsTop().let { response ->
            if (response.isSuccessful) {
                _responseTop.postValue(response.body()!!.series)
            } else {
                Log.d("tag", "getTop Error: ${response.code()}")
            }
        }
    }

    fun getActionTV() = viewModelScope.launch {
        repository.getActionTV().let { response ->
            if (response.isSuccessful) {
                _responseAction.postValue(response.body()!!.series)
            } else {
                Log.d("tag", "getNews Error: ${response.code()}")
            }
        }
    }

    fun getAnimationTV() = viewModelScope.launch {
        repository.getAnimationTV().let { response ->
            if (response.isSuccessful) {
                _responseAnimation.postValue(response.body()!!.series)
            } else {
                Log.d("tag", "getNews Error: ${response.code()}")
            }
        }
    }

}

