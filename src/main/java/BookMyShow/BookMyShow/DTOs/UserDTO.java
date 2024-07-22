package BookMyShow.BookMyShow.DTOs;

import BookMyShow.BookMyShow.Modal.Ticket;
import BookMyShow.BookMyShow.MyEnums.PaymentMode;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private String name;
    private String mailId;
    private int ticketId;
//    private String paymentMode;
}
