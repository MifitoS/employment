package com.example.employment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//тип группы добавляем по имени
//суть класса принять данные с фронта
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupRequestAddDTO {
  private String name;

}
