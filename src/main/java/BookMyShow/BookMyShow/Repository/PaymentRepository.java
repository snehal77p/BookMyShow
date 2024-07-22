package BookMyShow.BookMyShow.Repository;

import BookMyShow.BookMyShow.Modal.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
