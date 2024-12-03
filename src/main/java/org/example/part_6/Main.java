package org.example.part_6;

public class Main {
    public static void main(String[] args) {
        System.out.println("Шубин Дмитрий Б762-2 Вариант 12");
        // Создание компьютера
        Computer computer = new Computer();
        computer.createModel("Gaming PC");
        computer.setPrice(1500);
        computer.addRAM(16);
        computer.changeScreenResolution("1920x1080");
        computer.changeProcessor("Intel i7");
        computer.addComponent("NVIDIA RTX 3080");
        computer.addComponent("SSD 1TB");
        computer.displayInfo();

        System.out.println();



        // Создание смартфона
        SmartPhone smartPhone = new SmartPhone("Smartphone X", 999, 8, "1080x2400", "Snapdragon 888", "Android");
        smartPhone.displayInfo();
        smartPhone.installApp("WhatsApp");

        System.out.println();

        // Создание планшета
        Pad pad = new Pad("Tab Pro", 799, 12, "2560x1600", "Apple M1", true);
        pad.displayInfo();
        pad.draw("Sunset Landscape");
    }
}

