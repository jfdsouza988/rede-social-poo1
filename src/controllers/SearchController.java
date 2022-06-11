package controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.User;
import utils.PersistData;

public class SearchController {

  private User userLogged;
  private User newFriend;
  private List<User> filterUsers = new ArrayList<>();
  private String userSelected;
  private Boolean existsFollowing = false;
  private Boolean existsFollower = false;

  @FXML
  private Button btnBack;

  @FXML
  private Button btnSearch;

  @FXML
  private Button btnAddFriend;

  @FXML
  private ListView<String> listUsers;

  @FXML
  private Label txtAcademicEducation;

  @FXML
  private Label txtInterestsUser;

  @FXML
  private Label txtNameUser;

  @FXML
  private RadioButton radioSearchInterests;

  @FXML
  private RadioButton radioSearchName;

  @FXML
  private ToggleGroup search;

  @FXML
  private TextField txtSearchTerm;

  public void userInfo(User u) {
    this.userLogged = u;
  }

  @FXML
  void handleSearchUser(ActionEvent event) {
    String searchTerm = txtSearchTerm.getText();
    Boolean searchByName = radioSearchName.isSelected();

    PersistData persist = new PersistData();

    List<User> users = persist.getAllUsers();

    users.forEach(user -> {
      if (searchByName == true) {
        if (user.getName().contains(searchTerm)) {
          filterUsers.add(user);
        }
      } else {
        if (user.getInterests() != null) {
          if (user.getInterests().contains(searchTerm)) {
            filterUsers.add(user);
          }
        }
      }
    });

    List<String> namesUsersFiltered = new ArrayList<>();

    for (User usr : filterUsers) {
      namesUsersFiltered.add(usr.getName());
    }

    listUsers.setItems(FXCollections.observableArrayList(namesUsersFiltered));
  }

  @FXML
  void handleAddFriend(ActionEvent event) {
    PersistData persist = new PersistData();
    List<User> users = persist.getAllUsers();

    filterUsers.forEach(usrFilter -> {
      if (usrFilter.getName().equals(userSelected)) {
        newFriend = usrFilter;
      }
    });

    users.forEach(u -> {
      if (u.getName().equals(userLogged.getName())) {
        u.getFollowing().forEach(follow -> {
          if (follow.getName().equals(newFriend.getName())) {
            existsFollowing = true;
          } else {
            existsFollowing = false;
          }
        });
        if (!existsFollowing) {
          u.addFollowing(newFriend);
        } else {
          System.out.println("Você já está seguindo este usuário!");
        }
      }
      if (u.getName().equals(newFriend.getName())) {
        u.getFollowers().forEach(follower -> {
          if (follower.getName().equals(userLogged.getName())) {
            existsFollower = true;
          } else {
            existsFollower = false;
          }
        });
        if (!existsFollower) {
          u.addFollowers(userLogged);
        }
      }
    });

    persist.save(users);

  }

  @FXML
  void showDetailsUser(MouseEvent event) {
    userSelected = listUsers.getSelectionModel().getSelectedItem();

    filterUsers.forEach(filterUser -> {
      if (filterUser.getName().equals(userSelected)) {
        txtNameUser.setText(filterUser.getName());
        txtInterestsUser.setText(filterUser.getInterests());
        txtAcademicEducation.setText(filterUser.getAcademicEducation());
      }
    });
  }

  @FXML
  void showMainPage(ActionEvent event) {
    Stage stage = (Stage) btnBack.getScene().getWindow();
    stage.close();
  }

}
