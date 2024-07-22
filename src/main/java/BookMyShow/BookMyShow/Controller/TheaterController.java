package BookMyShow.BookMyShow.Controller;

import BookMyShow.BookMyShow.DTOs.TheaterDTO;
import BookMyShow.BookMyShow.Modal.City;
import BookMyShow.BookMyShow.Modal.Theaters;
import BookMyShow.BookMyShow.Service.CityService;
import BookMyShow.BookMyShow.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TheaterController {
    @Autowired
    TheaterService theaterService;

    @PostMapping("/addTheater")
    public ResponseEntity addTheater(@RequestBody TheaterDTO theaterDTO)
    {
        Theaters theater = theaterService.addTheater(theaterDTO);
        return ResponseEntity.ok(theater);
    }

    @GetMapping("/findAllTheaters/{cityName}")
    public ResponseEntity<List<Theaters>>findAllTheaters(@PathVariable("cityName") String cityName)
    {
        List<Theaters> theatersList = theaterService.findAllByCity(cityName);
        return ResponseEntity.ok(theatersList);
    }

    @GetMapping("/getTheaters/{theaterName}")
    public ResponseEntity<Theaters> findByName(@PathVariable("theaterName") String theaterName)
    {
        Theaters theaters = theaterService.findByName(theaterName);
        return ResponseEntity.ok(theaters);
    }

    @DeleteMapping("/deleteTheaterByName/{theaterName}")
    public ResponseEntity deleteTheaterByName(@PathVariable("theaterName") String theaterName)
    {
        Long theaters = theaterService.deleteTheater(theaterName);
        return ResponseEntity.ok(theaters);
    }

    @DeleteMapping("/deleteTheaterById/{theaterId}")
    public ResponseEntity deleteTheaterByName(@PathVariable("theaterId") int theaterId)
    {
        Theaters theaters = theaterService.deleteById(theaterId);
        return ResponseEntity.ok(theaters);
    }
}
