package org.example.part_6;

import java.util.ArrayList;
import java.util.List;

public class Computer implements ComputerManagement {
    protected String model;
    protected double price;
    protected int ram;
    protected String screenResolution;
    protected String processor;
    protected List<String> components;

    public Computer() {
        components = new ArrayList<>();
    }

    @Override
    public void createModel(String model) {
        this.model = model;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void addRAM(int additionalRam) {
        this.ram += additionalRam;
    }

    @Override
    public void changeScreenResolution(String newResolution) {
        this.screenResolution = newResolution;
    }

    @Override
    public void changeProcessor(String newProcessor) {
        this.processor = newProcessor;
    }

    @Override
    public void addComponent(String component) {
        components.add(component);
    }

    @Override
    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Screen Resolution: " + screenResolution);
        System.out.println("Processor: " + processor);
        System.out.println("Components: " + components);
    }
}

