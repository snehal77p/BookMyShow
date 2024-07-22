package BookMyShow.BookMyShow.Service;

import BookMyShow.BookMyShow.DTOs.AuditoriumDTO;
import BookMyShow.BookMyShow.Modal.Auditorium;
import BookMyShow.BookMyShow.Modal.Theaters;
import BookMyShow.BookMyShow.MyEnums.AuditoriumFeature;
import BookMyShow.BookMyShow.Repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class AuditoriumService {
    @Autowired
    AuditoriumRepository auditoriumRepository;
    @Autowired
    TheaterService theaterService;

    public Auditorium addAuditorium(AuditoriumDTO auditoriumDTO)
    {
        Auditorium auditorium = new Auditorium();
        auditorium.setName(auditoriumDTO.getName());
        auditorium.setCapacity(auditoriumDTO.getCapacity());
        auditorium.setAuditoriumFeatures(auditoriumDTO.getAuditoriumFeatures());
        Auditorium auditorium1 = auditoriumRepository.save(auditorium);

        this.addAuditoriumInTheater(auditorium, auditoriumDTO);
        return auditorium1;
    }

    public Auditorium findAuditoriumById(int auditoriumId)
    {
        return auditoriumRepository.findById(auditoriumId).get();
    }


    public Auditorium findAuditoriumByName(String auditoriumName)
    {
        return auditoriumRepository.findByName(auditoriumName);
    }

    public void  deleteAuditoriumByName(String auditoriumName)
    {
        System.out.println(auditoriumName+"zxc");
        Long lAudi = auditoriumRepository.deleteByName(auditoriumName);
    }

    public List<Auditorium> findAuditoriumByTheaters(String theaterName)
    {
        Theaters theaters = theaterService.findByName(theaterName);
        return theaters.getAuditoriumList();
    }
    public void deleteAuditoriumById(int auditoriumId)
    {
        auditoriumRepository.deleteById(auditoriumId);
    }

    public void updateAuditorium(Auditorium auditorium) {
        Auditorium auditorium1 = auditoriumRepository.save(auditorium);
        if(auditorium1==null)
        {
            return;
        }
    }

    public void addAuditoriumInTheater(Auditorium auditorium, AuditoriumDTO auditoriumDTO)
    {
        int theaters1 = auditoriumDTO.getTheaterId();
        Theaters theaters = theaterService.findById(theaters1);
        if(theaters == null)
        {
            return;
        }
        List<Auditorium> auditoriumList = theaters.getAuditoriumList();
        if(auditoriumList==null)
        {
            theaters.setAuditoriumList(new ArrayList<Auditorium>());
            auditoriumList = theaters.getAuditoriumList();
        }
        auditoriumList.add(auditorium);
        theaterService.updateTheater(theaters);
    }
}