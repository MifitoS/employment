package com.example.employment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllGroupResponseDTO {
    Long id;
    String name;
    int quantity;

    //quantity - колличество студентов
}
