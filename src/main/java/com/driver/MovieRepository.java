package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import static java.lang.ConditionalSpecialCasing.entry;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();

    HashMap<String, Director> directorDb = new HashMap<>();

    HashMap<String, List<String>> movieDirectorPair = new HashMap<>();

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
        List<String> movies = movieDirectorPair.get(directorName);
        if(movies == null){
            movies = new ArrayList<>();
        }
        movies.add(movieName);
        movieDirectorPair.put(directorName, movies);
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
        List<String> ans = movieDirectorPair.get(director);
        return ans;
    }

    public List<String> findAllMovies(){
        List<String> ans = new ArrayList<>();
       for(String movie : movieDb.keySet()){
           ans.add(movie);
       }
        return ans;
    }

    public String deleteDirectorByName(String director){
        for(String movie : movieDirectorPair.get(director)){
            movieDb.remove(movie);
        }
        directorDb.remove(director);
        movieDirectorPair.remove(director);

//        directorDb.remove(name);
//        for(String movie : movieDirectorPair.keySet()){
//            if(movieDirectorPair.get(movie).equals(name)){
//                movieDb.remove(movie);
//                movieDirectorPair.remove(movie);
//            }
//        }

        //Iterate over a hashmap
//        for(Map.Entry<String, String> entry : movieDirectorPair.entrySet()){
//            if(entry.getValue().equals(name)){
//                String movieName = entry.getKey();
//                movieDb.remove(movieName);
//                movieDirectorPair.remove(movieName);
//            }
//        }
        return "Deleted director and it's movies successfully";
    }

    public String deleteAllDirectors(){

        for(String director : directorDb.keySet()){
            for(String movie : movieDirectorPair.get(director)){
                movieDb.remove(movie);
            }
            directorDb.remove(director);
            movieDirectorPair.remove(director);
        }

//        for(String director : directorDb.keySet()){
//            directorDb.remove(director);
//            for(String movie : movieDirectorPair.keySet()){
//                if(movieDirectorPair.get(movie).equals(director)){
//                    movieDb.remove(movie);
//                    movieDirectorPair.remove(movie);
//                }
//            }
//        }

        //iterate
//        for(String directorName : directorDb.keySet()) {
//            directorDb.remove(directorName);
//
//            for (Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
//                if (entry.getValue().equals(directorName)) {
//                    String movieName = entry.getKey();
//                    movieDb.remove(movieName);
//                    movieDirectorPair.remove(movieName);
//                }
//            }
//        }
        return "Deleted all directors successfully";
    }
}
