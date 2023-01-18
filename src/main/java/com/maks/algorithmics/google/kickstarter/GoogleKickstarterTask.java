package com.maks.algorithmics.google.kickstarter;

import com.maks.algorithmics.Utils.InputUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class GoogleKickstarterTask<SingleInput, SingleOutput> {

  BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

  public String run() throws IOException {
    return run(reader);
  }

  public String run(BufferedReader reader) throws IOException {
    List<String> testCasesResults = new ArrayList<>();
    int t = InputUtils.readIntFromLineOrNull(reader);
    for (int i = 1; i <= t; i++) {
      testCasesResults.add("Case #" + i + ": " + getFormattedResult(testCase(getInputFromReader(reader))));
    }
    return String.join("\n", testCasesResults);
  }

  protected abstract SingleOutput testCase(SingleInput readSingleInput);

  protected abstract String getFormattedResult(SingleOutput output);

  protected abstract SingleInput getInputFromReader(BufferedReader br) throws IOException;
}
