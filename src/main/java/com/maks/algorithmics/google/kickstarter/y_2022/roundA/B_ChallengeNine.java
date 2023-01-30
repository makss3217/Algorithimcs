package com.maks.algorithmics.google.kickstarter.y_2022.roundA;

import com.maks.algorithmics.google.kickstarter.GoogleKickstarterTask;
import lombok.Value;

import java.io.BufferedReader;
import java.io.IOException;

public class B_ChallengeNine extends GoogleKickstarterTask<B_ChallengeNine.Input, B_ChallengeNine.Output> {

  @Override
  protected Output testCase(Input input) {
    String numberAsStr = input.getNumber();
    int sum = 0;
    int numberToAdd;
    int placeToAdd = 0;
    for (char c : numberAsStr.toCharArray()) {
      sum += (c - '0');
    }
    numberToAdd = sum % 9;
    if(numberToAdd == 0) {
      return new Output(numberAsStr.charAt(0) + '0' + numberAsStr.stripLeading());
    } else {
      for (char c : numberAsStr.toCharArray()) {
        if(numberToAdd < (c - '0')) {
          return new Output(numberAsStr.substring(0, placeToAdd) + numberToAdd + numberAsStr.substring(placeToAdd));
        }
        placeToAdd++;
      }
    }
    return new Output(numberAsStr + numberToAdd);
  }

  @Override
  protected String getFormattedResult(Output output) {
    return String.valueOf(output.newNumber);
  }

  @Override
  protected Input getInputFromReader(BufferedReader br) throws IOException {
    return new Input(br.readLine());
  }

  @Value
  static class Input {
    String number;
  }

  @Value
  static class Output {
    String newNumber;
  }

}
