package BookMyShow.BookMyShow.Controller;

import BookMyShow.BookMyShow.DTOs.CityDTO;
import BookMyShow.BookMyShow.Modal.City;
import BookMyShow.BookMyShow.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("/createCity")
    public ResponseEntity creatCity (@RequestBody CityDTO cityDTO){
        try{
            String cityName = cityDTO.getName();
            if(cityName == null || cityName.isEmpty() || cityName.isBlank()){
                throw new Exception("City name Invalid");
            }
            City savedCity = cityService.saveCity(cityDTO);
            return ResponseEntity.ok(savedCity);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping("/deleteCityById/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") int cityId){
        cityService.deleteCity(cityId);
        return ResponseEntity.ok("City deleted");
    }

    @GetMapping("/findCityByName/{cityName}")
    public ResponseEntity findCityByName(@PathVariable("cityName") String cityName)
    {
        City newCity = cityService.findCityByName(cityName);
        return ResponseEntity.ok(newCity);
    }

    @GetMapping("/findAllCity")
    public ResponseEntity<Optional<List<City>>> findAllCity()
    {
        List<City> cityList = cityService.findAllCity();
        return ResponseEntity.ok(Optional.of(cityList));
    }

    @Transactional
    @DeleteMapping("/deleteCityByName/{cityName}")
    public ResponseEntity deleteCityByName(@PathVariable("cityName") String cityName)
    {
        System.out.println("delete city");
        cityService.deleteCityByName(cityName);
        return ResponseEntity.ok("City deleted");
    }
}
