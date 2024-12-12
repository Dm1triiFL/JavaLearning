package org.example.part_10.part_B.service;

import org.example.part_10.part_B.model.Tariff;
import org.example.part_10.part_B.service.TariffConnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TariffConnectorTest {

    private TariffConnector tariffConnector;
    private List<Tariff> tariffs;

    @BeforeEach
    void setUp() {
        tariffConnector = new TariffConnector();
        Tariff tariff1 = new Tariff("Тариф 1", 100);
        Tariff tariff2 = new Tariff("Тариф 2", 200);
        tariffs = Arrays.asList(tariff1, tariff2);
    }

    @Test
    void testSaveTariffs() {
        assertDoesNotThrow(() -> tariffConnector.saveTariffs(tariffs));


    }

    @Test
    void testLoadTariffs() {
        tariffConnector.saveTariffs(tariffs);

        List<Tariff> loadedTariffs = tariffConnector.loadTariffs();

        assertNotNull(loadedTariffs);
        assertEquals(tariffs.size(), loadedTariffs.size());
        assertEquals(tariffs.get(0).getName(), loadedTariffs.get(0).getName());
    }

    @Test
    void testLoadTariffsWhenFileDoesNotExist() {
        new File("tariffs.ser").delete();

        List<Tariff> loadedTariffs = tariffConnector.loadTariffs();

        assertNull(loadedTariffs);
    }
}
