package BookMyShow.BookMyShow.Repository;

import BookMyShow.BookMyShow.Modal.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
    public Seat findSeatByseatNumber(int seatNumber);
}
