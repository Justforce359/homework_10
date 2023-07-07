package com.justforge359.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesDto {
    private String name;
    private String breed;
    private int age;
    private DogCharacteristics dogCharacteristics;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DogCharacteristics {
        private String color;
        private String nose;
        private boolean tailWiggly;
        private String eyes;
    }
}
