package com.example.employment.service;

import com.example.employment.dto.StudentRequestDTO;
import com.example.employment.model.Student;
import com.example.employment.model.UniversityGroup;
import com.example.employment.repository.GroupRepository;
import com.example.employment.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final GroupRepository groupRepository;

    private final StudentRepository studentRepository;

    public StudentServiceImpl(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void add(StudentRequestDTO studentRequest) {

        Optional<UniversityGroup> byId = groupRepository.findById(studentRequest.getGroupId());
        UniversityGroup universityGroup = byId.get();

        Student build = Student.builder()
                .name(studentRequest.getName())
                .group(universityGroup)
                .createAt(LocalDate.now())
                .build();

        studentRepository.save(build);

    }
}
