package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(@RequestBody Movie movie){

        String ans = movieRepository.addMovie(movie);
        return ans;
    }

    public String addDirector(@RequestBody Director director){

        String ans = movieRepository.addDirector(director);
        return ans;
    }

    public String addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){

        String ans = movieRepository.addMovieDirectorPair(movieName, directorName);
        return ans;
    }

    public Movie getMovieByName(@PathVariable("name") String name){
         Movie movie = movieRepository.getMovieByName(name);
         return movie;
    }

    public Director getDirectorByName(@PathVariable("name") String name){
        Director director = movieRepository.getDirectorByName(name);
        return director;
    }

    public List<String> getMoviesByDirectorName(@PathVariable("director") String director){
        List<String> ans = movieRepository.getMoviesByDirectorName(director);
        return ans;
    }

    public List<String> findAllMovies(){
        List<String> ans = movieRepository.findAllMovies();
        return ans;
    }

    public String deleteDirectorByName(@RequestParam("name") String name){
        String ans = movieRepository.deleteDirectorByName(name);
        return ans;
    }

    public String deleteAllDirectors(){
        String ans = movieRepository.deleteAllDirectors();
        return ans;
    }
}
