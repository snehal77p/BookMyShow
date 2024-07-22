package BookMyShow.BookMyShow.DTOs;

import BookMyShow.BookMyShow.Modal.Seat;
import BookMyShow.BookMyShow.Modal.Show;
import BookMyShow.BookMyShow.MyEnums.ShowSeatStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeatDTO {
    private int price;
    private int seatId;
    private int showId;
    private ShowSeatStatus showSeatStatus;
}
