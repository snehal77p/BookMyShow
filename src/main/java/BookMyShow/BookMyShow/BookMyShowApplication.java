package BookMyShow.BookMyShow;

import BookMyShow.BookMyShow.Controller.InitController;
import BookMyShow.BookMyShow.Modal.City;
import BookMyShow.BookMyShow.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication {


	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

}
