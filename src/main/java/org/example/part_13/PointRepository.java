package org.example.part_13;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PointRepository {
    private final Connection connection;


    public PointRepository() throws SQLException {
        DatabaseConnection dbConnection = new DatabaseConnection();
        this.connection = dbConnection.getConnection();
        createTable();
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Points (id INTEGER PRIMARY KEY AUTO_INCREMENT, x REAL, y REAL);";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPoint(Point point) {
        String sql = "INSERT INTO Points (x, y) VALUES (?, ?);";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
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
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                points.add(new Point(rs.getDouble("x"), rs.getDouble("y")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return points;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
