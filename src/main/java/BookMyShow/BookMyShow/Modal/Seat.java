package BookMyShow.BookMyShow.Modal;

import BookMyShow.BookMyShow.MyEnums.SeatStatus;
import BookMyShow.BookMyShow.MyEnums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Seat extends BaseModel{
    private int seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    private int seatRow;
    private int seatCol;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;
}
