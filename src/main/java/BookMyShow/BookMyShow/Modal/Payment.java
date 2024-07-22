package BookMyShow.BookMyShow.Modal;

import BookMyShow.BookMyShow.MyEnums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends BaseModel{
    private LocalDateTime paymentTime;
    private double amount;
    private String referenceId;
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
    @Enumerated
    private PaymentStatus paymentStatus;
}
