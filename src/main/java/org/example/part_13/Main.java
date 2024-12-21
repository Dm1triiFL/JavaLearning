package org.example.part_13;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            PointRepository repository = new PointRepository();

            PointService service = new PointService(repository);
            service.addPoint(new Point(1, 2));
            service.addPoint(new Point(2, 3));
            service.addPoint(new Point(3, 6));

            Point origin = new Point(0, 0);
            System.out.println("Ближайшая: " + service.findNearestPoint(origin));
            System.out.println("Удаленная: " + service.findFurthestPoint(origin));

            repository.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
