package BookMyShow.BookMyShow.DTOs;

import BookMyShow.BookMyShow.Modal.Ticket;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentDTO {
    private LocalDateTime paymentTime;
    private double amount;
    private int ticketId;
}
