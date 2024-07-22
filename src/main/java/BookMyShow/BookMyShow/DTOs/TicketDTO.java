package BookMyShow.BookMyShow.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketDTO {
    private List<Integer> showSeatId;
    private int userId;
}
