package controllers;

/* import java.util.ArrayList;
import java.util.List; */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/* import models.User;
import utils.PersistData; */

public class App extends Application {

    private static Scene loginScene;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        /* List<User> users = new ArrayList<User>();
        users.add(new User("admin", "UFP31"));

        PersistData persist = new PersistData();
        persist.save(users); */

        primaryStage.setTitle("Clubinho da Computação Login");

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("../views/login.fxml"));
        loginScene = new Scene(fxmlLogin);

        primaryStage.setScene(loginScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
