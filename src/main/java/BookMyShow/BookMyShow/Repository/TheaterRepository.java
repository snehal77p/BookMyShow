package BookMyShow.BookMyShow.Repository;

import BookMyShow.BookMyShow.Modal.Theaters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theaters,Integer> {

    public Long deleteByName(String theaterName);
    public Theaters findByName(String theaterName);
}
