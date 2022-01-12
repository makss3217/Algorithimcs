package com.maks.algorithmics.linear.data.structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountingInversion {

  private static final int MAX_SIZE = 1000010;
  private static final int MAX_INT = 1000000000;

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static StringBuilder strBuilder = new StringBuilder();
  private static int[] array = new int[MAX_SIZE];
  private static int allInversions;
  private static int size;

  public static void run() throws Exception {
    size = Integer.parseInt(br.readLine());
    while (size != 0) {
      testCase();
      size = Integer.parseInt(br.readLine());
    }
    System.out.print(strBuilder.toString());
  }

  private static void testCase() throws Exception {
    allInversions = 0;
    initArray();
    sort(0, size - 1);
    strBuilder.append(allInversions).append("\n");
  }

  private static void sort(int left, int right) {
    if (left < right) {
      int middle = left + (right - left) / 2;
      sort(left, middle);
      sort(middle + 1, right);
      merge(left, middle, right);
    }
  }

  private static void merge(int left, int middle, int right) {
    int n1 = middle - left + 1;
    int n2 = right - middle;

    int L[] = new int[n1+1];
    int R[] = new int[n2+1];

    for (int i = 0; i < n1; ++i)
      L[i] = array[left + i];
    for (int j = 0; j < n2; ++j)
      R[j] = array[middle + 1 + j];
    
    L[n1] = MAX_INT;
    R[n2] = MAX_INT;
    int i = 0;
    int j = 0;

    for (int k = left; k <= right; k++) {
      if (L[i] <= R[j]) {
        array[k] = L[i];
        i++;
      } else {
        array[k] = R[j];
        j++;
        allInversions = allInversions + n1 - i;
      }
    }
  }

  private static void initArray() throws Exception {
    for (int i = 0; i < size; i++) {
      array[i] = Integer.parseInt(br.readLine());
    }
  }
}
