package com.example.employment.repository;

import com.example.employment.model.UniversityGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//репозиторий хранит в себе инфу.
// Репозиторий делает бины из всех наследников
//в crud у нас нужные нам методы

@Repository
public interface GroupRepository extends CrudRepository<UniversityGroup,Long> {

    List<UniversityGroup> findAll();

}
