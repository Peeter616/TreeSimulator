module com.trees.treesimulator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.trees.treesimulator to javafx.fxml;
    exports com.trees.treesimulator;
}