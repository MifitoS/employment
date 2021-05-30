package com.example.employment.repository;

import com.example.employment.model.Student;
import com.example.employment.model.UniversityGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//репозиторий хранит в себе инфу.
// Репозиторий делает бины из всех наследников
//в crud у нас нужные нам методы

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {



}
