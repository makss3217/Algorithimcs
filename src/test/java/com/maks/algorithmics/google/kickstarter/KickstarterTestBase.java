package com.maks.algorithmics.google.kickstarter;

import com.maks.algorithmics.Utils.InputUtils;
import lombok.Value;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public abstract class KickstarterTestBase<Input, Output> {

  GoogleKickstarterTask<Input, Output> kickStarterTask = getInstance();

  protected abstract GoogleKickstarterTask<Input,Output> getInstance();

  @ParameterizedTest
  @MethodSource("provideTestCases")
  void worksProperly(TestData testData) {
    assertThat(kickStarterTask.testCase(testData.getInput())).isEqualTo(testData.getOutput());
  }

  @Test
  void workProperly() throws IOException {
    BufferedReader inputReader = new BufferedReader(new FileReader(getInputDataPath()));
    BufferedReader outputReader = new BufferedReader(new FileReader(getOutputDataPath()));
    assertThat(kickStarterTask.run(inputReader)).isEqualTo(outputReader.lines().collect(Collectors.joining("\n")));
  }

  private Stream<Arguments> provideTestCases() throws IOException {
    List<TestData> result = new ArrayList<>();
    BufferedReader inputReader = new BufferedReader(new FileReader(getInputDataPath()));
    BufferedReader outputReader = new BufferedReader(new FileReader(getOutputDataPath()));
    int size = InputUtils.readIntFromLineOrNull(inputReader);

    for (int i = 0; i < size; i++) {
      result.add(new TestData(kickStarterTask.getInputFromReader(inputReader), getSingleOutput(outputReader)));
    }
    return result.stream().map(Arguments::of);
  }

  protected abstract String getInputDataPath();

  protected abstract String getOutputDataPath();

  protected abstract Output getSingleOutput(BufferedReader outputReader) throws IOException;

  @Value
  private class TestData {
    Input input;
    Output output;
  }
}