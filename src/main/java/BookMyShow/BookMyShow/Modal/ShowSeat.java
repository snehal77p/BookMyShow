package BookMyShow.BookMyShow.Modal;

import BookMyShow.BookMyShow.MyEnums.ShowSeatStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeat extends BaseModel{

    private int price;
    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;
    @ManyToOne
    @JoinColumn(name = "show_id")
    @JsonBackReference
    private Show show;
    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;
}
