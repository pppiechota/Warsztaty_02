package com.piotrpiechota;

import java.util.Scanner;

public class InputUtils {

    public static int getNumber() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            sc.next();
        }

        return sc.nextInt();
    }
}
