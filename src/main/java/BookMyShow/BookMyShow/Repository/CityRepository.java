package BookMyShow.BookMyShow.Repository;

import BookMyShow.BookMyShow.Modal.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
    public City findByName(String cityName);

    public Long deleteByName(String cityName);
}
