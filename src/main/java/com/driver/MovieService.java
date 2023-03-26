package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){

        String ans = movieRepository.addMovie(movie);
        return ans;
    }

    public String addDirector( Director director){

        String ans = movieRepository.addDirector(director);
        return ans;
    }

    public String addMovieDirectorPair(String movieName, String directorName){

        String ans = movieRepository.addMovieDirectorPair(movieName, directorName);
        return ans;
    }

    public Movie getMovieByName(String name){
         Movie movie = movieRepository.getMovieByName(name);
         return movie;
    }

    public Director getDirectorByName(String name){
        Director director = movieRepository.getDirectorByName(name);
        return director;
    }

    public List<String> getMoviesByDirectorName(String director){
        List<String> ans = movieRepository.getMoviesByDirectorName(director);
        return ans;
    }

    public List<String> findAllMovies(){
        List<String> ans = movieRepository.findAllMovies();
        return ans;
    }

    public String deleteDirectorByName(String name){
        String ans = movieRepository.deleteDirectorByName(name);
        return ans;
    }

    public String deleteAllDirectors(){
        String ans = movieRepository.deleteAllDirectors();
        return ans;
    }
}
