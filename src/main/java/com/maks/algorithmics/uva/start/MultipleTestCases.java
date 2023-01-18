package com.maks.algorithmics.uva.start;

import java.util.HashMap;
import java.util.Scanner;

public class MultipleTestCases {

  public static void run() {
    HashMap<String, String> lanMap = new HashMap<>();
    lanMap.put("HELLO", "ENGLISH");
    lanMap.put("HOLA", "SPANISH");
    lanMap.put("HALLO", "GERMAN");
    lanMap.put("BONJOUR", "FRENCH");
    lanMap.put("CIAO", "ITALIAN");
    lanMap.put("ZDRAVSTVUJTE", "RUSSIAN");
    int i = 1;
    String lan;
    Scanner scaner = new Scanner(System.in);
    lan = scaner.next();
    while(!lan.equals("#")) {
      System.out.println("Case " + i++ + ": " + lanMap.getOrDefault(lan, "UNKNOWN"));
      lan = scaner.next();
    }
    scaner.close();
  }
}
