package com.justforge359;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.justforge359.dto.PesDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class CheckJsonTest {
    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void checkJsonTest() throws IOException {
        File file = new File("src/test/resources/pes.json");
        PesDto dto = objectMapper.readValue(file, PesDto.class);

        Assertions.assertEquals("Pirozhok", dto.getName());
        Assertions.assertEquals("Samoyed", dto.getBreed());
        Assertions.assertEquals("white", dto.getDogCharacteristics().getColor());
        Assertions.assertEquals("black", dto.getDogCharacteristics().getNose());
        Assertions.assertEquals(true, dto.getDogCharacteristics().isTailWiggly());
        Assertions.assertEquals("cunning", dto.getDogCharacteristics().getEyes());
        Assertions.assertEquals(5, dto.getAge());
    }
}
