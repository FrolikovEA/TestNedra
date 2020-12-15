package ru.frolikovtestnedra.demo.scheduler;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.frolikovtestnedra.demo.component.CounterComponent;
import ru.frolikovtestnedra.demo.service.CounterService;

import java.util.Date;

@Component
@AllArgsConstructor
public class schedulerSaveBD {

    private final CounterService counterService;
    private final CounterComponent counterComponent;

    @Scheduled(fixedRate = 1000)
    public void saveBD(){
        counterComponent.saveBDCountry(counterService.getCount());
    }
}
