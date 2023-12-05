package com.trees.treesimulator;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    private Main main;

    @BeforeAll
    static void initJfxRuntime() {
        Platform.startup(() -> {});
    }

    @BeforeEach
    public void setUp() throws Exception {
        main = new Main();
    }

    @Test
    public void testGrowingUpConiferousTree() {
        main.growingUp(0, true);

        assertEquals("Age = 1", main.age.getText());
    }

    @Test
    public void testGrowingUpDeciduousTree() {
        main.growingUp(1, false);

        assertEquals("Age = 2", main.age.getText());
    }
}
