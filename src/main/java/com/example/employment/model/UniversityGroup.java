package com.example.employment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class UniversityGroup {

    public UniversityGroup() {
    }

    public UniversityGroup(String name, LocalDate createAt) {
        this.name = name;
        this.createAt = createAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private LocalDate createAt;

    @OneToMany(mappedBy = "group")
    private Set<Student> students;
}

//Если бы не было DTO, то взял бы группу из БД, нам пришлось бы
// передавать не нужные нам значения. (дата создания, студенты и тд..)