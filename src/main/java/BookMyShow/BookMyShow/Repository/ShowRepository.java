package BookMyShow.BookMyShow.Repository;

import BookMyShow.BookMyShow.Modal.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {
    public Show findByDateNStartTime(LocalDateTime startTime); //yyyy-MM-dd-HH-mm-ss
    public void deleteByDateNEndTime(LocalDateTime startTime);
}
