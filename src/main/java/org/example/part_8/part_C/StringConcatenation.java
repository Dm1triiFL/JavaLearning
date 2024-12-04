package org.example.part_8.part_C;

public class StringConcatenation {

    private static final int CHAR_COUNT = 1_000_000;

    public static void main(String[] args) {
        long durationString = measureString();
        System.out.println("Время для String: " + durationString + " нс");

        long durationStringBuilder = measureStringBuilder();
        System.out.println("Время для StringBuilder: " + durationStringBuilder + " нс");
    }

    private static long measureString() {
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < CHAR_COUNT; i++) {
            str += 'a';
        }
        return System.nanoTime() - startTime;
    }

    private static long measureStringBuilder() {
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < CHAR_COUNT; i++) {
            stringBuilder.append('a');
        }
        String result = stringBuilder.toString();
        return System.nanoTime() - startTime;
    }
}
