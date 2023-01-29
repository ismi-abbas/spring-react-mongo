package dev.abbas.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

//    public MovieService(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }
//    We simplify using @Autowired

    @GetMapping
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }
}
