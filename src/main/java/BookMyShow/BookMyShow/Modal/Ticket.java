package BookMyShow.BookMyShow.Modal;

import BookMyShow.BookMyShow.MyEnums.TicketStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseModel{
    private LocalDateTime timeOfBooking;
    private double totalAmount;
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    private TicketStatus ticketStatus;
}
