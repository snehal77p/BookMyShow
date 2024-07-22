package BookMyShow.BookMyShow.Modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "qaz")
public class SampleClass extends BaseModel{
    @Column(name = "egInt")
    public int egInt;
    @Column(name = "egString")
    public  String egString;
}
