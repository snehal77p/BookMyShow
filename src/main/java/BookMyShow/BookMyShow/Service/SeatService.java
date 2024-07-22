package BookMyShow.BookMyShow.Service;

import BookMyShow.BookMyShow.DTOs.SeatDTO;
import BookMyShow.BookMyShow.Modal.Auditorium;
import BookMyShow.BookMyShow.Modal.Seat;
import BookMyShow.BookMyShow.MyEnums.SeatStatus;
import BookMyShow.BookMyShow.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    AuditoriumService auditoriumService;

    public Seat addSeat(SeatDTO seatDTO)
    {
        Seat seat = new Seat();
        seat.setSeatRow(seatDTO.getSeatRow());
        seat.setSeatCol(seatDTO.getSeatCol());
        seat.setSeatType(seatDTO.getSeatType());
        seat.setSeatNumber(seatDTO.getSeatNumber());
        seat.setSeatStatus(SeatStatus.AVAILABLE);
        seatRepository.save(seat);

        this.addSeatInAuditorium(seat, seatDTO);
        return seat;
    }

    public Seat findSeatById(int seatId)
    {
        return seatRepository.findById(seatId).get();
    }

    public Seat findSeatByNumber(int seatNumber)
    {
        return seatRepository.findSeatByseatNumber(seatNumber);
    }

    public void deleteSeatById(int seatId)
    {
        seatRepository.deleteById(seatId);
    }

    public List<Seat> findSeatByAuditorium(String auditoriumName)
    {
        Auditorium auditorium = auditoriumService.findAuditoriumByName(auditoriumName);
        return auditorium.getSeat();
    }

    public void addSeatInAuditorium(Seat seat, SeatDTO seatDTO)
    {
        Auditorium auditorium = auditoriumService.findAuditoriumById(seatDTO.getAuditoriumId());
        List<Seat> seatList = auditorium.getSeat();
        if(seatList==null)
        {
            auditorium.setSeat(new ArrayList<Seat>());
            seatList = auditorium.getSeat();
        }
        seatList.add(seat);
        auditoriumService.updateAuditorium(auditorium);
    }
}
