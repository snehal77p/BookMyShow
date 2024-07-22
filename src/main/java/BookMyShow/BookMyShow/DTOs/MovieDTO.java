package BookMyShow.BookMyShow.DTOs;

import BookMyShow.BookMyShow.MyEnums.AuditoriumFeature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDTO {
    private String name;
    private String description;
    private List<AuditoriumFeature> auditoriumFeatures;
}
