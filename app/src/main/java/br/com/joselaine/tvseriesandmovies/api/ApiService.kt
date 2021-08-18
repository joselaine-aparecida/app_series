package br.com.joselaine.tvseriesandmovies.api

import android.app.SearchManager.QUERY
import br.com.joselaine.tvseriesandmovies.helpers.Constants.DETAILS
import br.com.joselaine.tvseriesandmovies.helpers.Constants.SEARCH
import br.com.joselaine.tvseriesandmovies.helpers.Constants.SERIE_ACTION
import br.com.joselaine.tvseriesandmovies.helpers.Constants.SERIE_ANIMATION
import br.com.joselaine.tvseriesandmovies.helpers.Constants.SERIE_POPULAR
import br.com.joselaine.tvseriesandmovies.helpers.Constants.SERIE_TOP
import br.com.joselaine.tvseriesandmovies.helpers.Constants.TV_ID
import br.com.joselaine.tvseriesandmovies.models.Detail
import br.com.joselaine.tvseriesandmovies.models.SerieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(SERIE_POPULAR)
    suspend fun getTvShowsPopular(): Response<SerieResponse>

    @GET(SERIE_TOP)
    suspend fun getTvShowsTop(): Response<SerieResponse>

    @GET(SEARCH)
    suspend fun search(
        @Query(QUERY) query: String
    ): Response<SerieResponse>

    @GET(SERIE_ACTION)
    suspend fun getActionTVSeries(): Response<SerieResponse>

    @GET(SERIE_ANIMATION)
    suspend fun getAnimationTVSeries(): Response<SerieResponse>

    @GET(DETAILS)
    suspend fun details(
        @Path(TV_ID) tv_id: Int,
    ): Response<Detail>

}
