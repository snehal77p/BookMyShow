package BookMyShow.BookMyShow.Service;

import BookMyShow.BookMyShow.DTOs.MovieDTO;
import BookMyShow.BookMyShow.DTOs.ShowSeatDTO;
import BookMyShow.BookMyShow.Modal.*;
import BookMyShow.BookMyShow.MyEnums.AuditoriumFeature;
import BookMyShow.BookMyShow.MyEnums.SeatType;
import BookMyShow.BookMyShow.MyEnums.ShowSeatStatus;
import BookMyShow.BookMyShow.Repository.SeatRepository;
import BookMyShow.BookMyShow.Repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowSeatService {
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    SeatService seatService;
    @Autowired
    AuditoriumService auditoriumService;


    public ShowSeat addShowSeat(Auditorium auditorium, Show show, Seat seat) {
        ShowSeat showSeat = new ShowSeat();
        showSeat.setPrice(this.ShowSeatPrice(seat,show));
        showSeat.setSeat(seat);
        showSeat.setShow(show);
        showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);

        ShowSeat showSeat1 = showSeatRepository.save(showSeat);

        return showSeat1;
    }
    private int ShowSeatPrice(Seat seat, Show show ) {
        int price = 100;
//        if(seat.getSeatType()== SeatType.SILVER)
//        {
//            price=+50;
//        }
//        else if(seat.getSeatType()== SeatType.GOLD)
//        {
//            price=+100;
//        }
//        else if(seat.getSeatType()== SeatType.PLATINUM)
//        {
//            price=+200;
//        }
//        for (int i=0; i<(show.getAuditorium().getAuditoriumFeatures()).size(); i++)
//        {
//            AuditoriumFeature auditoriumFeature=show.getAuditorium().getAuditoriumFeatures().get(i);
//
//            if(auditoriumFeature == AuditoriumFeature.TWOD )
//            {
//                price+=100;
//            }
//            else if (auditoriumFeature==AuditoriumFeature.THREED) {
//                price += 200;
//            }
//            else if (auditoriumFeature==AuditoriumFeature.IMAX) {
//                price += 300;
//            }
//
//        }
        return price;
    }


    public ShowSeat findShowSeatById(int showSeatId)
    {
        return showSeatRepository.findById(showSeatId).get();
    }

    public void deleteShowSeatById(int showSeatId) {
        showSeatRepository.findById(showSeatId).get();
    }

    public ShowSeat saveShowSeat(ShowSeat showSeat)
    {
        return showSeatRepository.save(showSeat);
    }

}
