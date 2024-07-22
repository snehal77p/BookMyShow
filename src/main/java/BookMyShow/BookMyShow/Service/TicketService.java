package BookMyShow.BookMyShow.Service;

import BookMyShow.BookMyShow.DTOs.PaymentDTO;
import BookMyShow.BookMyShow.Modal.Payment;
import BookMyShow.BookMyShow.Modal.ShowSeat;
import BookMyShow.BookMyShow.Modal.Ticket;
import BookMyShow.BookMyShow.MyEnums.PaymentStatus;
import BookMyShow.BookMyShow.MyEnums.ShowSeatStatus;
import BookMyShow.BookMyShow.MyEnums.TicketStatus;
import BookMyShow.BookMyShow.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    public TicketRepository ticketRepository;
    @Autowired
    public ShowSeatService showSeatService;
    @Autowired
    public PaymentService paymentService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatId, int userId) throws Exception {
        for( int showSeat1: showSeatId)
        {
            ShowSeat showSeat = showSeatService.findShowSeatById(showSeat1);
            if(showSeat.getShowSeatStatus() != ShowSeatStatus.AVAILABLE)
            {
                throw new Exception("Seat is not available");
            }
        }
        List<ShowSeat> showSeats = new ArrayList<>();
        int totalAmount=0;
        for( int showSeat1: showSeatId)
        {
            ShowSeat showSeat = showSeatService.findShowSeatById(showSeat1);
            if(showSeat.getShowSeatStatus() == ShowSeatStatus.AVAILABLE)
            {
                showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
                showSeatService.saveShowSeat(showSeat);

                totalAmount =+ showSeat.getPrice();
            }
            showSeats.add(showSeat);

        }
        Ticket ticket = new Ticket();
//        makePayment(totalAmount,ticket);

        ticket.setShowSeats(showSeats);
        ticket.setTicketStatus(TicketStatus.BOOKED);

        return ticket;
    }

    public void makePayment(int totalAmount, Ticket ticket) throws Exception {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setTicketId(ticket.getId());
        paymentDTO.setAmount(totalAmount);

        Payment recentPayment = paymentService.makePayment(paymentDTO);

        if(recentPayment.getPaymentStatus().equals(PaymentStatus.PAID))
        {
            System.out.println("Payment Successful!");
        }
        else {
            throw new Exception("Payment failed!");
        }
    }
}
