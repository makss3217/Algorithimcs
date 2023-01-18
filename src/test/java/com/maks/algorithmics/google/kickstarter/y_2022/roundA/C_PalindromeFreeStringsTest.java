package com.maks.algorithmics.google.kickstarter.y_2022.roundA;

import com.maks.algorithmics.Utils.InputUtils;
import lombok.Value;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.maks.algorithmics.google.kickstarter.y_2022.roundA.C_PalindromeFreeStrings.*;
import static org.assertj.core.api.Assertions.assertThat;

class C_PalindromeFreeStringsTest {
  private static final String TEST_INPUT_DATA_PATH = "C:/Users/mbienkow/algorithimcs_source/Algorithimcs/src/test/resources/test_data/C_2022/test_set_2/ts2_input.txt";
  private static final String TEST_OUTPUT_DATA_PATH = "C:/Users/mbienkow/algorithimcs_source/Algorithimcs/src/test/resources/test_data/C_2022/test_set_2/ts2_output.txt";

  @ParameterizedTest
  @ArgumentsSource(TestDataProvider.class)
  void worksProperly(TestData testData) {
    assertThat(testCase(testData.getInput())).isEqualTo(testData.getOutput());
  }

  @Test
  void workProperly() throws IOException {
    BufferedReader inputReader = new BufferedReader(new FileReader(TEST_INPUT_DATA_PATH));
    BufferedReader outputReader = new BufferedReader(new FileReader(TEST_OUTPUT_DATA_PATH));
    assertThat(C_PalindromeFreeStrings.run(inputReader)).isEqualTo(outputReader.lines().collect(Collectors.joining("\n")));
  }

  private static class TestDataProvider implements ArgumentsProvider {
    @Override
    public Stream<Arguments> provideArguments(ExtensionContext extensionContext) throws IOException {
      List<TestData> result = new ArrayList<>();
      BufferedReader inputReader = new BufferedReader(new FileReader(TEST_INPUT_DATA_PATH));
      BufferedReader outputReader = new BufferedReader(new FileReader(TEST_OUTPUT_DATA_PATH));
      int size = InputUtils.readIntFromLineOrNull(inputReader);

      for (int i = 0; i < size; i++) {
        result.add(new TestData(getInputFromReader(inputReader), getSingleOutput(outputReader)));
      }
      return result.stream().map(Arguments::of);
    }
  }

  private static Output getSingleOutput(BufferedReader outputReader) throws IOException {
    String line = outputReader.readLine();
    return new Output(!line.contains("IMPOSSIBLE"));
  }

  @Value
  private static class TestData {
    Input input;
    Output output;
  }
}