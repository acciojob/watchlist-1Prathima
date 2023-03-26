package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();

    HashMap<String, Director> directorDb = new HashMap<>();

    HashMap<String, String> movieDirectorPair = new HashMap<>();

    public String addMovie(@RequestBody Movie movie){

        String key = movie.getName();
        movieDb.put(key, movie);
        return "Movie added successfully";
    }

    public String addDirector(@RequestBody Director director){

        String key = director.getName();
        directorDb.put(key, director);
        return "Director added successfully";
    }

    public String addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){
        movieDirectorPair.put(movieName, directorName);
        return "Pair added successfully";
    }

    public Movie getMovieByName(@PathVariable("name") String name){
        Movie movie = movieDb.get(name);
        return movie;
    }

    public Director getDirectorByName(@PathVariable("name") String name){
        Director director = directorDb.get(name);
        return director;
    }

    public List<String> getMoviesByDirectorName(@PathVariable("director") String director){
        List<String> ans = new ArrayList<>();
        for(String movieName : movieDirectorPair.keySet()){
            if(movieDirectorPair.get(movieName) == director){
                ans.add(movieName);
            }
        }
        return ans;
    }

    public List<String> findAllMovies(){
        List<String> ans = new ArrayList<>();
        for(String movieName : movieDb.keySet()){
            ans.add(movieName);
        }
        for(String movieName : movieDirectorPair.keySet()){
            ans.add(movieName);
        }
        return ans;
    }

    public String deleteDirectorByName(@RequestParam("name") String name){
        for(String movieName : movieDirectorPair.keySet()){
            if(movieDirectorPair.get(movieName) == name){
                movieDirectorPair.remove(movieName);
            }
        }
        return "Deleted director and it's movies successfully";
    }

    public String deleteAllDirectors(){
        for(String movieName : movieDirectorPair.keySet()){
            if(movieDirectorPair.get(movieName) != null){
                movieDirectorPair.remove(movieName);
            }
        }
        return "Deleted all directors successfully";
    }
}
