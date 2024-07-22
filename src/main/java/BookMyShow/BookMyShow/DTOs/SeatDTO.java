package BookMyShow.BookMyShow.DTOs;

import BookMyShow.BookMyShow.MyEnums.SeatType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {
    private int seatNumber;
    @Enumerated
    private SeatType seatType;
    private int seatRow;
    private int seatCol;
    private int auditoriumId;
}
