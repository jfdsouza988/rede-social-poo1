package controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Post;
import models.User;
import utils.PersistData;

public class ProfileController {

    private User userLogged;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnNewPost;

    @FXML
    private Label lbAcademicEducation;

    @FXML
    private Label lbBirthDate;

    @FXML
    private Label lbInterests;

    @FXML
    private Label loggedUser;

    @FXML
    private Label viewPostContent;

    @FXML
    private ListView<String> listFollowersUsers;

    @FXML
    private ListView<String> listFollowingUsers;

    @FXML
    private ListView<String> listPosts;

    @FXML
    private TextField txtPostContent;

    @FXML
    private TextField txtPostTitle;

    public void userInfo(User u) {
        this.userLogged = u;
        loggedUser.setText(userLogged.getName());
        lbBirthDate.setText(userLogged.getBirthDate());
        lbAcademicEducation.setText(userLogged.getAcademicEducation());
        lbInterests.setText(userLogged.getInterests());

        List<String> userPosts = new ArrayList<>();
        List<String> userFollowing = new ArrayList<>();
        List<String> userFollowers = new ArrayList<>();

        for (Post pst : userLogged.getPosts()) {
            userPosts.add(pst.getTitle());
        }
        listPosts.setItems(FXCollections.observableArrayList(userPosts));

        for (User usr : userLogged.getFollowing()) {
            userFollowing.add(usr.getName());
        }
        listFollowingUsers.setItems(FXCollections.observableArrayList(userFollowing));

        for (User usr : userLogged.getFollowers()) {
            userFollowers.add(usr.getName());
        }
        listFollowersUsers.setItems(FXCollections.observableArrayList(userFollowers));
    }

    @FXML
    void handleClose(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handleClearFields(ActionEvent event) {
        txtPostTitle.clear();
        txtPostContent.clear();

        userInfo(userLogged);
    }

    @FXML
    void showPostContent(MouseEvent event) {
        String postSelected = listPosts.getSelectionModel().getSelectedItem();

        userLogged.getPosts().forEach(post -> {
            if (post.getTitle().equals(postSelected)) {
                viewPostContent.setText(post.getContent());
            }
        });

    }

    @FXML
    void handleNewPost(ActionEvent event) {
        String postTitle = txtPostTitle.getText();
        String postContent = txtPostContent.getText();

        if (postTitle.isBlank()) {
            System.out.println("Titulo do post nao informado");
        }
        if (postContent.isBlank()) {
            System.out.println("Conteudo do post nao informado");
        }

        PersistData persistor = new PersistData();
        List<User> users = persistor.getAllUsers();

        users.forEach(u -> {
            if (u.getName().equals(userLogged.getName())) {
                u.addPost(userLogged.getName(), postTitle, postContent);
                userLogged = u;
            }
        });

        persistor.save(users);
        handleClearFields(event);
    }
}