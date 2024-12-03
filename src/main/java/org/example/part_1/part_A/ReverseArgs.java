package org.example.part_1.part_A;

public class ReverseArgs {
    public void displayReversedArgs(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + (i == 0 ? "" : " "));
        }
        System.out.println();
    }
}