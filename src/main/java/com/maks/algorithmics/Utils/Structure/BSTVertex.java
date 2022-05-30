package com.maks.algorithmics.Utils.Structure;

public class BSTVertex {

  BSTVertex(int v) {
    key = v;
    parent = left = right = null;
    height = 0;
    size = 1;
  }
  // all these attributes remain public to slightly simplify the code
  public BSTVertex parent, left, right;
  public int key;
  public int height; // will be used in AVL lecture
  public int size;

  public int getRightChildSize() {

    return right == null ? 0 : right.size;
  }

  public int getLeftChildSize() {

    return left == null ? 0 : left.size;
  }
}
