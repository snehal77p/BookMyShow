package BookMyShow.BookMyShow.Modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="bmsShow")
public class Show extends BaseModel{
    private LocalDateTime dateNStartTime;
    private LocalDateTime dateNEndTime;
    @ManyToOne
    @JoinColumn(name = "movie")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "auditorium_id")
    @JsonBackReference
    private Auditorium auditorium;
    @OneToMany
    @JoinColumn(name = "show_id")
    @JsonManagedReference
    private List<ShowSeat> showSeats;
    @OneToMany
    @JoinColumn(name = "show_id")
    List<City> city;
}

