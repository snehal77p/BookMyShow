package BookMyShow.BookMyShow.Service;

import BookMyShow.BookMyShow.DTOs.MovieDTO;
import BookMyShow.BookMyShow.Modal.Movie;
import BookMyShow.BookMyShow.Modal.Show;
import BookMyShow.BookMyShow.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie addMovie(MovieDTO movieDTO) throws Exception {
        Movie movie = new Movie();
        movie.setName(movieDTO.getName());
        movie.setMovieDescription(movieDTO.getDescription());
        movie.setAuditoriumFeatures(movieDTO.getAuditoriumFeatures());
        movieRepository.save(movie);

        return movie;
    }

    public Movie findMovieById(int movieId)
    {
        return movieRepository.findById(movieId).get();
    }

    public void deleteMovieById(int movieId)
    {
        movieRepository.deleteById(movieId);
    }

    public Movie findMovieByName(String movieName)
    {
        return movieRepository.findByName(movieName);
    }
}
