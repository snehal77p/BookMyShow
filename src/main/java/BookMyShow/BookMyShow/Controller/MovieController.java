package BookMyShow.BookMyShow.Controller;

import BookMyShow.BookMyShow.DTOs.MovieDTO;
import BookMyShow.BookMyShow.Modal.Movie;
import BookMyShow.BookMyShow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity addMovie(@RequestBody MovieDTO movieDTO) throws Exception {
        Movie movie = movieService.addMovie(movieDTO);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/findMovieByName/{movieName}")
    public ResponseEntity findMovieByName(@PathVariable("movieName") String movieName)
    {
        Movie movie = movieService.findMovieByName(movieName);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/findMovieById/{movieId}")
    public ResponseEntity findMovieById(@PathVariable("movieId") int movieId)
    {
        Movie movie = movieService.findMovieById(movieId);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/deleteMovieById/{movieId}")
    public void deleteSeatById(@PathVariable("movieId") int movieId)
    {
        movieService.deleteMovieById(movieId);
    }

}
