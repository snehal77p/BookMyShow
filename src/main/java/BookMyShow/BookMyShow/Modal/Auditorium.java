package BookMyShow.BookMyShow.Modal;

import BookMyShow.BookMyShow.MyEnums.AuditoriumFeature;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Auditorium extends BaseModel{
    private String name;
    private int capacity;
    @OneToMany
    @JoinColumn(name = "auditorium_id")
    @JsonManagedReference
    private List<Show> show;
    @OneToMany
    @JoinColumn(name = "auditorium_id")
    private List<Seat> seat;
    @ElementCollection(targetClass = AuditoriumFeature.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "auditoriumFeatures", joinColumns = @JoinColumn(name = "auditorium_id"))
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeature> auditoriumFeatures;
}
