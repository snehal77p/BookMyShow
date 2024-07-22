package BookMyShow.BookMyShow.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupDTO {
    private String name;
    private String mailId;
    private String password;
}
