package BookMyShow.BookMyShow.Controller;

import BookMyShow.BookMyShow.Modal.ShowSeat;
import BookMyShow.BookMyShow.Modal.Ticket;
import BookMyShow.BookMyShow.Service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {
    private TicketService ticketService;

    @PostMapping("/bookTicket")
    public ResponseEntity bookTicket(@RequestBody List<Integer> showSeat, int userId) throws Exception {
        Ticket ticket = ticketService.bookTicket(showSeat,userId);
        return ResponseEntity.ok(ticket);
    }

}
