package com.maks.algorithmics.google.kickstarter.y_2022.roundA;

import com.maks.algorithmics.Utils.InputUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_ChallengeNine {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder strBuilder = new StringBuilder();

  public static void run() throws IOException {
    int t = InputUtils.readIntFromLineOrNull(br);
    for (int i = 1; i <= t; i++) {
      strBuilder.append("Case #" + i + ": ");
      strBuilder.append(testCase());
      strBuilder.append("\n");
    }
    System.out.println(strBuilder);
  }

  private static String testCase() throws IOException {
    String input = br.readLine();
    int sum = 0;
    int numberToAdd;
    int placeToAdd = 0;
    for (char c : input.toCharArray()) {
      sum += (c - '0');
    }
    numberToAdd = sum % 9;
    if(numberToAdd == 0) {
      return input.charAt(0) + '0' + input.stripLeading();
    } else {
      for (char c : input.toCharArray()) {
        if(numberToAdd < (c - '0')) {
          return
              input.substring(0, placeToAdd) +
              numberToAdd +
              input.substring(placeToAdd, input.length());
        }
        placeToAdd++;
      }
    }
    return input + numberToAdd;
  }

}
