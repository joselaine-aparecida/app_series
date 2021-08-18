package br.com.joselaine.tvseriesandmovies.helpers

object Constants {
    const val API_KEY = "e215e06e014363151be6c038430030fb"
    const val BASE_URL = "https://api.themoviedb.org"
    const val TV_ID = "tv_id"
    const val DETAILS = "/3/tv/{tv_id}?api_key=$API_KEY&language=pt-BR"
    const val SERIE_POPULAR = "/3/tv/popular?api_key=$API_KEY&language=pt-BR&page=1"
    const val SERIE_TOP = "/3/tv/top_rated?api_key=$API_KEY&language=pt-BR&page=1"
    const val SERIE_ACTION = "/3/discover/tv?api_key=$API_KEY&language=pt-BR&sort_by=popularity.desc&page=1&with_genres=10759"
    const val SERIE_ANIMATION = "/3/discover/tv?api_key=$API_KEY&language=pt-BR&sort_by=popularity.desc&page=1&with_genres=16"
    const val SEARCH = "/3/search/tv?api_key=$API_KEY&language=pt-BR&page=1&query=&include_adult=false"
    const val IMAGE = "https://image.tmdb.org/t/p/w500/"
}