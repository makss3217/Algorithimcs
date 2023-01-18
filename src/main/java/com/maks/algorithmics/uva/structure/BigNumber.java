package com.maks.algorithmics.uva.structure;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class BigNumber {
    private static final Scanner scanner = new Scanner(new InputStreamReader(System.in));

    public static void run() {
        while (scanner.hasNextInt()) {
            testCase();
        }
    }

    private static void testCase() {
        final int A = scanner.nextInt();
        final int N = scanner.nextInt();
        BigInteger sum = BigInteger.ZERO;
        BigInteger ingredient;
        for(int i = 1; i <= N; i++) {
            ingredient = BigInteger.valueOf(A);
            sum = sum.add(ingredient.pow(i).multiply(BigInteger.valueOf(i)));
        }
        System.out.println(sum);
    }
}
