package com.justforge359;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.justforge359.dto.PesDto;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckJsonTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void checkJsonTest() throws IOException {
        File file = new File("src/test/resources/pes.json");
        PesDto dto = objectMapper.readValue(file, PesDto.class);

        assertEquals("Pirozhok", dto.getName());
        assertEquals("Samoyed", dto.getBreed());
        assertEquals("white", dto.getDogCharacteristics().getColor());
        assertEquals("black", dto.getDogCharacteristics().getNose());
        assertEquals(true, dto.getDogCharacteristics().isTailWiggly());
        assertEquals("cunning", dto.getDogCharacteristics().getEyes());
        assertEquals(5, dto.getAge());
    }
}
