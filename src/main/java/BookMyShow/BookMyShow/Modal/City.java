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
public class City extends BaseModel{
    private String name;
    @OneToMany
//    @JoinColumn(name = "city_id")
    private List<Theaters> theatersList;


}