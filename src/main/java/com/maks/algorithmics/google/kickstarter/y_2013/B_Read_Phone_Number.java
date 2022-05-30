package com.maks.algorithmics.google.kickstarter.y_2013;

import com.maks.algorithmics.Utils.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class B_Read_Phone_Number {

  private static final String[] NUMBER_LENGTHS = {
      "",
      "",
      "double",
      "triple",
      "quadruple",
      "quintuple",
      "sextuple",
      "septuple",
      "octuple",
      "nonuple",
      "decuple" };

  private static final String[] NUMBERS = {
      "zero",
      "one",
      "two",
      "three",
      "four",
      "five",
      "six",
      "seven",
      "eight",
      "nine" };

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder strBuilder = new StringBuilder();

  public static void run() throws IOException {
    int t = Input.readIntFromLineOrNull(br);
    for (int i = 1; i <= t; i++) {
      strBuilder.append("Case #" + i + ": ");
      strBuilder.append(testCase());
      strBuilder.append("\n");
    }
    System.out.println(strBuilder);
  }

  private static String testCase() throws IOException {
    StringBuilder localBuilder = new StringBuilder();
    List<String> input = Input.readListOfStringFromLineOrNull(br);
    List<Integer> phoneNumber = createNumberList(input.get(0));
    List<Integer> format = createFormat(input.get(1));
    int numberPointer = 0;
    
    for(Integer f : format) {
      int previous = phoneNumber.get(numberPointer);
      int actual = phoneNumber.get(numberPointer);
      int sameNumberLength = 1;
      for(int i = numberPointer + 1; i < numberPointer + f; i++) {
        actual = phoneNumber.get(i);
        if(actual == previous) {
          sameNumberLength++;
        } else {
          localBuilder.append(createOutput(previous, sameNumberLength));
          previous = actual;
          sameNumberLength = 1;
        }
      }
      localBuilder.append(createOutput(previous, sameNumberLength));
      numberPointer += f;
    }
    return localBuilder.toString();
  }

  private static String createOutput(int number, int sameNumberLength) {
    if(sameNumberLength == 1) {
      return String.format(" %s", NUMBERS[number]);
    } else if(sameNumberLength < 10) {
      return String.format((" %s %s"), NUMBER_LENGTHS[sameNumberLength], NUMBERS[number]);
    } else {
      StringBuilder builder = new StringBuilder();
      for(int i = 0; i < sameNumberLength; i++) {
        builder.append(String.format(" %s", NUMBERS[number]));
      }
      return builder.toString();
    }

  }

  private static List<Integer> createFormat(String format) {
    return Arrays.stream(format.split("-"))
        .map(Integer::parseInt)
        .collect(toList());
  }

  private static List<Integer> createNumberList(String s) {
    List<Integer> result = new ArrayList<>();
    for (char c : s.toCharArray()) {
      result.add(c - '0');
    }
    return result;
  }

}
