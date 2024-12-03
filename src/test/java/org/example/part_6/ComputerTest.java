package org.example.part_6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    void testCreateModel() {
        computer.createModel("Dell XPS 15");
        assertEquals("Dell XPS 15", computer.model);
    }

    @Test
    void testSetPrice() {
        computer.setPrice(1500.00);
        assertEquals(1500.00, computer.price);
    }

    @Test
    void testAddRAM() {
        computer.addRAM(8);
        assertEquals(8, computer.ram);
        computer.addRAM(16);
        assertEquals(24, computer.ram);
    }

    @Test
    void testChangeScreenResolution() {
        computer.changeScreenResolution("1920x1080");
        assertEquals("1920x1080", computer.screenResolution);
    }

    @Test
    void testChangeProcessor() {
        computer.changeProcessor("Intel i7");
        assertEquals("Intel i7", computer.processor);
    }

    @Test
    void testAddComponent() {
        computer.addComponent("NVIDIA GTX 1650");
        assertTrue(computer.components.contains("NVIDIA GTX 1650"));
    }

    @Test
    void testDisplayInfo() {
        computer.createModel("MacBook Pro");
        computer.setPrice(2000.00);
        computer.addRAM(16);
        computer.changeScreenResolution("2560x1600");
        computer.changeProcessor("Apple M1");
        computer.addComponent("Magic Keyboard");


        assertEquals("MacBook Pro", computer.model);
        assertEquals(2000.00, computer.price);
        assertEquals(16, computer.ram);
        assertEquals("2560x1600", computer.screenResolution);
        assertEquals("Apple M1", computer.processor);
        assertTrue(computer.components.contains("Magic Keyboard"));
    }
}
