package com.maks.algorithmics.non.linear.data.structure;

import com.maks.algorithmics.Utils.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BalancedTreeSet {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder strBuilder = new StringBuilder();

  public static void run() throws IOException {
    int N = Input.readIntFromLineOrNull(br);
    for(int i = 0; i < N; i++) {
      if(i != 0) {
        strBuilder.append("\n");
      }
      testCase();
    }
    System.out.print(strBuilder);
  }

  private static void testCase() throws IOException {
    PriorityQueue<Integer> blues = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> greens = new PriorityQueue<>(Collections.reverseOrder());
    List<Integer> input = Input.readListOfIntegersFromLineOrNull(br);
    int availablePlaces = input.get(0);
    int greenNumbers = input.get(1);
    int blueNumbers = input.get(2);
    int greenFighter;
    int blueFighter;
    for(int i = 0; i < greenNumbers; i++) {
      greens.add(Input.readIntFromLineOrNull(br));
    }
    for(int i = 0; i < blueNumbers; i++) {
      blues.add(Input.readIntFromLineOrNull(br));
    }

    while(!greens.isEmpty() && !blues.isEmpty()) {
      List<Integer> greenWinners = new ArrayList<>();
      List<Integer> blueWinners = new ArrayList<>();
      for(int i = 0; i < availablePlaces; i++) {
        if(!greens.isEmpty() && !blues.isEmpty()) {
            greenFighter = greens.poll();
            blueFighter = blues.poll();
            if(greenFighter > blueFighter) {
              greenWinners.add(greenFighter - blueFighter);
            }
            if(blueFighter > greenFighter) {
              blueWinners.add(blueFighter - greenFighter);
            }
        } else {
          break;
        }
      }
      greens.addAll(greenWinners);
      blues.addAll(blueWinners);
    }
    addAnswer(blues, greens);
  }

  private static void addAnswer(PriorityQueue<Integer> blues, PriorityQueue<Integer> greens) {
    if(blues.isEmpty() && greens.isEmpty()) {
      strBuilder.append("green and blue died\n");
    }
    if(!blues.isEmpty()) {
      strBuilder.append("blue wins\n");
      blues.stream()
          .sorted(Comparator.reverseOrder())
          .forEach(BalancedTreeSet::addToStrBuilder);
    }
    if(!greens.isEmpty()) {
      strBuilder.append("green wins\n");
      greens.stream()
          .sorted(Comparator.reverseOrder())
          .forEach(BalancedTreeSet::addToStrBuilder);
      }
    strBuilder.append("\n");
  }


  private static void addToStrBuilder(Integer i) {
    strBuilder.append(i);
    strBuilder.append(('\n'));
  }

}
