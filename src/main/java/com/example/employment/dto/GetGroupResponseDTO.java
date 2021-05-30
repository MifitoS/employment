package com.example.employment.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

//DTO нужно чтобы данные передавать
//чтобы они мапили на JSON
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetGroupResponseDTO {

   private Long id;
   private String name;
   private Set<StudentsAttachToGroupDTO> students;
}
