package dev.abbas.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")

public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        var result = movieService.allMovies();
        return new ResponseEntity<List<Movie>>(result, HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        var result = movieService.singleMovie(imdbId);
        return new ResponseEntity<Optional<Movie>>(result, HttpStatus.OK);
    }

    @PostMapping(path = "/title", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Movie>> getMovieByTitle(@RequestBody Movie title) {
        System.out.println(title);
        var result = movieService.singleMovieByTitle(String.valueOf(title));
        return new ResponseEntity<Optional<Movie>>(result, HttpStatus.OK);
    }
}
