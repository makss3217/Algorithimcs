package com.maks.algorithmics.linear.data.structure;

import java.util.Scanner;

public class TwoDimArray {

  private static final int MAX_TEAMS = 110;
  private static final int MAX_PROBLEM = 14;

  private static final String YES = "Yes";

  private static boolean[][] accepted = new boolean[MAX_PROBLEM][MAX_TEAMS];
  private static LastBlood[] lastBloods = new LastBlood[MAX_PROBLEM];
  
  public static void run() {    
    Scanner scaner = new Scanner(System.in);
    StringBuilder strBuilder = new StringBuilder();
    int problems = scaner.nextInt();
    int teams = scaner.nextInt();
    int submisions = scaner.nextInt();
    
    int time;
    int team;
    int problemId;
    String verdict;
    
    for(int i = 0; i < submisions; i++) {
      time = scaner.nextInt();
      team = scaner.nextInt();
      problemId = charToInt(scaner.next().charAt(0));
      verdict = scaner.next(); 
      if(verdict.equals(YES) && !accepted[problemId][team]) {
          accepted[problemId][team] = true;  
          lastBloods[problemId] = new LastBlood(time, team);
      }
    }
    
    for(int i = 0; i < problems; i++) {
      LastBlood lastBlood = lastBloods[i];
      strBuilder
      .append(intToChar(i))
      .append(" ")
      .append(lastBlood == null ? "-" : lastBlood.getTime())
      .append(" ")
      .append(lastBlood == null ? "-" : lastBlood.getTeam())
      .append("\n");
    }
    System.out.print(strBuilder.toString());
    scaner.close();
  }
  
  private static int charToInt(char c) {
    return c - 'A';
  }
  
  private static char intToChar(int i) {
    int x = i + 'A';
    return (char)x;
  }
  
  static class LastBlood {
    int time;
    int team;  
    public LastBlood(int time, int team) {
      this.team = team;
      this.time = time;
    }
    int getTime() {
      return time;
    }
    int getTeam() {
      return team;
    }
  }

}
