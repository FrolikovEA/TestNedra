package ru.frolikovtestnedra.demo.repository;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    private Long id;
    private Long countClick;
}
