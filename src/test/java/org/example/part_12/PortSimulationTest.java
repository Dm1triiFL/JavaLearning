package org.example.part_12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PortTest {
    @Test
    void testLoadContainers() {
        Port port = new Port(3, 100);
        port.loadContainers(10);
        assertEquals(10, port.containersInPort);
    }

    @Test
    void testUnloadContainers() {
        Port port = new Port(3, 100);
        port.loadContainers(10);
        port.unloadContainers(5);
        assertEquals(5, port.containersInPort);
    }

    @Test
    void testCanDock() {
        Port port = new Port(3, 100);
        Ship ship = new Ship("Корабль 1", 50);
        assertTrue(port.canDock(ship));
    }

    @Test
    void testCannotDock() {
        Port port = new Port(3, 100);
        port.loadContainers(100);
        Ship ship = new Ship("Корабль 1", 10);
        assertFalse(port.canDock(ship));
    }

    @Test
    void testGetAvailableDock() {
        Port port = new Port(3, 100);
        Dock availableDock = port.getAvailableDock();
        assertNotNull(availableDock);
    }

    @Test
    void testDockOccupancy() {
        Port port = new Port(1, 100);
        Dock dock = port.getAvailableDock();
        Ship ship = new Ship("Корабль 1", 10);
        dock.occupy();
        assertTrue(dock.isOccupied());
        dock.release();
        assertFalse(dock.isOccupied());
    }

    @Test
    void testConcurrentLoadingAndUnloading() throws InterruptedException {
        Port port = new Port(3, 100);
        ExecutorService executor = Executors.newFixedThreadPool(6);

        for (int i = 0; i < 6; i++) {
            int shipIndex = i;
            executor.submit(() -> {
                Ship ship = new Ship("Корабль " + (shipIndex + 1), 20);
                Dock dock = port.getAvailableDock();
                if (dock != null) {
                    dock.loadShip(ship);
                    dock.unloadShip(ship);
                }
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }

        assertEquals(0, port.containersInPort);
    }
}
