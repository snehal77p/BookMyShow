package BookMyShow.BookMyShow.Modal;

import BookMyShow.BookMyShow.MyEnums.AuditoriumFeature;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Movie extends BaseModel{
    @Column(name = "movieName")
    private String name;
    private String movieDescription;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeature> auditoriumFeatures;
}
