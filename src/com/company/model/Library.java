package com.company.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Library implements Scoring {

  private int id;

  public Map<Integer, Book> books;

  private int signUpCost;

  private int booksPerDay;

  private int score;

  public Library(int id, int bookSize, int signUpCost, int booksPerDay) {
    this.id = id;
    this.signUpCost = signUpCost;
    this.booksPerDay = booksPerDay;
    this.books = new LinkedHashMap<>(bookSize);
  }

  public void updateScore(int daysLeft) {
    this.score = 0;
    int readBooks = 0, toRead = (daysLeft - this.signUpCost) * this.booksPerDay;
    for(Book book : this.books.values()) {
      if (readBooks == toRead) {
        break;
      }
      this.score += book.getScore();
      readBooks++;
    }
  }

  public void addBook(Book book) {
    if (this.books == null) {
      this.books = new LinkedHashMap<>();
    }
    this.books.put(book.getId(), book);
  }

  public void setBooks(List<Book> books) {
    if (this.books == null) {
      this.books = new LinkedHashMap<>(books.size());
    }
    books.sort(ScoringComparator.instance);
    for (Book book: books) {
      this.books.put(book.getId(), book);
    }
  }

  public Map<Integer, Book> getBooks() {
    return books;
  }

  public void setBooks(Map<Integer, Book> books) {
    this.books = books;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSignUpCost() {
    return signUpCost;
  }

  public void setSignUpCost(int signUpCost) {
    this.signUpCost = signUpCost;
  }

  public int getBooksPerDay() {
    return booksPerDay;
  }

  public void setBooksPerDay(int booksPerDay) {
    this.booksPerDay = booksPerDay;
  }
}
