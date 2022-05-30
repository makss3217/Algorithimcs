package com.maks.algorithmics.google.kickstarter.y_2022;

import com.maks.algorithmics.Utils.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class D {

  private static final int LIMIT = 100000;

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder strBuilder = new StringBuilder();
  private static int howManyInteresting[] = new int[LIMIT + 1];


  public static void run() throws IOException {
    generateTable();
    int t = Input.readIntFromLineOrNull(br);
    for (int i = 1; i <= t; i++) {
      strBuilder.append("Case #" + i + ": ");
      strBuilder.append(testCase());
      strBuilder.append("\n");
    }
    System.out.println(strBuilder);
  }

  private static void generateTable() {
    int interestingFromBegin = 0;
    for(int i = 1; i < LIMIT; i++) {
      if(isInteresting(i)) {
        interestingFromBegin++;
      }
      howManyInteresting[i] = interestingFromBegin;
    }
  }

  private static boolean isInteresting(int i) {
    long product = 1;
    long sum = 0;
    String temp = String.valueOf(i);
    for(char c : temp.toCharArray()){
      int digit = c - '0';
      product *= digit;
      sum += digit;
    }
    return (product % sum) == 0;
  }

  private static Object testCase() throws IOException {
    List<Integer> numbers = Input.readListOfIntegersFromLineOrNull(br);
    return howManyInteresting[numbers.get(1)] - howManyInteresting[numbers.get(0) - 1];
  }
}
