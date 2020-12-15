package ru.frolikovtestnedra.demo.component;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.frolikovtestnedra.demo.repository.Country;
import ru.frolikovtestnedra.demo.repository.RepositoryCountClick;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class CounterComponentTest {

    @Mock
    private  RepositoryCountClick repositoryCountClick;

    private CounterComponent counterComponent;


    @Test
    void getDataBaseCount() {
        counterComponent= new CounterComponent(repositoryCountClick);
        when(repositoryCountClick.findById(anyLong())).thenReturn(Optional.of(Country.builder().id(1L).countClick(10L).build()));
        Long ret = counterComponent.getDataBaseCount();
        assertEquals(ret, 10L);
    }

    @Test
    void saveBDCountry() {
        counterComponent= new CounterComponent(repositoryCountClick);
        when(repositoryCountClick.save(any())).thenReturn(Country.builder().build());
        counterComponent.saveBDCountry(1L);
    }
}