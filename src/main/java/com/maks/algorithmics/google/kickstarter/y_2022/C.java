package com.maks.algorithmics.google.kickstarter.y_2022;

import com.maks.algorithmics.Utils.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C {

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
    String pattern = br.readLine();
    List<Integer> mapOfQuotes = createMapFromPattern(pattern);
    for(int i = 0; i < Math.pow(2, mapOfQuotes.size()); i++) {
      String matcher = createCase(pattern, mapOfQuotes, i);
      if(isPallindrome(matcher)) {
        return "IMPOSSIBLE";
      }
    }
    return "POSSIBLE";
  }

  private static boolean isPallindrome(String matcher) {
    for(int i  = 5; i <= matcher.length(); i++) {
      for(int j = 0; j < matcher.length() - i; j++) {
        String singleCheck = matcher.substring(j, j+ i);
        if(singleCheck.equals(new StringBuilder(singleCheck).reverse().toString())) {
          return true;
        }
      }
    }
    return false;
  }

  private static String createCase(String pattern, List<Integer> mapOfQuotes, int i) {
    StringBuilder builder = new StringBuilder(pattern);
    int combination = i;
    for(int placeInPattern : mapOfQuotes) {
      builder.setCharAt(placeInPattern, (combination & 1) == 1 ? '1' : '0');
      combination = combination >> 1;
    }
    return builder.toString();
  }

  private static List<Integer> createMapFromPattern(String pattern) {
    List<Integer> result = new ArrayList<>();
    for(int i = 0; i < pattern.length(); i++) {
      if(pattern.charAt(i) == '?') {
        result.add(i);
      }
    }
    return result;
  }

}
