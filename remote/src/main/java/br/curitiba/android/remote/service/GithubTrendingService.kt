package br.curitiba.android.remote.service

import br.curitiba.android.remote.model.ProjectsResponseDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubTrendingService {

    @GET("search/repositories")
    fun searchRepositories(@Query("q") query: String,
                           @Query("sort") sortBy: String,
                           @Query("order") order: String): Observable<ProjectsResponseDTO>
}