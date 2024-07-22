package BookMyShow.BookMyShow.Service;

import BookMyShow.BookMyShow.DTOs.CityDTO;
import BookMyShow.BookMyShow.Modal.City;
import BookMyShow.BookMyShow.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City saveCity(CityDTO cityName)
    {
        City city = new City();
        city.setName(cityName.getName());
        return cityRepository.save(city);
    }

    public void deleteCity(int cityId)
    {
        cityRepository.deleteById(cityId);
    }

    public City findCityByName(String cityName)
    {
        return cityRepository.findByName(cityName);
    }

    public List<City> findAllCity()
    {
        return cityRepository.findAll();
    }


    public void deleteCityByName(String cityName)
    {

        Long city = cityRepository.deleteByName(cityName);
        if(city==0)
        {
            System.out.println("City not available");
            return;
        }
        System.out.println("City deleted");
    }


    public City findCityById(int cityId) {
        return cityRepository.findById(cityId).get();
    }

    public void updateCity(City city) {
        cityRepository.save(city);
    }
}


