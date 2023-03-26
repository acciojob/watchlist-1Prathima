package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();

    HashMap<String, Director> directorDb = new HashMap<>();

    HashMap<String, String> movieDirectorPair = new HashMap<>();

    public String addMovie(Movie movie){

        String key = movie.getName();
        movieDb.put(key, movie);
        return "Movie added successfully";
    }

    public String addDirector(Director director){

        String key = director.getName();
        directorDb.put(key, director);
        return "Director added successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName){
        movieDirectorPair.put(movieName, directorName);
        return "Pair added successfully";
    }

    public Movie getMovieByName(String name){
        Movie movie = movieDb.get(name);
        return movie;
    }

    public Director getDirectorByName(String name){
        Director director = directorDb.get(name);
        return director;
    }

    public List<String> getMoviesByDirectorName(String director){
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

    public String deleteDirectorByName(String name){
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
