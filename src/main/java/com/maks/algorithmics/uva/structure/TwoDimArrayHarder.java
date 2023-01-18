package com.maks.algorithmics.uva.structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoDimArrayHarder {

  private static final int MAX_SIZE = 10;

  private static boolean[][] grid = new boolean[MAX_SIZE][MAX_SIZE];
  private static boolean[][] newGrid = new boolean[MAX_SIZE][MAX_SIZE];
  private static boolean[] isTransformed = new boolean[8];
  private static int size;
  private static int currentCase = 0;
  private static String str;
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void run() throws IOException {
    while (isMoreInput()) {
      currentCase++;
      fillGrids();
      setTransformedAsTrue();
      checkTransformation();
      printOutput();
    }
  }

  private static void checkTransformation() {
    int lastIndex = size - 1;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (grid[i][j] != newGrid[i][j]) {
          isTransformed[0] = false;
        }
        if (grid[i][j] != newGrid[j][lastIndex - i]) {
          isTransformed[1] = false;
        }
        if (grid[i][j] != newGrid[lastIndex - i][lastIndex - j]) {
          isTransformed[2] = false;
        }
        if (grid[i][j] != newGrid[lastIndex - j][i]) {
          isTransformed[3] = false;
        }
        if (grid[i][j] != newGrid[lastIndex - i][j]) {
          isTransformed[4] = false;
        }
        if (grid[i][j] != newGrid[j][i]) {
          isTransformed[5] = false;
        }
        if (grid[i][j] != newGrid[lastIndex - i][lastIndex - j]) {
          isTransformed[6] = false;
        }
        if (grid[i][j] != newGrid[lastIndex - j][lastIndex - i]) {
          isTransformed[7] = false;
        }
      }
    }

  }

  private static void printOutput() {
    if (isTransformed[0]) {
      System.out.println("Pattern " + currentCase + " was preserved.");
      return;
    }
    if (isTransformed[1]) {
      System.out.println("Pattern " + currentCase + " was rotated 90 degrees.");
      return;
    }
    if (isTransformed[2]) {
      System.out.println("Pattern " + currentCase + " was rotated 180 degrees.");
      return;
    }
    if (isTransformed[3]) {
      System.out.println("Pattern " + currentCase + " was rotated 270 degrees.");
      return;
    }
    if (isTransformed[4]) {
      System.out.println("Pattern " + currentCase + " was reflected vertically.");
      return;
    }
    if (isTransformed[5]) {
      System.out.println("Pattern " + currentCase + " was reflected vertically and rotated 90 degrees.");
      return;
    }
    if (isTransformed[6]) {
      System.out.println("Pattern " + currentCase + " was reflected vertically and rotated 180 degrees.");
      return;
    }
    if (isTransformed[7]) {
      System.out.println("Pattern " + currentCase + " was reflected vertically and rotated 270 degrees.");
      return;
    }
    System.out.println("Pattern " + currentCase + " was improperly transformed.");
    
  }

  private static void setTransformedAsTrue() {
    for (int i = 0; i < 8; i++) {
      isTransformed[i] = true;
    }
  }

  private static boolean isMoreInput() throws IOException {
    return (str = br.readLine()) != null && str.length() != 0;
  }

  private static void fillGrids() throws IOException {
    size = Integer.parseInt(str);
    for (int i = 0; i < size; i++) {
      str = br.readLine();
      for (int j = 0; j < size; j++) {
        grid[i][j] = (str.charAt(j) == 'X');
      }
      for (int j = 0; j < size; j++) {
        newGrid[i][j] = (str.charAt(size + 1 + j) == 'X');
      }
    }
  }

}
