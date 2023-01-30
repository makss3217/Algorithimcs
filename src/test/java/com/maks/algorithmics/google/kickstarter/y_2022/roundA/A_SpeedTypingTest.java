package com.maks.algorithmics.google.kickstarter.y_2022.roundA;

import com.maks.algorithmics.google.kickstarter.GoogleKickstarterTask;
import com.maks.algorithmics.google.kickstarter.KickstarterTestBase;
import com.maks.algorithmics.google.kickstarter.TestUtils;

import java.io.BufferedReader;
import java.io.IOException;

import static com.maks.algorithmics.google.kickstarter.y_2022.roundA.A_SpeedTyping.*;


class A_SpeedTypingTest extends KickstarterTestBase<Input, Output> {

  @Override
  protected GoogleKickstarterTask<Input, Output> getInstance() {
    return new A_SpeedTyping();
  }

  @Override
  protected String getInputDataPath() {
    return TestUtils.TEST_DATA_PATH + "/2022/round1/A/test_set_2/ts2_input.txt";
  }

  @Override
  protected String getOutputDataPath() {
    return TestUtils.TEST_DATA_PATH +"/2022/round1/A/test_set_2/ts2_output.txt";
  }


  @Override
  protected Output getSingleOutput(BufferedReader outputReader) throws IOException {
    String line = outputReader.readLine();
    return line.contains("IMPOSSIBLE") ?  Output.IMPOSSIBLE : new Output(Long.parseLong(line.substring(line.indexOf(':') + 2)));
  }
}