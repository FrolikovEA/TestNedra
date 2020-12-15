package ru.frolikovtestnedra.demo.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.frolikovtestnedra.demo.service.CounterService;

@RestController
@RequestMapping("/Nedra")
@AllArgsConstructor
public class CounterController {

    private final CounterService counterService;

    @GetMapping("/addClick")
    public ResponseEntity<?> addClick(){
        counterService.addClick();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/getCount")
    public ResponseEntity<Long> getCount(){
        return new ResponseEntity<>(counterService.getCount() , HttpStatus.OK) ;
    }
}
