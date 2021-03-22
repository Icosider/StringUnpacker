package ru.icosider.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import ru.icosider.stringunpacker.service.UnpackService;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUnpackerTest {
    private UnpackService service;

    @BeforeEach
    public void setup() {
        this.service = new UnpackService("3[xyz]4[xy]z");
    }

    @RepeatedTest(2)
    public void validate() {
        assertDoesNotThrow(() -> this.service.validate(), "The text is invalidate!");
    }

    @RepeatedTest(2)
    public void parse() {
        assertEquals("xyzxyzxyzxyxyxyxyz", this.service.parse(), "Parse failure!");
    }
}