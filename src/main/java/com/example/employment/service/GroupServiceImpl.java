package com.example.employment.service;

import com.example.employment.dto.GetAllGroupResponseDTO;
import com.example.employment.dto.GetGroupResponseDTO;
import com.example.employment.dto.GroupRequestAddDTO;
import com.example.employment.dto.StudentsAttachToGroupDTO;
import com.example.employment.model.Student;
import com.example.employment.model.UniversityGroup;
import com.example.employment.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

//service как component
@Service
public class GroupServiceImpl implements GroupService {
    //simpleJPARepository имеет все методы нужные нам

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void add(GroupRequestAddDTO group) {
        //Сохранение в БД
        UniversityGroup groupToBD = UniversityGroup.builder()
                .name(group.getName())
                .createAt(LocalDate.now())
                .build();

        groupRepository.save(groupToBD);
    }

    @Override
    public GetGroupResponseDTO get(Long id) {
        Optional<UniversityGroup> byId = groupRepository.findById(id);

        UniversityGroup universityGroup = byId.get();

        Set<Student> students = universityGroup.getStudents();
        //Превращаем студентов в DTOшки
        //Студент привязан к БД. Когда будем выводить, выведет поле group, а оно нам не нужно
        //поэтому превращаем студентов в DTOстюдентс)
        Set<StudentsAttachToGroupDTO> collect = students.stream()
                .map(student -> StudentsAttachToGroupDTO.builder()
                        .id(student.getId())
                        .name(student.getName())
                        .createAt(student.getCreateAt())
                        .build())
                .collect(Collectors.toSet());


        GetGroupResponseDTO groupResponseDTO = GetGroupResponseDTO.builder()
                .id(universityGroup.getId())
                .name(universityGroup.getName())
                .students(collect)
                .build();

            return groupResponseDTO;
    }

    //здесь короч CrudRepository записывал нам groupRepository в Iterable
    //А нам нужен был List
    //Поэтому мы в GroupRepository создали свой собственный метод
    //Т.е. findAll тупо перезаписали
    @Override
    public List<GetAllGroupResponseDTO> getAll() {


        List<UniversityGroup> all = groupRepository.findAll();

        return all.stream()
                .map(group -> {
                   return GetAllGroupResponseDTO.builder()
                            .id(group.getId())
                            .name(group.getName())
                            .quantity(group.getStudents().size())
                            .build();
                })
                .collect(Collectors.toList());
    }
}
