package com.maks.algorithmics.non.linear.data.structure;

import com.maks.algorithmics.InputUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DirectAddressingTable {

  private static final char FIRST_LETTER = 'A';

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder strBuilder = new StringBuilder();

  public static void run() throws IOException {
    Integer N = InputUtils.readIntFromLineOrNull(br);
    for(int i = 0; i < N; i++) {
      testCase();
    }
    System.out.print(strBuilder);
  }

  private static void testCase() throws IOException {
    int[] map = new int[50];
    String line = br.readLine();
    for (char c : line.toCharArray()) {
      map[c - FIRST_LETTER]++;
    }
    List<Integer> list = new ArrayList<>();
    list.add(map['M' - FIRST_LETTER]);
    list.add(map['A' - FIRST_LETTER] / 3);
    list.add(map['R' - FIRST_LETTER] / 2);
    list.add(map['G' - FIRST_LETTER]);
    list.add(map['I' - FIRST_LETTER]);
    list.add(map['T' - FIRST_LETTER]);

    strBuilder.append(
        list.stream()
            .min(Comparator.comparing(Integer::valueOf))
            .orElse(0));
    strBuilder.append("\n");
  }

}
