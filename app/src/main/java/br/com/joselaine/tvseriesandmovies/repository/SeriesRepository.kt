package br.com.joselaine.tvseriesandmovies.repository

import br.com.joselaine.tvseriesandmovies.api.ApiService
import br.com.joselaine.tvseriesandmovies.models.Detail
import br.com.joselaine.tvseriesandmovies.models.SerieResponse
import retrofit2.Response
import javax.inject.Inject

class SeriesRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getTvShowsPopular() = apiService.getTvShowsPopular()
    suspend fun getTvShowsTop() = apiService.getTvShowsTop()
    suspend fun search(query: String): Response<SerieResponse> {
        return apiService.search(query)
    }
    suspend fun getActionTV() = apiService.getActionTVSeries()
    suspend fun getAnimationTV() = apiService.getAnimationTVSeries()
    suspend fun getDetails(id: Int): Response<Detail> {
        return apiService.details(id)
    }
}