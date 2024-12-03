package org.example.part_2.part_B;


public class AnyBaseToAnyBase {
    public String convert(String number, int fromBase, int toBase) {
        int decimalValue = Integer.parseInt(number, fromBase);
        return Integer.toString(decimalValue, toBase);
    }
}
