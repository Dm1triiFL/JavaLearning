package org.example.part_6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PadTest {

    private Pad pad;

    @BeforeEach
    void setUp() {
        pad = new Pad("iPad Pro", 999.99, 12, "2732x2048", "A12Z Bionic", true);
    }

    @Test
    void testConstructor() {
        assertEquals("iPad Pro", pad.model);
        assertEquals(999.99, pad.price);
        assertEquals(12, pad.ram);
        assertEquals("2732x2048", pad.screenResolution);
        assertEquals("A12Z Bionic", pad.processor);
        assertTrue(pad.hasStylus);
    }

    @Test
    void testDisplayInfo() {

        pad.displayInfo();

        assertEquals("iPad Pro", pad.model);
        assertEquals(999.99, pad.price);
        assertEquals(12, pad.ram);
        assertEquals("2732x2048", pad.screenResolution);
        assertEquals("A12Z Bionic", pad.processor);
        assertTrue(pad.hasStylus);
    }

    @Test
    void testDraw() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String drawing = "A beautiful landscape";
        pad.draw(drawing);

        assertTrue(outputStream.toString().contains("Drawing: " + drawing));
    }
}
