package com.maks.algorithmics.google.kickstarter.y_2022.roundA;

import com.maks.algorithmics.Utils.InputUtils;
import com.maks.algorithmics.google.kickstarter.GoogleKickstarterTask;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
public class D_InterestingIntegers extends GoogleKickstarterTask<D_InterestingIntegers.Input, D_InterestingIntegers.Output> {

  static final HashMap<InterestingIntegersKey, Long> interestingNumbersMap = new HashMap<>();

  @Override
  protected Input getInputFromReader(BufferedReader br) throws IOException {
    List<Long> numbers = InputUtils.readListOfLongsFromLineOrNull(br);
    return new Input(numbers.get(0), numbers.get(1));
  }

  @Override
 protected String getFormattedResult(Output output) {
    return String.valueOf(output.getResult());
  }

  @Override
  protected Output testCase(Input input) {
   return new Output(howManyInteresting(input.getB()) - howManyInteresting(input.getA() - 1));
  }

  private static long f1(int L, long P, long S) {
    InterestingIntegersKey key = new InterestingIntegersKey(L, P, S);
    if (interestingNumbersMap.containsKey(key)) {
      return interestingNumbersMap.get(key);
    } else {
      long value = 0;
      if(L == 0) {
        value = ((S != 0) && (P % S == 0)) ? 1 : 0;
      } else {
        for(int i= 0; i<= 9; i++) {
          value += f1(L -1, P * i, S + i);
        }
      }
      interestingNumbersMap.put(key, value);
      return value;
    }
   }

  private long howManyInteresting(long number) {
    if (number == 0) {
      return 0;
    }
    long count = 0;
    for(int i = 1; i < countDigits(number); i++) {
      count += CountInterestingIntegersWithNumberOfDigits(i);
    }
    count += CountInterestingIntegersWithPrefixOfN(number, 1, 0, 0, true);
    return count;
  }

  private long CountInterestingIntegersWithNumberOfDigits(int L) {
    long count = 0;
    for(int i = 1; i <= 9; i++) {
      count += f1(L - 1, i, i);
    }
    return count;
  }

  private long CountInterestingIntegersWithPrefixOfN(long N, long P, long S, int digitIndex, boolean isFirstDigit) {
    if (digitIndex == countDigits(N)) {
      return (S > 0 &&  (P % S == 0)) ? 1: 0;
    }
    int digit_start = isFirstDigit ? 1 : 0;
    long ithDigit = getIthDigit(N, digitIndex);

    long count = 0;
    for (int digit = digit_start; digit < ithDigit; digit++) {
      count += f1((countDigits(N) - digitIndex) - 1, P * digit, S + digit);
    }

    count += CountInterestingIntegersWithPrefixOfN(
        N,
        P * ithDigit,
        S + ithDigit,
        digitIndex + 1,
        false);

    return count;
  }

  private long getIthDigit(long n, int digitIndex) {
    return String.valueOf(n).charAt(digitIndex) - '0';
  }

  private int countDigits(long number) {
    return (int) (Math.log10(number) + 1);
  }

  @Value
  private static class InterestingIntegersKey {
    int L;
    long P;
    long S;
  }

  @Value
  static class Input {
    long A;
    long B;
  }

  @Value
  static class Output {
    long result;
  }

}
