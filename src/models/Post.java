package models;

import java.io.Serializable;

public class Post implements Serializable {

  private static final long serialVersionUID = 7100179587555243994L;

  private String author;
  private String title;
  private String content;

  public Post(String author, String title, String content) {
    this.author = author;
    this.title = title;
    this.content = content;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
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

  @Override
  public String toString() {
    return "{" +
        " author='" + getAuthor() + "'" +
        ", title='" + getTitle() + "'" +
        ", content='" + getContent() + "'" +
        "}";
  }

}
