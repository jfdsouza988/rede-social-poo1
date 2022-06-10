package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

  private static final long serialVersionUID = 7100179587555243994L;

  private String name;
  private String password;
  private String birthDate;
  private String academicEducation;
  private String interests;

  private List<Post> posts;
  private List<Follow> followers;

  public User(String name, String password, String birthDate, String academicEducation, String interests) {
    this.name = name;
    this.password = password;
    this.birthDate = birthDate;
    this.academicEducation = academicEducation;
    this.interests = interests;
    this.posts = new ArrayList<>();
    this.followers = new ArrayList<>();
  }

  public User(String name, String password) {
    this.name = name;
    this.password = password;
    this.posts = new ArrayList<>();
    this.followers = new ArrayList<>();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getBirthDate() {
    return this.birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getAcademicEducation() {
    return this.academicEducation;
  }

  public void setAcademicEducation(String academicEducation) {
    this.academicEducation = academicEducation;
  }

  public String getInterests() {
    return this.interests;
  }

  public void setInterests(String interests) {
    this.interests = interests;
  }

  public List<Post> getPosts() {
    return this.posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  public List<Follow> getFollowers() {
    return this.followers;
  }

  public void setFollowers(List<Follow> followers) {
    this.followers = followers;
  }

  @Override
  public String toString() {
    return "{" +
        " name='" + getName() + "'" +
        ", password='" + getPassword() + "'" +
        ", birthDate='" + getBirthDate() + "'" +
        ", academicEducation='" + getAcademicEducation() + "'" +
        ", interests='" + getInterests() + "'" +
        ", posts='" + getPosts() + "'" +
        ", followers='" + getFollowers() + "'" +
        "}";
  }

}
