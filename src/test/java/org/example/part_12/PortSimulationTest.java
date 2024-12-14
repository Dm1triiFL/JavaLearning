package org.example.part_12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class PortSimulationTest {
    private Port port;

    @BeforeEach
    void setUp() {
        port = new Port(3, 100);
    }

    @Test
    void testLoadContainers() {
        port.loadContainers(20);
        assertEquals(20, port.containersInPort);
    }

    @Test
    void testUnloadContainers() {
        port.loadContainers(30);
        port.unloadContainers(10);
        assertEquals(20, port.containersInPort);
    }

    @Test
    void testCanDock() {
        Ship ship = new Ship("Корабль 1", 50);
        assertTrue(port.canDock(ship));

        port.loadContainers(60);
        assertFalse(port.canDock(new Ship("Корабль 2", 50)));
    }


    @Test
    void testMultipleShipLoadingAndUnloading() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Ship[] ships = {
                new Ship("Корабль 1", 110),
                new Ship("Корабль 2", 50),
                new Ship("Корабль 3", 30)
        };

        for (Ship ship : ships) {
            executor.submit(() -> {
                try {
                    Dock dock = port.getAvailableDock();
                    if (dock != null) {
                        dock.loadShip(ship);
                        dock.unloadShip(ship);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        assertEquals(0, port.containersInPort);
    }
}