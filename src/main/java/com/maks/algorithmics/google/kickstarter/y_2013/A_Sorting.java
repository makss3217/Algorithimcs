package com.maks.algorithmics.google.kickstarter.y_2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import com.maks.algorithmics.Utils.InputUtils;

public class A_Sorting {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder strBuilder = new StringBuilder();

  public static void run() throws IOException {
    int t = InputUtils.readIntFromLineOrNull(br);
    for(int i = 1; i <= t; i++) {
      strBuilder.append("Case #" + i + ": ");
      strBuilder.append(testCase());
      strBuilder.append("\n");
    }
    System.out.println(strBuilder);
  }

  static String testCase() throws IOException {
    PriorityQueue<Integer> evenBooks = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> oddBooks = new PriorityQueue<>();
    List<Integer> resultBooks = new ArrayList<>();
    List<Boolean> labels = new ArrayList<>();
    boolean isOdd;
    int n = InputUtils.readIntFromLineOrNull(br);
    List<Integer> input = InputUtils.readListOfIntegersFromLineOrNull(br);

    for (int book : input) {
      isOdd = ((book & 1) == 1);
      labels.add(isOdd);
      if(isOdd) {
        oddBooks.add(book);
      } else {
        evenBooks.add(book);
      }
    }

    for (boolean label : labels) {
      if (label) {
        resultBooks.add(oddBooks.poll());
      } else {
        resultBooks.add(evenBooks.poll());
      }
    }

    return resultBooks.stream()
        .map(Object::toString)
        .collect(Collectors.joining(" "));
  }

}
