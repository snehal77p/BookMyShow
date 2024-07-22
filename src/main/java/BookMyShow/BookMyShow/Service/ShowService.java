package BookMyShow.BookMyShow.Service;

import BookMyShow.BookMyShow.DTOs.ShowDTO;
import BookMyShow.BookMyShow.Modal.Auditorium;
import BookMyShow.BookMyShow.Modal.Show;
import BookMyShow.BookMyShow.Modal.ShowSeat;
import BookMyShow.BookMyShow.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private ShowSeatService showSeatService;
    @Autowired
    private MovieService movieService;

    public Show addShow(ShowDTO showDTO)
    {
        Show show = new Show();
        show.setDateNStartTime(LocalDateTime.parse(showDTO.getDateAndStartTime())); //"2018-10-23T17:19:33"
        show.setDateNEndTime(LocalDateTime.parse(showDTO.getDateAndEndTime()));
        show.setMovie(movieService.findMovieByName(showDTO.getMovieName()));
        Show show1 = showRepository.save(show);
        if(show1==null)
        {
            return null;
        }
        this.addShowInAuditorium(show, showDTO);
        this.addShowSeatForShow(show,showDTO);
        return show;
    }

    public void updateShow(Show show) {
        showRepository.save(show);
    }

    public Show findShowById(int showId) {
        Optional<Show> show = showRepository.findById(showId);
        if (show.isPresent()) {
            return showRepository.findById(showId).get();
        } else
        {
            return null;
        }
    }
    public List<Show> findShowByAuditorium(String auditoriumName)
    {
        Auditorium auditorium = auditoriumService.findAuditoriumByName(auditoriumName);
        return auditorium.getShow();
    }
    public void deleteShowById(int showId)
    {
        showRepository.deleteById(showId);
    }

    public void addShowInAuditorium(Show show, ShowDTO showDTO)
    {
        Auditorium auditorium = auditoriumService.findAuditoriumById(showDTO.getAuditoriumId());
        if(auditorium==null)
        {
            return;
        }
        List<Show> showList = auditorium.getShow();
        if(showList==null)
        {
            auditorium.setShow(new ArrayList<Show>());
            showList = auditorium.getShow();
        }
        showList.add(show);

        auditoriumService.updateAuditorium(auditorium);
    }

    public void addShowSeatForShow(Show show, ShowDTO showDTO)
    {
        Auditorium auditorium = auditoriumService.findAuditoriumById(showDTO.getAuditoriumId());
        if(auditorium==null)
        {
            return;
        }
        ArrayList<ShowSeat> showSeats = new ArrayList<>();
        for(int i=0; i<auditorium.getCapacity(); i++)
        {
            showSeats.add(showSeatService.addShowSeat(auditorium,show,auditorium.getSeat().get(i)));
        }
        show.setShowSeats(showSeats);
        Show show1 = showRepository.save(show);

    }
}

