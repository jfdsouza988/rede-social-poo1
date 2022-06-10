package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FeedController {

  @FXML
  private Button btnBack;

  @FXML
  void showMainPage(ActionEvent event) {
    try {
      Stage stage = new Stage();
      FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("../views/main.fxml"));
      Scene scene = new Scene(fxmlLoader.load());
      stage.setScene(scene);
      stage.setResizable(true);
      stage.show();

    } catch (IOException e) {
      System.out.println("Load error main page");
    }
  }

}
