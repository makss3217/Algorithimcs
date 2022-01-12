package com.maks.algorithmics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder strBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Integer N = readIntFromLineOrNull(br);
        int result;
        for(int i = 0; i < N; i++) {
            result = testCase();
            strBuilder.append(String.format("Case %d: %d\n", i, result));
        }
        System.out.print(strBuilder);
    }

    private static int testCase() throws IOException {
        HashSet<String> resultSet = new HashSet<>();
        List<Integer> inputSize = readListOfIntegersFromLineOrNull(br);
        int N = inputSize.get(0);
        int M = inputSize.get(1);
        String[] firstList = new String[1501];
        String[] secondList = new String[1501];
        for(int i = 0; i < N; i++) {
            firstList[i] = br.readLine();
        }
        for(int i = 0; i < M; i++) {
            secondList[i] = br.readLine();
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M ; j++) {
                resultSet.add(firstList[i].concat(secondList[j]));
            }
        }
        return resultSet.size();
    }

    public static List<Integer> readListOfIntegersFromLineOrNull(BufferedReader br) throws IOException {
        String line = br.readLine();
        if(line != null) {
            return Arrays.asList(line.split(" ")).stream()
                .map(Integer::parseInt)
                .collect(toList());
        } else {
            return null;
        }
    }

    public static Integer readIntFromLineOrNull(BufferedReader br) throws IOException {
        String line = br.readLine();
        if(line != null) {
            return Integer.parseInt(line);
        } else {
            return null;
        }
    }

}
