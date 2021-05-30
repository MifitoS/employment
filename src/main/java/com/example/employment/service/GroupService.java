package com.example.employment.service;

import com.example.employment.dto.GetAllGroupResponseDTO;
import com.example.employment.dto.GetGroupResponseDTO;
import com.example.employment.dto.GroupRequestAddDTO;

import java.util.List;

public interface GroupService {
    void add(GroupRequestAddDTO group);


    GetGroupResponseDTO get(Long id);

    List<GetAllGroupResponseDTO> getAll();
}
