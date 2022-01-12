package com.maks.algorithmics.linear.data.structure;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ArrayMedium {

  private static final int MAX_N = 100010;
  private static Buddy[] army = new Buddy[MAX_N];
  private static int soldiersNumber, lossReports;

  public static void run() {
    int L, R;
    int newLeft, newRight;
    String lReport, rReport;
    Scanner scaner = new Scanner(System.in);
    soldiersNumber = scaner.nextInt();
    while (soldiersNumber != 0) {
      lossReports = scaner.nextInt();
      initArmy();
      for (int i = 0; i < lossReports; i++) {
        L = scaner.nextInt();
        R = scaner.nextInt();
        newLeft = army[L].getLeft();
        newRight = army[R].getRight();
        army[army[R].getRight()].setLeft(newLeft);
        army[army[L].getLeft()].setRight(newRight);
        lReport = (newLeft < 1 ? "*" : String.valueOf(newLeft));
        rReport = (newRight > soldiersNumber ? "*" : String.valueOf(newRight));
        System.out.println(lReport + " " + rReport);
      }
      System.out.println("-");
      soldiersNumber = scaner.nextInt();
    }
  }

  private static void initArmy() {
    for (int i = 0; i <= soldiersNumber +1; i++)
      army[i] = new Buddy(i - 1, i + 1);
  }

  @Data
  @AllArgsConstructor
  static class Buddy {
    private int left;
    private int right;
  }

}
