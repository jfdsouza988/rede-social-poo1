package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;
import utils.PersistData;

public class LoginController {

  private User loggedUser;

  @FXML
  private Button btnLogin;

  @FXML
  private TextField password;

  @FXML
  private TextField name;

  @FXML
  void handleLogin(ActionEvent event) {
    String userName = name.getText();
    String userPassword = password.getText();

    PersistData persist = new PersistData();

    persist.getAllUsers().forEach(user -> {
      if (userName.equals(user.getName()) && userPassword.equals(user.getPassword())) {
        loggedUser = user;
      }
    });

    if (loggedUser != null) {
      try {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("../views/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        MainController controller = fxmlLoader.getController();
        controller.userInfo(loggedUser);

      } catch (IOException e) {
        System.out.println("Load error main page");
      }
    } else {
      System.out.println("Usuario ou senha incorretos");
    }

  }

}
