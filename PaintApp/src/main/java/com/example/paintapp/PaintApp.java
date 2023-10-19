package com.example.paintapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class PaintApp extends Application {
    @Override
    public void start(Stage stage){
        //Class initializations
        DefaultValues defaultValues = new DefaultValues();
        PaintMenuBar paintMenuBar = new PaintMenuBar();
        FileMenuFunctions fileMenuFunctions = new FileMenuFunctions();
        FileChooser fileChooser = new FileChooser();
        fileMenuFunctions.setFileChooserFilters(fileChooser);

        //Create Opening Window(BorderPane)
        BorderPane borderPane = new BorderPane();

        //MenuBar
        MenuBar menuBar = new MenuBar();
        paintMenuBar.initializeMenuBar(menuBar);
        borderPane.setTop(menuBar);
        //Open Button
        paintMenuBar.openButton.setOnAction(e -> {
            fileMenuFunctions.imageFileOpen(fileChooser,borderPane,stage);
        });

        //Save Button
        paintMenuBar.saveButton.setOnAction(e ->{
            fileMenuFunctions.imageFileSave(fileChooser, borderPane, stage);
        });
        //Save As Button
        paintMenuBar.saveAsButton.setOnAction(e ->{
            fileMenuFunctions.imageFileSaveAs(fileChooser, borderPane, stage);
        });
        //Center TabPane


        Scene scene = new Scene(borderPane,defaultValues.getDefaultBorderPaneWidth(), defaultValues.getDefaultBorderPaneHeight());
        stage.setTitle("Paint App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}