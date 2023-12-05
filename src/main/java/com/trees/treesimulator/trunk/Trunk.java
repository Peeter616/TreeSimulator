package com.trees.treesimulator.trunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.trees.treesimulator.branch.Branch;

public class Trunk{

    private double height;
    private List<Branch> branches;
    private Random rand = new Random();
    private int leafsMultiplier;

    public Trunk(String color, int leafsMultiplier){
        this.height = 2;
        this.leafsMultiplier = leafsMultiplier;
        this.branches = new ArrayList<Branch>();
        addNewBranches(color);
    }

    public double getHeight() {
        return height;
    }

    public void setLeafsMultiplier(int leafsMultiplier) {
        this.leafsMultiplier = leafsMultiplier;
    }

    public int getLeafsMultiplier() {
        return leafsMultiplier;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getBranchesAmount() {
        return branches.size();
    }

    public int getLeavesAmount() {
        int result = 0;
        for (Branch branch : branches) {
            result += branch.getLeavesAmount();
        }
        return result;
    }

    public void growUp(String color){
        this.height += 0.5;
        growUpBranches(color);
    }

    public void growUpBranches(String color){
        if (!branches.isEmpty()){
            for (Branch branch : branches) {
                branch.growUp(0.15, rand.nextInt(3*leafsMultiplier)+3*leafsMultiplier, color);
            }
            addNewBranches(color);
        }
    }
    public void addNewBranches(String color) {
        for (int j = 0; j < rand.nextInt(2) + 1; j++) {
            branches.add(new Branch(0.3, rand.nextInt(6*leafsMultiplier)+6*leafsMultiplier, color));
        }
    }
}
