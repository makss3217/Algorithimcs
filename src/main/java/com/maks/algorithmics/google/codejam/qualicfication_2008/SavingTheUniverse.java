package com.maks.algorithmics.google.codejam.qualicfication_2008;

import com.maks.algorithmics.Utils.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import com.maks.algorithmics.Utils.Input;

public class SavingTheUniverse {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder strBuilder = new StringBuilder();

  public static void run() throws IOException {
    int t = Input.readIntFromLineOrNull(br);
    for(int i = 1; i <= t; i++) {
      strBuilder.append("Case #" + i + ": ");
      strBuilder.append(testCase());
      strBuilder.append("\n");
    }
    System.out.println(strBuilder);
  }

  private static String testCase() throws IOException {
    Set<String> engines = new HashSet<>();
    Set<String> usedEngines = new HashSet<>();
    int enginesNumber = Input.readIntFromLineOrNull(br);
    for(int i = 0; i < enginesNumber; i++) {
      engines.add(br.readLine());
    }
    int queryNumbers = Input.readIntFromLineOrNull(br);
    int switchRequired = 0;
    String query;
    for(int i = 0; i < queryNumbers; i++) {
      query = br.readLine();
      if(engines.contains(query)) {
        usedEngines.add(query);
      }
      if(usedEngines.size() == engines.size()) {
        switchRequired++;
        usedEngines.clear();
        usedEngines.add(query);
      }
    }
    return String.valueOf(switchRequired);
  }
}
