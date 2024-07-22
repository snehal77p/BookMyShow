package BookMyShow.BookMyShow.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class Theaters extends BaseModel {
    private String name;
    private String address;
    @OneToMany
    @JoinColumn(name = "theater_id")
    private List<Auditorium> auditoriumList;
}
