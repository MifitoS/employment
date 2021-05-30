package com.example.employment.controller;

import com.example.employment.dto.GetAllGroupResponseDTO;
import com.example.employment.dto.GetGroupResponseDTO;
import com.example.employment.dto.GroupRequestAddDTO;
import com.example.employment.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//restController - возвращает объект и данные объекта записываются
// в HTTP ответ, в виде JSON или XML

//суть MVC в том, что к нам приходят запосы, на наше приложение,
// там есть контроллеры, но перед этим стоит диспетчер сервлет,
// который уже получает запросы "сходи туда, сделай это и тд"
@RestController
@RequestMapping(path = "/group")
public class GroupController {


    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    //Если бы мы передали в объект класс universityGroup, то нам пришлось бы все параметры передавать,
    // а ID вообще я не знаЮ, например.
    // А если доп. информация будет передоваться, то придется создавать новую переменную и ЕЁ заносить в БД.
    @PostMapping(path = "/add")
    public void add(@RequestBody GroupRequestAddDTO group) {
        groupService.add(group);
    }

    @GetMapping(path = "/get")
    public GetGroupResponseDTO get(@RequestParam Long id){
       return groupService.get(id);
    }

    @GetMapping("/getAll")
    public List<GetAllGroupResponseDTO> getAll(){
        return groupService.getAll();
    }
}
