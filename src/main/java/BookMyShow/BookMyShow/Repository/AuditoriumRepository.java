package BookMyShow.BookMyShow.Repository;

import BookMyShow.BookMyShow.Modal.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {
    public Long deleteByName(String name);
    public Auditorium findByName(String name);
}
