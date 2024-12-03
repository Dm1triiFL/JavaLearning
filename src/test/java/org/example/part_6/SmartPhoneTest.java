package org.example.part_6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SmartPhoneTest {

    private SmartPhone smartPhone;

    @BeforeEach
    void setUp() {
        smartPhone = new SmartPhone("iPhone 13", 999.99, 6, "2532x1170", "A15 Bionic", "iOS");
    }

    @Test
    void testConstructor() {
        assertEquals("iPhone 13", smartPhone.model);
        assertEquals(999.99, smartPhone.price);
        assertEquals(6, smartPhone.ram);
        assertEquals("2532x1170", smartPhone.screenResolution);
        assertEquals("A15 Bionic", smartPhone.processor);
        assertEquals("iOS", smartPhone.operatingSystem);
    }

    @Test
    void testDisplayInfo() {
        smartPhone.displayInfo();

        assertEquals("iPhone 13", smartPhone.model);
        assertEquals(999.99, smartPhone.price);
        assertEquals(6, smartPhone.ram);
        assertEquals("2532x1170", smartPhone.screenResolution);
        assertEquals("A15 Bionic", smartPhone.processor);
        assertEquals("iOS", smartPhone.operatingSystem);
    }

    @Test
    void testInstallApp() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String app = "WhatsApp";
        smartPhone.installApp(app);

        assertTrue(outputStream.toString().contains("Installing app: " + app));
    }
}
