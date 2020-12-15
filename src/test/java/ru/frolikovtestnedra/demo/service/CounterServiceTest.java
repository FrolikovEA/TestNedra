package ru.frolikovtestnedra.demo.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.frolikovtestnedra.demo.component.CounterComponent;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
class CounterServiceTest {

    private CounterService counterService;

    @Mock
    private  CounterComponent counterComponent;



    @Test
    void addClick() {
        counterService = new CounterService(counterComponent);
        counterService.addClick();
        Long Ret=counterService.getCount();
        assertEquals(Ret,1L);
    }

    @Test
    void getCount() {
        counterService = new CounterService(counterComponent);;
        Assert.assertEquals(java.util.Optional.ofNullable(counterService.getCount()), Optional.of(0L));
    }
}