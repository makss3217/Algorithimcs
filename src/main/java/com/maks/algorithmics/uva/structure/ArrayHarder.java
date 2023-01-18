package com.maks.algorithmics.uva.structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayHarder {

  private static final int MAX_N = 105;
  private static final String UNKNOWN_STUDENT = "?";
  private static List<String> students = new ArrayList<>();

  public static void run() throws  IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder strBuilder;
    int n = Integer.parseInt(br.readLine());
    students = Arrays.asList(br.readLine().split(" "));
    int nearestLeft = (-1) * MAX_N;
    int nearestRight = 0;
    int diffToLeft;
    int diffToRight;
    for (int i = 0; i < students.size(); i++) {
      if (!students.get(i).equals(UNKNOWN_STUDENT)) {
        nearestLeft = i;
      } else {
        if (nearestRight <= i) {
          nearestRight = findNearestRight(n, i);
        }
        diffToLeft = i - nearestLeft;
        diffToRight = nearestRight - i;
        strBuilder = new StringBuilder();
        if (diffToRight == diffToLeft) {
          strBuilder
              .append("middle of ")
              .append(students.get(nearestLeft))
              .append(" and ")
              .append(students.get(nearestRight));
        }
        if (diffToLeft < diffToRight) {
          for (int t = 0; t < diffToLeft; t++) {
            strBuilder.append("right of ");
          }
          strBuilder.append(students.get(nearestLeft));
        }
        if (diffToLeft > diffToRight) {
          for (int t = 0; t < diffToRight; t++) {
            strBuilder.append("left of ");
          }
          strBuilder.append(students.get(nearestRight));
        }
        students.set(i, strBuilder.toString());
      }
    }
    int q = Integer.parseInt(br.readLine());
    strBuilder = new StringBuilder();
    for (int i = 0; i < q; i++) {
      strBuilder.append(students.get(Integer.parseInt(br.readLine())- 1));
      strBuilder.append("\n");
    }
    System.out.print(strBuilder.toString());
  }

  private static int findNearestRight(int n, int i) {
    int nearestRight;
    int j = i;
    while (j < n && students.get(j).equals(UNKNOWN_STUDENT)) {
      j++;
    }
    if (j == n) {
      nearestRight = 2 * MAX_N;
    } else {
      nearestRight = j;
    }
    return nearestRight;
  }

}