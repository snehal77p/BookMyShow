package BookMyShow.BookMyShow.DTOs;

import BookMyShow.BookMyShow.Modal.Auditorium;
import BookMyShow.BookMyShow.Modal.Movie;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShowDTO {
    private String dateAndStartTime; //yyyy-MM-dd-HH-mm-ss
    private String dateAndEndTime;
    private String movieName;
    private int auditoriumId;
}
