package controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Post;
import models.User;
import utils.PersistData;

public class FeedController {

  private User loggedUser;
  private List<User> users = new ArrayList<>();
  private List<Post> posts = new ArrayList<>();

  @FXML
  private Button btnBack;

  @FXML
  private ListView<String> friendsPostsList;

  @FXML
  private Label txtAuthorPost;

  @FXML
  private Label txtContentPost;

  @FXML
  private Label txtPostTitle;

  public void userInfo(User u) {
    this.loggedUser = u;

    List<String> friends = new ArrayList<>();

    loggedUser.getFollowing().forEach(follow -> {
      friends.add(follow.getName());
    });

    PersistData persist = new PersistData();
    users = persist.getAllUsers();

    friends.forEach(friend -> {
      users.forEach(user -> {
        if (user.getName().equals(friend)) {
          user.getPosts().forEach(post -> {
            posts.add(post);
          });
        }
      });
    });

    List<String> titleFriendsPosts = new ArrayList<>();

    posts.forEach(post -> {
      titleFriendsPosts.add(post.getTitle());
    });

    friendsPostsList.setItems(FXCollections.observableArrayList(titleFriendsPosts));
  }

  @FXML
  void showDetailsPost(MouseEvent event) {
    String postSelected = friendsPostsList.getSelectionModel().getSelectedItem();

    posts.forEach(post -> {
      if (post.getTitle().equals(postSelected)) {
        txtPostTitle.setText(post.getTitle());
        txtContentPost.setText(post.getContent());
        txtAuthorPost.setText(post.getAuthor());
      }
    });
  }

  @FXML
  void showMainPage(ActionEvent event) {
    Stage stage = (Stage) btnBack.getScene().getWindow();
    stage.close();
  }

}
