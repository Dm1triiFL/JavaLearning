package org.example.part_11.part_B;

import java.io.*;
import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class LinesThroughPoints {
    public static void main(String[] args) {
        String inputFileName = "src\\main\\resources\\part_11\\part_B\\input.txt";
        String outputFileName = "src\\main\\resources\\part_11\\part_B\\output.txt";

        List<Point> points = readPointsFromFile(inputFileName);
        Map<String, Set<Point>> linesMap = new HashMap<>();


        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Point p1 = points.get(i);
                Point p2 = points.get(j);
                String lineKey = getLineKey(p1, p2);

                linesMap.putIfAbsent(lineKey, new HashSet<>());
                linesMap.get(lineKey).add(p1);
                linesMap.get(lineKey).add(p2);
            }
        }

        writeLinesToFile(outputFileName, linesMap);
    }

    static List<Point> readPointsFromFile(String fileName) {
        List<Point> points = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] coordinates = line.split(",");
                if (coordinates.length == 2) {
                    int x = Integer.parseInt(coordinates[0].trim());
                    int y = Integer.parseInt(coordinates[1].trim());
                    points.add(new Point(x, y));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return points;
    }

    static void writeLinesToFile(String fileName, Map<String, Set<Point>> linesMap) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Set<Point>> entry : linesMap.entrySet()) {
                if (entry.getValue().size() > 2) {
                    writer.write("Линия: " + entry.getKey() + ", проходит через " + entry.getValue().size() + " точек.\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getLineKey(Point p1, Point p2) {
        int dy = p2.y - p1.y;
        int dx = p2.x - p1.x;

        if (dx == 0) {
            // вертикальная линия
            return "Вертикальная линия x=" + p1.x;
        } else {
            //   нормальная линия
            int gcd = gcd(dy, dx);
            dy /= gcd;
            dx /= gcd;

            // уникальность
            if (dx < 0) {
                dy = -dy;
                dx = -dx;
            }

            return "y = " + dy + "/" + dx + "x + " + (p1.y - (dy * p1.x) / dx);
        }
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? Math.abs(a) : gcd(b, a % b);
    }
}
