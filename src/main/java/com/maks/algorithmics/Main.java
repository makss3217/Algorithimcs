package com.maks.algorithmics;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {

    //TrainTable.run();
  }



  public static Integer readIntFromLineOrNull(BufferedReader br) throws IOException {
    String line = br.readLine();
    if(line != null) {
      return Integer.parseInt(line);
    } else {
      return null;
    }
  }

}

