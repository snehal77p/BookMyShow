package BookMyShow.BookMyShow.Service;

import BookMyShow.BookMyShow.DTOs.UserLoginDTO;
import BookMyShow.BookMyShow.DTOs.UserSignupDTO;
import BookMyShow.BookMyShow.Modal.User;
import BookMyShow.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User loginUser(UserLoginDTO userLoginDTO) throws Exception {
        User user = new User();
        user.setMailId(userLoginDTO.getMailId());
        user.setPassword(userLoginDTO.getPassword());
        if(!userRepository.findAll().contains(userLoginDTO.getMailId()) )
        {
            User existingUser = userRepository.findByMailId(userLoginDTO.getMailId());
            System.out.println(existingUser);
            if(userLoginDTO.getPassword().matches(existingUser.getPassword()) ) {
                System.out.println("Hello " + user.getName() + "! you have logged in!");
            }
            else {
                throw new Exception("Incorrect password.");
            }
            return existingUser;
        }
            System.out.println("IN else");
            throw new Exception("Invalid user! Sign in if you are new user.");
    }

    public User signUpUser(UserSignupDTO userSignupDTO) throws Exception {

        if(!userRepository.findAll().contains(userSignupDTO.getMailId()) )
        {
            User user = new User();
            user.setMailId(userSignupDTO.getMailId());
            user.setPassword(userSignupDTO.getPassword());
            user.setName(userSignupDTO.getName());
            userRepository.save(user);
            System.out.println("Signed in successfully!");
            return user;
        }
        else {
            throw new Exception("This mailId already exists. Login to continue!");
        }
    }

    public User findUserById(int userId) throws Exception {
        if(!(userRepository.findById(userId) == null)) {
            return userRepository.findById(userId).get();
        }
        else
        {
            throw new Exception("User does not exist!");
        }
    }

    public User deleteUserById(int userId)
    {
        userRepository.deleteById(userId);
        System.out.println("User : "+userId+" deleted!");
        return null;
    }
}
