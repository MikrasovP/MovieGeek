package demo.movie.app.di

import dagger.Binds
import dagger.Module
import demo.movie.app.di.scopes.DiscoverScope
import demo.movie.app.model.repo.movies.BaseMoviesRepo
import demo.movie.app.model.repo.movies.MoviesRepo

@Module
abstract class RepoModule {

    @DiscoverScope
    @Binds
    abstract fun bindBaseMoviesRepo(moviesRepo: MoviesRepo): BaseMoviesRepo

}