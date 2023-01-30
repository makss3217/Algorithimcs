package com.maks.algorithmics.google.kickstarter.y_2022.roundA;

import com.maks.algorithmics.google.kickstarter.GoogleKickstarterTask;
import lombok.Value;

import java.io.BufferedReader;
import java.io.IOException;

class A_SpeedTyping extends GoogleKickstarterTask<A_SpeedTyping.Input, A_SpeedTyping.Output> {

  @Override
  protected Output testCase(Input singleInput) {
    char[] original = singleInput.getOriginal().toCharArray();
    char[] input = singleInput.getInput().toCharArray();
    int mistakesAvailable = input.length- original.length;
    int inputPointer = 0;
    for(int i = 0; i < original.length; i++) {
      while (original[i] != input[inputPointer]) {
        if (mistakesAvailable == 0)
          return Output.IMPOSSIBLE;
        mistakesAvailable--;
        inputPointer++;
      }
      inputPointer++;
    }
    return new Output(input.length - original.length);
  }

  @Override protected String getFormattedResult(Output output) {
    return output.equals(Output.IMPOSSIBLE) ? "IMPOSSIBLE" : String.valueOf(output.getNeededLetters());
  }

  @Override protected Input getInputFromReader(BufferedReader br) throws IOException {
    return new Input(
        br.readLine(),
        br.readLine());
  }

  @Value
  static class Input {
    String original;
    String input;
  }

  @Value
  static class Output {
    long neededLetters;

    static final Output IMPOSSIBLE = new Output(-1L);
  }

}
