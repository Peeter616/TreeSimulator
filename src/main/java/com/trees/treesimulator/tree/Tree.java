package com.trees.treesimulator.tree;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import com.trees.treesimulator.season.Season;
import com.trees.treesimulator.trunk.Trunk;

public abstract class Tree {

    protected int age;
    protected Trunk trunk;
    protected String leafsColor;

    public int getAge(){
        return this.age;
    }

    public Trunk getTrunk(){
        return this.trunk;
    }

    public String getLeafsColor(){
        return this.leafsColor;
    }

    public abstract void setLeafsColor(Season season);

    public void growUp(int ageIncrease, Season season){
        setLeafsColor(season);
        int newAge = this.getAge() + ageIncrease;
        if (newAge > 200) {
            showAlert("Trees don't live that long. Maximal age is 200.");
            return;
        }
        this.age += ageIncrease;
        for (int i = 0; i < ageIncrease; i++) {
            this.trunk.growUp(leafsColor);
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
