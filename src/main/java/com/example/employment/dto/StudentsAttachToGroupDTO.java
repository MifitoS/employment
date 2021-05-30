package com.example.employment.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentsAttachToGroupDTO {
   private Long id;
   private String name;
   private LocalDate createAt;

}
