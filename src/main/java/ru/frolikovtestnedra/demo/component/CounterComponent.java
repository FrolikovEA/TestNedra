package ru.frolikovtestnedra.demo.component;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.frolikovtestnedra.demo.repository.RepositoryCountClick;
import ru.frolikovtestnedra.demo.repository.Country;


@Component
@AllArgsConstructor
public class CounterComponent {

    private final RepositoryCountClick repositoryCountClick;

    @Transactional(readOnly = true)
    public Long getDataBaseCount(){
        return repositoryCountClick.findById(1L).map(Country::getCountClick).orElse(0L);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRES_NEW)
    public void saveBDCountry(Long count){
        repositoryCountClick.save(
           Country.builder().id(1L).countClick(count).build()
        );
    }
}
