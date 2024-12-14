package org.example.part_12;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Port {
    private final Dock[] docks;
    private final int capacity;
    int containersInPort;
    private final Lock lock = new ReentrantLock();
    private final Condition canLoad = lock.newCondition();
    private final Condition canUnload = lock.newCondition();

    public Port(int numberOfDocks, int capacity) {
        this.docks = new Dock[numberOfDocks];
        this.capacity = capacity;
        this.containersInPort = 0;

        for (int i = 0; i < numberOfDocks; i++) {
            docks[i] = new Dock(this);
        }
    }

    public void loadContainers(int number) {
        lock.lock();
        try {
            containersInPort += number;
            canUnload.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void unloadContainers(int number) {
        lock.lock();
        try {
            containersInPort -= number;
            canLoad.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public boolean canDock(Ship ship) {
        return (containersInPort + ship.getContainers() <= capacity);
    }

    public Dock getAvailableDock() throws InterruptedException {
        lock.lock();
        try {
            for (Dock dock : docks) {
                if (!dock.isOccupied()) {
                    return dock;
                }
            }
            for (Dock dock : docks) {
                dock.getAvailableCondition().await();
            }
            return null;
        } finally {
            lock.unlock();
        }
    }
}

class Dock {
    private final Port port;
    private boolean occupied;
    private final Lock lock = new ReentrantLock();
    private final Condition availableCondition = lock.newCondition();

    public Dock(Port port) {
        this.port = port;
        this.occupied = false;
    }

    public void occupy() {
        lock.lock();
        try {
            occupied = true;
        } finally {
            lock.unlock();
        }
    }

    public void release() {
        lock.lock();
        try {
            occupied = false;
            availableCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }


    public boolean isOccupied() {
        return occupied;
    }

    public Condition getAvailableCondition() {
        return availableCondition;
    }

    public void loadShip(Ship ship) {
        lock.lock();
        try {
            while (occupied) {
                availableCondition.await();
            }
            occupy();
            port.loadContainers(ship.getContainers());
            System.out.println("Корабль загружен: " + ship.getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            release();
            availableCondition.signal();
            lock.unlock();
        }
    }

    public void unloadShip(Ship ship) {
        lock.lock();
        try {
            while (occupied) {
                availableCondition.await();
            }
            occupy();
            port.unloadContainers(ship.getContainers());
            System.out.println("Корабль разгружен: " + ship.getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            release();
            availableCondition.signal();
            lock.unlock();
        }
    }

}

class Ship {
    private final String name;
    private final int containers;

    public Ship(String name, int containers) {
        this.name = name;
        this.containers = containers;
    }

    public String getName() {
        return name;
    }

    public int getContainers() {
        return containers;
    }
}

public class PortSimulation {
    public static void main(String[] args) {
        System.out.println("Шубин Дмитрий Б762-2 Вариант 1");

        Port port = new Port(3, 100);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            Ship ship = new Ship("Корабль " + (i + 1), (i % 5) + 5);
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
    }
}