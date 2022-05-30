package com.maks.algorithmics.google.kickstarter.y_2013;

import com.maks.algorithmics.Utils.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class C_Rational_Number_Tree {

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
    List<Integer> input = Input.readListOfIntegersFromLineOrNull(br);
    int caseCode = input.get(0);
    return caseCode == 1 ? getFraction(input.get(1)) : getFractionNumber(input.get(1), input.get(2));
  }

  private static String getFractionNumber(long p, long q) {
    long started_p = 1;
    long started_q = 1;
    long number = 1;

    while(started_p * q != started_q * p) {
      if(started_p * q > started_q * p) {

      }
    }

    return null;
  }

  private static String getFraction(Integer n) {
    return null;
  }

}
