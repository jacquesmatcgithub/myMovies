package edu.matc.controller;

import edu.matc.entity.Movie;
import edu.matc.persistence.MovieDao;

import java.util.List;

public class CleanupUserMovieCatalog {


    public CleanupUserMovieCatalog() {
    }

    public void deleteNonCatalogMovies(String currentUser) {

        MovieDao dao = new MovieDao();
        List<Movie> movies = dao.getByPropertyEqual("loginId", currentUser);

        Movie deleteMovie = new Movie();


        for (Movie movie : movies) {
            if (!movie.isMovieInCollection()) {
                deleteMovie = dao.getById(movie.getId());
                dao.delete(deleteMovie);
            }
        }
    }

}
