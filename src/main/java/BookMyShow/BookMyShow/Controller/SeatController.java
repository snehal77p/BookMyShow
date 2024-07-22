package BookMyShow.BookMyShow.Controller;

import BookMyShow.BookMyShow.DTOs.SeatDTO;
import BookMyShow.BookMyShow.Modal.Seat;
import BookMyShow.BookMyShow.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeatController {
    @Autowired
    SeatService seatService;

    @PostMapping("/addSeat")
    public ResponseEntity addSeat(@RequestBody SeatDTO seatDTO)
    {
        Seat seat = seatService.addSeat(seatDTO);
        return ResponseEntity.ok(seat);
    }

    @GetMapping("/findSeatById/{seatId}")
    public ResponseEntity findSeatById(@PathVariable("seatId") int seatId)
    {
        Seat seat = seatService.findSeatById(seatId);
        return ResponseEntity.ok(seat);
    }

    @GetMapping("/findSeatBySeatNumber/{seatNumber}")
    public ResponseEntity findSeatBySeatNumber(@PathVariable("seatNumber") int seatNumber)
    {
        Seat seat = seatService.findSeatByNumber(seatNumber);
        return ResponseEntity.ok(seat);
    }

    @DeleteMapping("/deleteSeatById/{seatId}")
    public void deleteSeatById(@PathVariable("seatId") int seatId)
    {
        seatService.deleteSeatById(seatId);
    }

    @GetMapping("/findSeatByAuditorium/{auditoriumName}")
    public ResponseEntity<List<Seat>> findSeatByAuditorium(@PathVariable("auditoriumName") String auditoriumName)
    {
        List<Seat> seatList = seatService.findSeatByAuditorium(auditoriumName);
        return ResponseEntity.ok(seatList);
    }
}
