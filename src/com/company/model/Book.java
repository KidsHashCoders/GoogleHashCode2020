package com.company.model;

public class Book  implements Scoring {
private int score;
private int id;

private boolean read;

public Book(int id, int score) {
  this.id = id;
  this.score = score;
}

  public boolean isRead() {
    return read;
  }

  public void setRead(boolean read) {
    this.read = read;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
}
