package BookMyShow.BookMyShow.Service;

import BookMyShow.BookMyShow.DTOs.TheaterDTO;
import BookMyShow.BookMyShow.Modal.City;
import BookMyShow.BookMyShow.Modal.Theaters;
import BookMyShow.BookMyShow.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    CityService cityService;

    public void updateTheater(Theaters theaters) {
        theaterRepository.save(theaters);
    }

    public Theaters addTheater(TheaterDTO theaterDTO)
    {
        Theaters newTheater = new Theaters();
        newTheater.setName(theaterDTO.getTheaterName());
        newTheater.setAddress(theaterDTO.getAddress());
        theaterRepository.save(newTheater);

        this.addTheaterInCity(newTheater, theaterDTO);

        return newTheater;
    }

    public Theaters findByName(String theaterName) {

        return theaterRepository.findByName(theaterName);
    }

    public Long deleteTheater(String theaterName)
    {
        return theaterRepository.deleteByName(theaterName);
    }

    public List<Theaters> findAllByCity(String cityName)
    {
        City city = cityService.findCityByName(cityName);
        return city.getTheatersList();
    }

    public void addTheaterInCity(Theaters newTheater, TheaterDTO theaterDTO)
    {
        City city = cityService.findCityById(theaterDTO.getCityId());
        List<Theaters> theatersList = city.getTheatersList();
        if(theatersList==null)
        {
            city.setTheatersList(new ArrayList<Theaters>());
            theatersList = city.getTheatersList();
        }
        theatersList.add(newTheater);
        cityService.updateCity(city);
    }

    public Theaters findById(int theaterId) {

        Optional<Theaters> opTheater = theaterRepository.findById(theaterId);
        if(opTheater.isPresent())
            return opTheater.get();
        else
            return null;
    }
    public Theaters deleteById(int theaterId) {
        theaterRepository.deleteById(theaterId);
        return null;
    }
}
