package BookMyShow.BookMyShow.Controller;

import BookMyShow.BookMyShow.DTOs.AuditoriumDTO;
import BookMyShow.BookMyShow.Modal.Auditorium;
import BookMyShow.BookMyShow.Service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class AuditoriumController {

    @Autowired
    AuditoriumService auditoriumService;

    @Transactional
    @PostMapping("/addAuditorium")
    public ResponseEntity addAuditorium(@RequestBody AuditoriumDTO auditoriumDTO)
    {
        System.out.println(auditoriumDTO);
        Auditorium auditorium = auditoriumService.addAuditorium(auditoriumDTO);
        return ResponseEntity.ok("auditorium");
    }

    @GetMapping("/findAuditoriumById/{auditoriumId}")
    public ResponseEntity<Auditorium> findAuditoriumById(@PathVariable("auditoriumId") int auditoriumId)
    {
        Auditorium auditorium = auditoriumService.findAuditoriumById(auditoriumId);
        return ResponseEntity.ok(auditorium);
    }

    @GetMapping("/findAuditoriumByName/{auditoriumName}")
    public ResponseEntity findAuditoriumByName(@PathVariable("auditoriumName") String auditoriumName)
    {
        System.out.println(auditoriumName);
        Auditorium auditorium = auditoriumService.findAuditoriumByName(auditoriumName);
        return ResponseEntity.ok(auditorium);
    }


    @DeleteMapping("/deleteAuditoriumByName/{auditoriumName}")
    public void deleteAuditoriumByName(@PathVariable("auditoriumName") String auditoriumName)
    {
        auditoriumService.deleteAuditoriumByName(auditoriumName);
    }


    @DeleteMapping("/deleteAuditoriumById/{auditoriumId}")
    public void deleteAuditoriumById(@PathVariable("auditoriumId") int auditoriumId)
    {
        auditoriumService.deleteAuditoriumById(auditoriumId);
    }

    @GetMapping("/findAuditoriumByTheaters/{theaterName}")
    public ResponseEntity<List<Auditorium>> findAuditoriumByTheaters(@PathVariable("theaterName") String theaterName)
    {
        List<Auditorium> auditoriumList = auditoriumService.findAuditoriumByTheaters(theaterName);
        return ResponseEntity.ok(auditoriumList);
    }

}
