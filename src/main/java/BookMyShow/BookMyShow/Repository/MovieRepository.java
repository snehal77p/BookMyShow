package BookMyShow.BookMyShow.Repository;

import BookMyShow.BookMyShow.Modal.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Movie findByName(String name);
}
