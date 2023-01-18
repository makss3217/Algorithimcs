package com.maks.algorithmics.google.kickstarter.y_2022.roundA;

import com.maks.algorithmics.Utils.InputUtils;
import com.maks.algorithmics.google.kickstarter.GoogleKickstarterTask;
import lombok.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class C_PalindromeFreeStrings extends GoogleKickstarterTask<C_PalindromeFreeStrings.Input, C_PalindromeFreeStrings.Output> {

  private static final Set<String> PALINDROMS_5 = Set.of(
      "00000",
      "00100",
      "01010",
      "01110",
      "11111",
      "11011",
      "10101",
      "10001");

  private static final Set<String> PALINDROMS_6 = Set.of(
      "000000",
      "001100",
      "010010",
      "011110",
      "111111",
      "110011",
      "101101",
      "100001");


  @Override
  protected String getFormattedResult(Output output) {
    return output.isPossible() ? "POSSIBLE" : "IMPOSSIBLE";
  }

  @Override
  protected Input getInputFromReader(BufferedReader br) throws IOException {
    br.readLine();
    return new Input(br.readLine());
  }

  @Override
  protected Output testCase(Input input) {
    Set<String> oldResults = new HashSet<>();
    oldResults.add("");
    Set<String> newResults= new HashSet<>();
    for (int i = 0; i < input.getPattern().length(); i++) {
      newResults.clear();
      char c = input.getPattern().charAt(i);
      oldResults.forEach(suffix ->
          newResults.addAll(createNextSuffixes(suffix, c))
      );
      oldResults.clear();
      oldResults.addAll(newResults);
    }
    return new Output(!oldResults.isEmpty());
  }

  private static Set<String> createNextSuffixes(String suffix, char c) {
    Set<String> result = new HashSet<>();
    if(c == '?') {
      if(isNotPalindrome(suffix + "1")) {
        result.add(cutSuffix(suffix) + "1");
      }
      if(isNotPalindrome(suffix + "0")) {
        result.add(cutSuffix(suffix) + "0");
      }
    }
    else {
      if(isNotPalindrome(suffix + c)) {
        result.add(cutSuffix(suffix) + c);
      }
    }
    return result;
  }

  private static String cutSuffix(String suffix) {
    return suffix.length() < 5 ? suffix : suffix.substring(1);
  }

  private static boolean isNotPalindrome(String s) {
    if (s.length() == 5) {
      return !PALINDROMS_5.contains(s);
    }
    if (s.length() == 6) {
      return !PALINDROMS_6.contains(s) && !PALINDROMS_5.contains(s.substring(1));
    }
    return true;
  }

  @Value
  static class Input {
     String pattern;
  }

  @Value
  static class Output {
     boolean possible;
  }

}
