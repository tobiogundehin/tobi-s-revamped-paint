package com.example.paintapp;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class PaintMenuBar {
    //File Menu
    FileMenuFunctions fileMenuFunctions = new FileMenuFunctions();
    Menu filemenu = new Menu("File");
    MenuItem openButton = new MenuItem("Open");
    MenuItem saveButton = new MenuItem("Save");
    MenuItem saveAsButton = new MenuItem("Save As");
    MenuItem newTabButton = new MenuItem("New Tab");
    MenuItem clearTabButton = new MenuItem("Clear Tab");

    //Settings Menu

    //Help Menu
    Menu helpmenu = new Menu("Help");
    MenuItem infoButton = new MenuItem("Information");
    MenuItem shortCutButton = new MenuItem("Shortcuts");

    public void initializeMenuBar(MenuBar menuBar){
        //File Menu
        filemenu.getItems().addAll(newTabButton, openButton, saveButton, saveAsButton, clearTabButton);
        //Settings Menu
        Menu settingsMenu = new Menu("Settings");
        //Help Menu
        helpmenu.getItems().addAll(infoButton, shortCutButton);
        //Add All Menus to MenuBar
        menuBar.getMenus().addAll(filemenu, settingsMenu, helpmenu);
    }
}
