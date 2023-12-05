package com.trees.treesimulator;

import com.trees.treesimulator.listener.NumericTextFieldListener;
import com.trees.treesimulator.season.SeasonService;
import com.trees.treesimulator.tree.ConiferousTree;
import com.trees.treesimulator.tree.DeciduousTree;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class Main extends Application {

    Label age = new Label();
    Label height = new Label();
    Label branchesAmount = new Label();
    Label leavesAmount = new Label();
    Label leafsColor = new Label();
    Label season = new Label();
    LocalDate currentDate = LocalDate.now();
    Month currentMonth = currentDate.getMonth();
    SeasonService seasonService = new SeasonService();
    ConiferousTree coniferousTree = new ConiferousTree(seasonService.getSeason(currentMonth));
    DeciduousTree deciduousTree = new DeciduousTree(seasonService.getSeason(currentMonth));

    @Override
    public void start(Stage stage) throws IOException {

        Menu fileMenu = new Menu("File");
        MenuItem reset = new MenuItem("Reset");
        MenuItem exit = new MenuItem("Exit");
        reset.setOnAction(e -> init());
        exit.setOnAction(e -> Platform.exit());
        fileMenu.getItems().addAll(reset, exit);

        MenuBar menuBar = new MenuBar(fileMenu);
        menuBar.setTranslateX(0);
        menuBar.setTranslateY(0);

        TilePane tilePane = new TilePane(menuBar);
        VBox menuVBox = new VBox();
        menuVBox.getChildren().add(tilePane);

        VBox descriptionVBox = new VBox();
        descriptionVBox.setPadding(new Insets(20.0));
        descriptionVBox.setAlignment(Pos.TOP_LEFT);
        descriptionVBox.setSpacing(20.0);
        descriptionVBox.getChildren().addAll(age, height, branchesAmount, leavesAmount, leafsColor, season);

        init();

        Label growingLabel = new Label("How many years do you want the tree to age?");
        TextField growingTextField = new TextField("1");
        growingTextField.textProperty().addListener(new NumericTextFieldListener(growingTextField));

        VBox ageVBox = new VBox();
        ageVBox.setAlignment(Pos.CENTER);
        ageVBox.setSpacing(20.0);
        ageVBox.getChildren().addAll(growingLabel, growingTextField);

        ToggleGroup growingToggleGroup = new ToggleGroup();
        RadioButton coniferousTreeRadioButton = new RadioButton("Coniferous tree");
        RadioButton deciduousTreeRadioButton = new RadioButton("Deciduous tree");
        coniferousTreeRadioButton.setToggleGroup(growingToggleGroup);
        coniferousTreeRadioButton.setSelected(true);
        deciduousTreeRadioButton.setToggleGroup(growingToggleGroup);

        VBox treeKindVBox = new VBox();
        treeKindVBox.setAlignment(Pos.CENTER);
        treeKindVBox.setSpacing(20.0);
        treeKindVBox.getChildren().addAll(coniferousTreeRadioButton, deciduousTreeRadioButton);

        Button growingButton =new Button("Grow up!");
        growingButton.setOnAction(e -> growingUp(Integer.parseInt(growingTextField.getText()), coniferousTreeRadioButton.isSelected()));

        HBox growingHBox = new HBox();
        growingHBox.setPadding(new Insets(20.0));
        growingHBox.setAlignment(Pos.CENTER_LEFT);
        growingHBox.setSpacing(20.0);
        growingHBox.getChildren().addAll(ageVBox, treeKindVBox, growingButton);

        VBox generalVbox = new VBox();
        generalVbox.getChildren().addAll(menuVBox, descriptionVBox, growingHBox);

        Scene scene = new Scene(generalVbox, 640, 480);
        stage.setTitle("Tree Simulator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void init() {
        coniferousTree = new ConiferousTree(seasonService.getSeason(currentMonth));
        deciduousTree = new DeciduousTree(seasonService.getSeason(currentMonth));
        age.setText("Age");
        height.setText("Height");
        branchesAmount.setText("BranchesAmount");
        leavesAmount.setText("LeavesAmount");
        leafsColor.setText("LeafsColor");
        season.setText("Season");
    }

    public void growingUp(int ageDelta, boolean isConiferousTree) {

        if (isConiferousTree ==true) {
            coniferousTree.growUp(ageDelta, seasonService.getSeason(currentMonth));
            age.setText("Age = " + coniferousTree.getAge());
            height.setText("Height = " + coniferousTree.getTrunk().getHeight());
            branchesAmount.setText("BranchesAmount = " + coniferousTree.getTrunk().getBranchesAmount());
            leavesAmount.setText("LeavesAmount = " + coniferousTree.getTrunk().getLeavesAmount());
            leafsColor.setText("LeafsColor = " + coniferousTree.getLeafsColor());
            season.setText("Season = " + seasonService.getSeason(currentMonth).toString());
        } else {
            deciduousTree.growUp(ageDelta, seasonService.getSeason(currentMonth));
            age.setText("Age = " + deciduousTree.getAge());
            height.setText("Height = " + deciduousTree.getTrunk().getHeight());
            branchesAmount.setText("BranchesAmount = " + deciduousTree.getTrunk().getBranchesAmount());
            leavesAmount.setText("LeavesAmount = " + deciduousTree.getTrunk().getLeavesAmount());
            leafsColor.setText("LeafsColor = " + deciduousTree.getLeafsColor());
            season.setText("Season = " + seasonService.getSeason(currentMonth).toString());
        }
    }
}