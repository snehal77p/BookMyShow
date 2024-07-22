package BookMyShow.BookMyShow.DTOs;

import BookMyShow.BookMyShow.MyEnums.AuditoriumFeature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuditoriumDTO {
    private String name;
    private int capacity;
    private int audiRow;
    private int audiCol;
    private List<AuditoriumFeature> auditoriumFeatures;
    private int theaterId;
}
