package org.example.part_13;

public class Main {
    public static void main(String[] args) {
        PointRepository repository = new PointRepository();
        repository.createTable();

        PointService service = new PointService();
        service.addPoint(new Point(1, 2));
        service.addPoint(new Point(2, 3));
        service.addPoint(new Point(3, 6));

        Point origin = new Point(0, 0);
        System.out.println("Ближайшая: " + service.findNearestPoint(origin));
        System.out.println("Удаленная: " + service.findFurthestPoint(origin));
    }
}
