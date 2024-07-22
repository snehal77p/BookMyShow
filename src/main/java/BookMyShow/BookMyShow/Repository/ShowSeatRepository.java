package BookMyShow.BookMyShow.Repository;

import BookMyShow.BookMyShow.Modal.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

    public ShowSeat findShowSeatById(int showSeatId);
    public void deleteShowSeatById(int showSeatId);

}
