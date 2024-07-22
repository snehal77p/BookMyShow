package BookMyShow.BookMyShow.Controller;

import BookMyShow.BookMyShow.Modal.SampleClass;
import BookMyShow.BookMyShow.Repository.DummyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class DummyController {
    @Autowired
    DummyRepo dummyRepo;

    @PutMapping("/dummyPut")
    public void addDummy(@RequestBody SampleClass sampleClass)
    {
        //abc
        dummyRepo.save(sampleClass);
    }

    @Transactional
    @DeleteMapping("/dummyDelete/{name}")
    public void addDummy(@PathVariable("name") String name)
    {
        dummyRepo.deleteByEgString(name);
    }
}
