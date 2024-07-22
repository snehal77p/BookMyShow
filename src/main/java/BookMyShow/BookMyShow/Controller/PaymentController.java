//package BookMyShow.BookMyShow.Controller;
//
//import BookMyShow.BookMyShow.DTOs.PaymentDTO;
//import BookMyShow.BookMyShow.DTOs.SeatDTO;
//import BookMyShow.BookMyShow.Modal.Payment;
//import BookMyShow.BookMyShow.Modal.Seat;
//import BookMyShow.BookMyShow.Service.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class PaymentController {
//    @Autowired
//    PaymentService paymentService;
//
//    @PostMapping("/makePayment")
//    public ResponseEntity makePayment(@RequestBody PaymentDTO paymentDTO)
//    {
//        Payment payment = paymentService.makePayment(paymentDTO);
//        return ResponseEntity.ok(payment);
//    }
//
//    @GetMapping("/findPaymentById/{paymentId}")
//    public ResponseEntity findPaymentById(@PathVariable("paymentId") int paymentId)
//    {
//        Payment payment = paymentService.findPaymentById(paymentId);
//        return ResponseEntity.ok(payment);
//    }
//
//    @GetMapping("/findAllPayments")
//    public ResponseEntity findAllPayments()
//    {
//        List<Payment> allPayments = paymentService.findAllPayments();
//        return ResponseEntity.ok(allPayments);
//    }
//}
