package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import models.User;

public class MainController {

  private User user;

  @FXML
  private Button btnProfile;

  @FXML
  private Button btnShowRegister;

  @FXML
  private Button btnShowFeed;

  @FXML
  private Button btnShowSearchUser;

  @FXML
  private Button btnLogout;

  @FXML
  private Label loggedUser;

  public void userInfo(User u) {
    this.user = u;
    loggedUser.setText(user.getName());

    if (!user.getName().equals("admin")) {
      btnShowRegister.setVisible(false);
    }
  }

  @FXML
  void showProfile(ActionEvent event) throws IOException {
    try {
      Stage stage = new Stage();
      FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("../views/profile.fxml"));
      Scene scene = new Scene(fxmlLoader.load());
      stage.setScene(scene);
      stage.setResizable(true);
      stage.show();

      ProfileController controller = fxmlLoader.getController();
      controller.userInfo(user);

    } catch (IOException e) {
      System.out.println("Load error main page");
    }
  }

  @FXML
  void showFeed(ActionEvent event) {
    try {
      Stage stage = new Stage();
      FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("../views/feed.fxml"));
      Scene scene = new Scene(fxmlLoader.load());
      stage.setScene(scene);
      stage.setResizable(true);
      stage.show();

    } catch (IOException e) {
      System.out.println("Load error main page");
    }
  }

  @FXML
  void showRegister(ActionEvent event) throws IOException {
    try {
      Stage stage = new Stage();
      FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("../views/register.fxml"));
      Scene scene = new Scene(fxmlLoader.load());
      stage.setScene(scene);
      stage.setResizable(true);
      stage.show();

    } catch (IOException e) {
      System.out.println("Load error main page");
    }
  }

  @FXML
  void showSearchUser(ActionEvent event) {
    try {
      Stage stage = new Stage();
      FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("../views/searchUser.fxml"));
      Scene scene = new Scene(fxmlLoader.load());
      stage.setScene(scene);
      stage.setResizable(true);
      stage.show();

      SearchController controller = fxmlLoader.getController();
      controller.userInfo(user);

    } catch (IOException e) {
      System.out.println("Load error search user page");
    }
  }

  @FXML
  void handleLogout(ActionEvent event) {
    try {
      this.user = null;
      FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("../views/login.fxml"));
      Scene scene = new Scene(fxmlLoader.load());
      Stage stage = (Stage) btnLogout.getScene().getWindow();
      stage.setScene(scene);
      stage.setResizable(false);
      stage.show();

    } catch (IOException e) {
      System.out.println("Load error login page");
    }
  }
}
