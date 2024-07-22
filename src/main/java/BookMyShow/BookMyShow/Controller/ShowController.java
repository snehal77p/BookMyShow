package BookMyShow.BookMyShow.Controller;

import BookMyShow.BookMyShow.DTOs.ShowDTO;
import BookMyShow.BookMyShow.Modal.Show;
import BookMyShow.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/addShow")
    public ResponseEntity addShow(@RequestBody ShowDTO showDTO)
    {
        Show show = showService.addShow(showDTO);
        return ResponseEntity.ok(show);
    }

    @GetMapping("/findShowById/{showId}")
    public ResponseEntity findShowById(@PathVariable("showId") int showId)
    {
        Show show = showService.findShowById(showId);
        return ResponseEntity.ok(show);
    }

    @DeleteMapping("/deleteShowById/{showId}")
    public void deleteShowById(@PathVariable("showId") int showId)
    {
        showService.deleteShowById(showId);
    }

    @GetMapping("/findShowByAuditorium/{auditoriumName}")
    public ResponseEntity<List<Show>> findShowByAuditorium(@PathVariable("auditoriumName") String auditoriumName)
    {
        List<Show> showList = showService.findShowByAuditorium(auditoriumName);
        return ResponseEntity.ok(showList);
    }

}
