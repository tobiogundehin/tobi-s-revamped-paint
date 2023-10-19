package com.example.paintapp;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

/**
 * Class Responsible for handling file menu functionality, typically involving use of fileChooser
 */
public class FileMenuFunctions {
    String lastFileLocation = "";
    public void setFileChooserFilters(FileChooser fileChooser){
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files (PNG,JPEG,BMP,GIF)", "*.png", "*.jpg", "*.bmp", "*.gif",".pdf"),
                new FileChooser.ExtensionFilter("Image Files (.jpg)", "*.jpg"),
                new FileChooser.ExtensionFilter("Image Files (.png)", "*.png"),
                new FileChooser.ExtensionFilter("Image Files (.bmp)", "*.bmp"),
                new FileChooser.ExtensionFilter("Image Files (.gif)", "*.gif"),
                new FileChooser.ExtensionFilter("Image Files (.pdf)", "*.pdf")
        );
    }
    public void imageFileOpen(FileChooser fileChooser, BorderPane borderPane, Stage stage) {
        fileChooser.setTitle("Open");
        ImageView imageView = new ImageView();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            try {
                FileInputStream input = new FileInputStream(selectedFile);
                Image image = new Image(input, 800, 800, false, false);
                imageView.setImage(image);
                stage.setTitle(selectedFile.getName());
                lastFileLocation = selectedFile.getAbsolutePath();
                borderPane.setCenter(imageView);
            } catch (FileNotFoundException e) {
                var fnfErrorMessage = new Label("File was not found");
                borderPane.setCenter(fnfErrorMessage);
            }
        }
    }
    public void imageFileSaveAs(FileChooser fileChooser, BorderPane borderPane, Stage stage){
        fileChooser.setTitle("Save As");
        File saveFile = fileChooser.showSaveDialog(stage);
        Image snapshot = borderPane.getCenter().snapshot(null, null);
        BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
        try {
            if (bImage != null) {
                ImageIO.write(bImage, "png", saveFile);
                lastFileLocation = saveFile.getAbsolutePath();
            }
        } catch (IOException f) {
            throw new RuntimeException(f);
        }
    }
    public void imageFileSave(FileChooser fileChooser, BorderPane borderPane, Stage stage){
        if (!lastFileLocation.isEmpty()){
            File saveFile = new File(lastFileLocation);
            Image snapshot = borderPane.getCenter().snapshot(null, null);
            BufferedImage bImage = SwingFXUtils.fromFXImage(snapshot, null);
            try {
                if (bImage != null) {
                    ImageIO.write(bImage, "png", saveFile);
                    lastFileLocation = saveFile.getAbsolutePath();
                }
            } catch (IOException f) {
                throw new RuntimeException(f);
            }
        } else {
            System.out.println("No File");
        }
    }
}
