package com.maks.algorithmics.google.kickstarter.y_2022;

import com.maks.algorithmics.Utils.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class A {

  private static final String IMPOSSIBLE = "IMPOSSIBLE";
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
    String original = br.readLine();
    String input = br.readLine();
    int mistakesAvailable = input.length() - original.length();
    int inputPointer = 0;
    for(int i = 0; i < original.length(); i++) {
      while (original.charAt(i) != input.charAt(inputPointer)) {
        if (mistakesAvailable == 0)
          return IMPOSSIBLE;
        mistakesAvailable--;
        inputPointer++;
      }
      inputPointer++;
    }
    return String.valueOf(input.length() - original.length());
  }

}
