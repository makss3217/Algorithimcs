package com.maks.algorithmics.linear.data.structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedList {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void run() throws IOException {
        String input;
        input = br.readLine();
        while (input != null) {
            testCase(input);
            input = br.readLine();
        }
    }

    private static void testCase(String input) {
        List<Character> mainList = new ArrayList<>();
        List<Character> tmpList = new ArrayList<>();
        boolean startedFromBeginning = true;
        for (int i = 0; i < input.length(); i++) {
            char actualChar = input.charAt(i);
            if (actualChar == '[' || actualChar == ']') {
                if (startedFromBeginning) {
                    mainList.addAll(0, tmpList);
                } else {
                    mainList.addAll(tmpList);
                }
                tmpList.clear();
                startedFromBeginning = actualChar == '[';
            } else {
                tmpList.add(actualChar);
            }
        }

        if (startedFromBeginning) {
            mainList.addAll(0, tmpList);
        } else {
            mainList.addAll(tmpList);
        }

        System.out.println(mainList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }

}
