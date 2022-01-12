package com.maks.algorithmics.start;

import java.util.Scanner;

public class RepetitionOnly {
  
  public static void run() {
    Scanner scaner = new Scanner(System.in);
    int T = scaner.nextInt();
    int x ,y, result;
    for(int i = 0; i < T;  i++) {
      x = scaner.nextInt();
      y = scaner.nextInt();
      result = (x/3) * (y/3);
      System.out.println(result);
    }
    scaner.close();
  }
}
