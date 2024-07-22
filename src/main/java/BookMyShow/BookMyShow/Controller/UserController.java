package BookMyShow.BookMyShow.Controller;

import BookMyShow.BookMyShow.DTOs.UserLoginDTO;
import BookMyShow.BookMyShow.DTOs.UserSignupDTO;
import BookMyShow.BookMyShow.Modal.User;
import BookMyShow.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public User userSignIn(@RequestBody UserSignupDTO userSignupDTO) throws Exception {
        User user = userService.signUpUser(userSignupDTO);
        return ResponseEntity.ok(user).getBody();
    }

    @GetMapping("/login")
    public User userLogin(@RequestBody UserLoginDTO userLoginDTO) throws Exception {
        User user = userService.loginUser(userLoginDTO);
        return ResponseEntity.ok(user).getBody();
    }

    @GetMapping("/findUserById/{userId}")
    public User findUserById(@PathVariable int userId) throws Exception {
        User user = userService.findUserById(userId);
        return ResponseEntity.ok(user).getBody();
    }

    @DeleteMapping("deleteUserById/{userId}")
    public User deleteUserById(@PathVariable int userId)
    {
        User user = userService.deleteUserById(userId);
        return ResponseEntity.ok(user).getBody();
    }
}
