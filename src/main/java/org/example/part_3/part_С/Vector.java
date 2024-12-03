package org.example.part_3.part_С;

public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Метод для вычисления модуля вектора
    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    // Метод для вычисления скалярного произведения
    public double dotProduct(Vector other) {
        return this.x * other.x + this.y * other.y;
    }

    // Метод для сложения векторов
    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

    // Метод для вычитания векторов
    public Vector subtract(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y);
    }

    // Метод для умножения вектора на константу
    public Vector multiplyByScalar(double scalar) {
        return new Vector(this.x * scalar, this.y * scalar);
    }

    // Метод для проверки коллинеарности
    public boolean isCollinear(Vector other) {
        return this.x * other.y - this.y * other.x == 0;
    }

    // Метод для проверки ортогональности
    public boolean isOrthogonal(Vector other) {
        return this.dotProduct(other) == 0;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
