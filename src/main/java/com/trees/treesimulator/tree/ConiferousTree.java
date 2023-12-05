package com.trees.treesimulator.tree;

import com.trees.treesimulator.season.Season;
import com.trees.treesimulator.trunk.Trunk;

public class ConiferousTree extends Tree {

    public ConiferousTree(Season season) {
        this.age = 1;
        setLeafsColor(season);
        this.trunk = new Trunk(leafsColor, 3);
    }

    public void setLeafsColor(Season season) {
        if(season == Season.WINTER){
            this.leafsColor = "white";
        }
        else if(season != Season.WINTER && season != Season.UNKNOWN){
            this.leafsColor = "green";
        }
        else {
            this.leafsColor = "dark green";
        }
    }
}
