package controllers;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;
import utils.PersistData;

public class RegisterController {

  @FXML
  private TextField fieldAcademicEducation;

  @FXML
  private Button btnBack;

  @FXML
  private Button btnNewUser;

  @FXML
  private TextField fieldBirthDate;

  @FXML
  private TextField fieldInterests;

  @FXML
  private TextField fieldName;

  @FXML
  private TextField fieldPassword;

  @FXML
  void handleRegister(ActionEvent event) throws IOException, ClassNotFoundException {
    String name = fieldName.getText();
    String password = fieldPassword.getText();
    String birthDate = fieldBirthDate.getText();
    String academicEducation = fieldAcademicEducation.getText();
    String interests = fieldInterests.getText();

    User newUser = new User(name, password, birthDate, academicEducation, interests);

    PersistData persist = new PersistData();
    List<User> users = persist.getAllUsers();

    users.add(newUser);

    persist.save(users);

    this.showMainPage(event);
  }

  @FXML
  void showMainPage(ActionEvent event) {
    Stage stage = (Stage) btnBack.getScene().getWindow();
    stage.close();
  }

}
