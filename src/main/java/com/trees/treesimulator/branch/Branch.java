package com.trees.treesimulator.branch;


import java.util.ArrayList;
import java.util.List;

import com.trees.treesimulator.leaf.Leaf;

public class Branch {

    private double length;
    private List<Leaf> leaves;

    public Branch(double length, int amount, String color){
        this.length = length;
        this.leaves = new ArrayList<Leaf>();
        for (int i = 0; i < amount; i++) {
            leaves.add(new Leaf(color));
        }
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void addLeaf(Leaf leaf) {
        leaves.add(leaf);
    }

    public int getLeavesAmount() {
        return leaves.size();
    }

    public void growUp(double length, int amount, String color){
        this.length += length;
        for (Leaf leaf : leaves) {
            leaf.setColor(color);
        }
        for (int i = 0; i < amount; i++) {
            leaves.add(new Leaf(color));
        }
    }
}