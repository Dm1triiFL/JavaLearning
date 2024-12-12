package org.example.part_13;

import java.util.List;

import java.util.List;

public class PointService {
    private final PointRepository repository = new PointRepository();

    public void addPoint(Point point) {
        repository.addPoint(point);
    }

    public Point findNearestPoint(Point origin) {
        List<Point> points = repository.getAllPoints();
        return points.stream().min((p1, p2) -> Double.compare(p1.distance(origin), p2.distance(origin))).orElse(null);
    }

    public Point findFurthestPoint(Point origin) {
        List<Point> points = repository.getAllPoints();
        return points.stream().max((p1, p2) -> Double.compare(p1.distance(origin), p2.distance(origin))).orElse(null);
    }

    public List<Point> findCollinearPoints(Point point1, Point point2) {
        List<Point> points = repository.getAllPoints();
        double k = (point2.getY() - point1.getY()) / (point2.getX() - point1.getX());
        double b = point1.getY() - k * point1.getX();
        return points.stream().filter(p -> p.getY() == k * p.getX() + b).toList();
    }
}

