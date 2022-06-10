package models;

/* import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; */

public class Post {
  private static int count = 1;

  private int idPost;
  private User author;
  private String title;
  private String content;
  // private String createdAt;

  /*
   * LocalDateTime now = LocalDateTime.now();
   * 
   * DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
   * String date = formatterData.format(now);
   * 
   * DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
   * String time = formatterHora.format(now);
   */

  public Post(User author, String title, String content) {
    this.idPost = count++;
    this.author = author;
    this.title = title;
    this.content = content;
    // this.createdAt = date + " às " + time;
  }

  public int getIdPost() {
    return this.idPost;
  }

  public void setIdPost(int idPost) {
    this.idPost = idPost;
  }

  public User getAuthor() {
    return this.author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
