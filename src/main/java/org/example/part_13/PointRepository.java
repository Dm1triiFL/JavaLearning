package org.example.part_13;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PointRepository {
    private final DatabaseConnection dbConnection = new DatabaseConnection();

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Points (id INTEGER PRIMARY KEY AUTOINCREMENT, x REAL, y REAL);";
        try (Connection conn = dbConnection.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPoint(Point point) {
        String sql = "INSERT INTO Points (x, y) VALUES (?, ?);";
        try (Connection conn = dbConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, point.getX());
            pstmt.setDouble(2, point.getY());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Point> getAllPoints() {
        List<Point> points = new ArrayList<>();
        String sql = "SELECT x, y FROM Points;";
        try (Connection conn = dbConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                points.add(new Point(rs.getDouble("x"), rs.getDouble("y")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return points;
    }
}
