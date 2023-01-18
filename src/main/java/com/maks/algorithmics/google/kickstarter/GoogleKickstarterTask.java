package com.maks.algorithmics.google.kickstarter;

import com.maks.algorithmics.Utils.InputUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public interface GoogleKickstarterTask<SingleInput, SingleOutput> {

  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  default String run() throws IOException {
    List<String> testCasesResults = new ArrayList<>();
    int t = InputUtils.readIntFromLineOrNull(br);
    for (int i = 1; i <= t; i++) {
      testCasesResults.add("Case #" + i + ": " + getFormattedResult(testCase(getInputFromReader(br))));
    }
    return String.join("\n", testCasesResults);
  }

  SingleOutput testCase(SingleInput readSingleInput);

  String getFormattedResult(SingleOutput output);

  SingleInput getInputFromReader(BufferedReader br);
}
