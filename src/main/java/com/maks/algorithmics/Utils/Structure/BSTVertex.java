package com.maks.algorithmics.Utils.Structure;

public class BSTVertex {

  BSTVertex(int v) { key = v; parent = left = right = null; height = 0; }
  // all these attributes remain public to slightly simplify the code
  public BSTVertex parent, left, right;
  public int key;
  public int height; // will be used in AVL lecture
}
