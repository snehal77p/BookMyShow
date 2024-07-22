package BookMyShow.BookMyShow.Modal;

import BookMyShow.BookMyShow.MyEnums.PaymentMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel{
    private String name;
    @Column(unique = true)
    private String mailId;
    private String password;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Ticket> ticketList;
//    @Enumerated
//    private PaymentMode paymentMode;
}
