package org.example.part_6;

public class SmartPhone extends Computer {
    private String operatingSystem;

    public SmartPhone(String model, double price, int ram, String screenResolution, String processor, String operatingSystem) {
        createModel(model);
        setPrice(price);
        addRAM(ram);
        changeScreenResolution(screenResolution);
        changeProcessor(processor);
        this.operatingSystem = operatingSystem;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Operating System: " + operatingSystem);
    }

    // Дополнительный метод для смартфона
    public void installApp(String app) {
        System.out.println("Installing app: " + app);
    }
}

