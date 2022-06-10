package models;

public class Follow {
  private User follow;
  private User follower;

  public Follow(User follow, User follower) {
    this.follow = follow;
    this.follower = follower;
  }

  public User getFollow() {
    return this.follow;
  }

  public void setFollow(User follow) {
    this.follow = follow;
  }

  public User getFollower() {
    return this.follower;
  }

  public void setFollower(User follower) {
    this.follower = follower;
  }
}
