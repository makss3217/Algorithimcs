package com.maks.algorithmics.google.kickstarter.y_2022.roundA;

import com.maks.algorithmics.google.kickstarter.GoogleKickstarterTask;
import com.maks.algorithmics.google.kickstarter.KickstarterTestBase;
import com.maks.algorithmics.google.kickstarter.TestUtils;

import java.io.BufferedReader;
import java.io.IOException;

import static com.maks.algorithmics.google.kickstarter.y_2022.roundA.D_InterestingIntegers.*;

class D_InterestingIntegersTest extends KickstarterTestBase<Input, Output> {

  @Override
  protected GoogleKickstarterTask<Input, Output> getInstance() {
    return new D_InterestingIntegers();
  }

  @Override
  protected String getInputDataPath() {
    return TestUtils.TEST_DATA_PATH + "/2022/round1/D/test_set_2/ts2_input.txt";
  }

  @Override
  protected String getOutputDataPath() {
    return TestUtils.TEST_DATA_PATH +"/2022/round1/D/test_set_2/ts2_output.txt";
  }

  protected Output getSingleOutput(BufferedReader outputReader) throws IOException {
    String line = outputReader.readLine();
    return new Output(Long.parseLong(line.substring(line.indexOf(':') + 2)));
  }

}