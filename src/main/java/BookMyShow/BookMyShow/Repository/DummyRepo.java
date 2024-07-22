package BookMyShow.BookMyShow.Repository;

import BookMyShow.BookMyShow.Modal.SampleClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyRepo extends JpaRepository<SampleClass,Integer> {

    public Long deleteByEgString(String egString);
}
