package com.example.webtrowser;

/* This is the source code of WebTrowser : written in Java with JavaFX */

/********************************************************************************************************


 This JavaFX Application was written in Java by Younès B.
 Use is subject to license terms. Copyright (c) TTG Corporation.
 WebTrowser is a free software, but when you use it, you haven't to go on pornographic websites, playboys,
 darknet, and illegal websites.

 A note from the developer : On this web browser, we don't write the history, but it's not a reason to see
 bad things on Internet. When you want to contact us please write an email to : bendimerad.younes@gmx.de.

 This app was called WebTrowser, because the T of TTG is the first letter of the name of our enterprise.
 This is WebTrowser v1.0. Enjoy surfing on Internet!


 **********************************************************************************************************/

//Importing JavaFX libraries

import java.awt.Font;
import javax.swing.JOptionPane;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.web.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/********************************************************************************************************

 JavaFX Main class : WebTrowser extends Application

 *********************************************************************************************************/

public class Main extends Application {

    @Override public void start(Stage stage) {

        WebView browser = new WebView();
        WebEngine engine = browser.getEngine();
        engine.load("http://www.duckduckgo.com");
        WebHistory webhistory = engine.getHistory();
        browser.translateXProperty().set(0);
        browser.translateYProperty().set(50);

        Button home = new Button("🏠");
        home.translateXProperty().set(0);
        home.translateYProperty().set(0);
        home.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                engine.load("https://www.duckduckgo.com");
            }
        });

        Button reload = new Button("Reload");
        reload.translateXProperty().set(30);
        reload.translateYProperty().set(0);
        reload.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                engine.reload();
            }
        });

        Button prev = new Button("←");
        prev.translateXProperty().set(85);
        prev.translateYProperty().set(0);
        prev.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                webhistory.go(-1);
            }
        });

        Button next = new Button("→");
        next.translateXProperty().set(115);
        next.translateYProperty().set(0);
        next.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                webhistory.go(1);
            }
        });

        Button favorites = new Button("★");
        favorites.translateXProperty().set(145);
        favorites.translateYProperty().set(0);
        favorites.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                Stage favstage = new Stage();

                Button duckduckgo = new Button("DuckDuckGo");
                duckduckgo.translateXProperty().set(0);
                duckduckgo.translateYProperty().set(0);
                duckduckgo.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        engine.load("https://www.duckduckgo.com");
                    }
                });

                Button google = new Button("Google");
                google.translateXProperty().set(0);
                google.translateYProperty().set(30);
                google.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        engine.load("https://www.google.com");
                    }
                });

                Button googlecode = new Button("Google Code Search");
                googlecode.translateXProperty().set(0);
                googlecode.translateYProperty().set(60);
                googlecode.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        engine.load("https://developers.google.com/code-search");
                    }
                });

                Button googlemaps = new Button("Google Maps");
                googlemaps.translateXProperty().set(0);
                googlemaps.translateYProperty().set(90);
                googlemaps.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        engine.load("https://www.google.com/maps");
                    }
                });

                Button googletranslate = new Button("Google Translate");
                googletranslate.translateXProperty().set(0);
                googletranslate.translateYProperty().set(120);
                googletranslate.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        engine.load("https://translate.google.com/?hl=en");
                    }
                });

                Button youtube = new Button("YouTube");
                youtube.translateXProperty().set(0);
                youtube.translateYProperty().set(150);
                youtube.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        engine.load("https://www.youtube.com/");
                    }
                });

                Button quitfav = new Button("                                       QUIT                                        ");
                quitfav.translateXProperty().set(0);
                quitfav.translateYProperty().set(180);
                quitfav.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        favstage.close();
                    }
                });

                Node[] favallnodes = {duckduckgo, google, googlecode, googlemaps, googletranslate, youtube, quitfav};

                Group gr = new Group(favallnodes);

                Scene favscene = new Scene(gr, 300, 300);

                favstage.setScene(favscene);
                favstage.setTitle("WebTrowser Bookmarks");
                favstage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjHgdw7sDJuvEHDAQG5wVeTQQBBCpZmj4rhA&usqp=CAU"));
                favstage.show();

            }
        });

        Button search = new Button("🔍");
        search.translateXProperty().set(175);
        search.translateYProperty().set(0);
        search.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String url = JOptionPane.showInputDialog(null, "Veuillez rentrer l'adresse complète du site web (Protocole http:// compris): ", "Rechercher", JOptionPane.QUESTION_MESSAGE);
                engine.load(url);
            }
        });

        Button about = new Button("ℹ");
        about.translateXProperty().set(205);
        about.translateYProperty().set(0);
        about.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                Stage aboutstage = new Stage();
                Label description = new Label("This JavaFX Application was written in Java by Younès B.\n" +
                        "Use is subject to license terms. Copyright © TTG Corporation.\n" +
                        "WebTrowser is a free software, but when you use it, you haven't to go on pornographic websites, playboys,\n" +
                        "darknet, and illegal websites.\n" +
                        "\n" +
                        "A note from the developer : On this web browser, we don't write the history, but it's not a reason to see\n" +
                        "bad things on Internet. When you want to contact us please write an email to : bendimerad.younes@gmx.de.\n" +
                        "\n" +
                        "This app was called WebTrowser, because the T of TTG is the first letter of the name of our enterprise.\n" +
                        "This is WebTrowser v1.0. Enjoy surfing on Internet!");
                description.translateXProperty().set(0);
                description.translateYProperty().set(0);

                Button btnquit = new Button("QUIT");
                btnquit.translateXProperty().set(400);
                btnquit.translateYProperty().set(0);
                btnquit.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        aboutstage.close();
                    }
                });

                Node[] aboutallnodes = {description, btnquit};

                Group grabout = new Group(aboutallnodes);

                Scene aboutscene = new Scene(grabout, 700, 200);

                aboutstage.setScene(aboutscene);
                aboutstage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjHgdw7sDJuvEHDAQG5wVeTQQBBCpZmj4rhA&usqp=CAU"));
                aboutstage.setTitle("About WebTrowser");
                aboutstage.show();

            }
        });

        Button quitapp = new Button("QUIT");
        quitapp.translateXProperty().set(230);
        quitapp.translateYProperty().set(0);
        quitapp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Please click OK to quit WebTrowser. Thank you for choosing WebTrowser. Bye!", "Quit", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

        Label lbl = new Label("WebTrowser");
        lbl.translateXProperty().set(300);
        lbl.translateYProperty().set(5);

        Node[] allnodes = {browser, home, prev, next, reload, favorites, search, about, quitapp, lbl};

        Group root = new Group(allnodes);

        Scene scene = new Scene(root, 800, 650);

        stage.setOnCloseRequest(e -> {
            JOptionPane.showMessageDialog(null, "Please click OK to quit WebTrowser. Thank you for choosing WebTrowser. Bye!", "Quit", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });

        stage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjHgdw7sDJuvEHDAQG5wVeTQQBBCpZmj4rhA&usqp=CAU"));
        stage.setTitle("WebTrowser");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}