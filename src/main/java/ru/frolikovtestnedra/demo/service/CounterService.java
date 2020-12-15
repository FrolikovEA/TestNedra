package ru.frolikovtestnedra.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.frolikovtestnedra.demo.component.CounterComponent;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;

@Service
@AllArgsConstructor
public class CounterService {

    private final CounterComponent counterComponent;

    private final AtomicLong countClick=new AtomicLong(0);

    // инициализация заначения из БД
    @PostConstruct
    public void after(){
        countClick.getAndAdd(counterComponent.getDataBaseCount());
    }

    //добавляем новое значение
    public void addClick(){
        countClick.incrementAndGet();
    }

    // получаем значение
    public Long getCount(){
        return countClick.get();
    }
}
