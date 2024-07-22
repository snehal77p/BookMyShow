package BookMyShow.BookMyShow.Service;

import BookMyShow.BookMyShow.DTOs.PaymentDTO;
import BookMyShow.BookMyShow.Modal.Payment;
import BookMyShow.BookMyShow.MyEnums.PaymentStatus;
import BookMyShow.BookMyShow.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public Payment makePayment(PaymentDTO paymentDTO)
    {
        Payment payment = new Payment();
        payment.setPaymentTime(LocalDateTime.now());
        payment.setAmount(payment.getAmount());
        payment.setTicket(payment.getTicket());
        paymentRepository.save(payment);
        return payment;
    }

    public Payment findPaymentById(int paymentId)
    {
        return paymentRepository.findById(paymentId).get();
    }
    public List<Payment> findAllPayments()
    {
        return paymentRepository.findAll();
    }

}
