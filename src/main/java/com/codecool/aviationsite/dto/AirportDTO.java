package com.codecool.aviationsite.dto;

import lombok.Data;

@Data
public class AirportDTO {
    private String name;
    private int numberOfAsphaltRunways;
    private int numberOfGrassRunways;
}
