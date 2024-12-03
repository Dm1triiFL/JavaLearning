package org.example.part_3.part_B;

public class ComplexOperations {

    public static Complex add(Complex[] complexes) {
        double realSum = 0;
        double imaginarySum = 0;

        for (Complex complex : complexes) {
            realSum += complex.getReal();
            imaginarySum += complex.getImaginary();
        }

        return new Complex(realSum, imaginarySum);
    }

    public static Complex multiply(Complex[] complexes) {
        double realProduct = 1;
        double imaginaryProduct = 0;

        for (Complex complex : complexes) {
            double tempReal = realProduct * complex.getReal() - imaginaryProduct * complex.getImaginary();
            imaginaryProduct = realProduct * complex.getImaginary() + imaginaryProduct * complex.getReal();
            realProduct = tempReal;
        }

        return new Complex(realProduct, imaginaryProduct);
    }
}
