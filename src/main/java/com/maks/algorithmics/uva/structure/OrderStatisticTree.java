package com.maks.algorithmics.uva.structure;

import com.maks.algorithmics.Utils.InputUtils;
import com.maks.algorithmics.Utils.Structure.BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderStatisticTree {

//  public static int MAX_NUMBER = 2000002;

  public static int MAX_NUMBER = 50;


  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder strBuilder = new StringBuilder();
  private static final BST tree = createBalancedAVLTree();

  public static void run() throws IOException {
    tree.inorder();
    Integer testCase;
    while((testCase = InputUtils.readIntFromLineOrNull(br)) != null) {
      strBuilder.append(answer(testCase));
    }
  }

  private static String answer(Integer testCase) {
      return "to do";
  }

  private static BST createBalancedAVLTree() {
    BST tree = new BST();
    for(int i = 0; i <= MAX_NUMBER / 2; i++) {
      tree.insert((i * 2) + 1);
    }
    int cycle = 2;
    int iterator = tree.getKthSmallestValue(cycle);
    int indexToRemove;
    while(iterator <= tree.size()) {
      indexToRemove = iterator;
      while(indexToRemove <= tree.size()) {
        tree.deleteKthSmallestNode(indexToRemove);
        indexToRemove += iterator - 1;
        tree.inorder();
      }
      cycle++;
      iterator = tree.getKthSmallestValue(cycle);
    }
    return tree;
  }

}
