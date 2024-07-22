package BookMyShow.BookMyShow.Repository;

import BookMyShow.BookMyShow.Modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByMailId(String mailId);
    User getByMailId(String mailId);
}
