package com.trees.treesimulator.tree;

import com.trees.treesimulator.season.Season;
import com.trees.treesimulator.trunk.Trunk;


public class DeciduousTree extends Tree {

    public DeciduousTree(Season season) {
        this.age = 1;
        setLeafsColor(season);
        this.trunk = new Trunk(leafsColor, 1);
    }

    public void setLeafsColor(Season season) {
        if(season == Season.WINTER){
            this.leafsColor = "no leafs in winter";
        }
        else if(season == Season.SPRING){
            this.leafsColor = "green";
        }
        else if(season == Season.SUMMER){
            this.leafsColor = "dark green";
        }
        else if(season == Season.AUTUMN){
            this.leafsColor = "gold";
        }
        else {
            this.leafsColor = "green";
        }
    }
}
