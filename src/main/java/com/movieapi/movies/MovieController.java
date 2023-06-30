//package com.movieapi.movies;
//
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.swing.text.html.Option;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/api/v1/movies")
//
//public class MovieController {
//    @Autowired
//    private MovieService movieService;
//    @GetMapping
//    public ResponseEntity<List<Movie>> getAllMovies(){
//        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
//    }
//
////    @GetMapping("/{id}")
//    // dont want to viewers to see the object id
////    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
////        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
////    }
//@GetMapping("/{imdbId}")
//    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
//        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
//    }
//}
package com.movieapi.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") // Enable CORS for all origins
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        // Handle a GET request to retrieve all movies

        // Call the movie service to get all movies
        List<Movie> movies = movieService.allMovies();

        // Return the list of movies in the response body with HTTP status OK (200)
        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        // Handle a GET request to retrieve a single movie based on its IMDB ID

        // Call the movie service to get the movie with the specified IMDB ID
        Optional<Movie> movie = movieService.singleMovie(imdbId);

        // Return the movie (if found) in the response body with HTTP status OK (200)
        // If the movie is not found, an empty response will be returned
        return new ResponseEntity<Optional<Movie>>(movie, HttpStatus.OK);
    }
}

