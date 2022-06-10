package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Post;
import models.User;

public class ProfileController {

    private User userLogged;

    @FXML
    private Button btnClose;

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
    }

    @FXML
    void handleClose(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
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
        Post newPost = new Post(userLogged, postTitle, postContent);

        userLogged.getPosts().add(newPost);

        System.out.println(userLogged);
    }
}