package com.maks.algorithmics.uva.structure;

import java.io.InputStreamReader;
import java.util.Scanner;

public class BitManipulation {

    private static final Scanner scanner = new Scanner(new InputStreamReader(System.in));
    private static final int MAX_SIZE = 33000;

    public static void run() {
        while (scanner.hasNextInt()) {
            testCase();
        }
    }

    private static void testCase() {
        final int[] cornersWeight = new int[MAX_SIZE];
        final int N = scanner.nextInt();
        final int cornersAmount = (int) Math.pow(2, N);
        int weight;
        int neighbour;
        int maxSum = 0;
        for(int i = 0; i < cornersAmount; i++) {
            weight = scanner.nextInt();
            for(int j = 0; j < N; j++) {
                neighbour = (i ^ (1 << j));
                cornersWeight[neighbour] += weight;
            }
        }
        for(int i = 0; i < cornersAmount; i++) {
            for(int j = 0; j < N; j++) {
                neighbour = (i ^ (1 << j));
                if(cornersWeight[neighbour] + cornersWeight[i] > maxSum) {
                    maxSum = cornersWeight[neighbour] + cornersWeight[i];
                }
            }
        }
        System.out.println(maxSum);
    }
}
