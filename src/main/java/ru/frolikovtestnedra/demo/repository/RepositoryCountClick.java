package ru.frolikovtestnedra.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCountClick extends CrudRepository<Country,Long> {

}
