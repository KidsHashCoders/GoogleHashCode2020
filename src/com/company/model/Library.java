package com.company.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library implements Scoring {

  private int id;

  public Map<Integer, Book> books;

  private int signUpCost;

  private int booksPerDay;

  private int score;

  private int realReadBooks;

  public Library(int id, int bookSize, int signUpCost, int booksPerDay) {
    this.id = id;
    this.signUpCost = signUpCost;
    this.booksPerDay = booksPerDay;
    this.books = new LinkedHashMap<>(bookSize);
  }

  public void updateScore(int daysLeft) {
    this.score = 0;
    int toRead = (daysLeft - this.signUpCost) * this.booksPerDay;
    this.realReadBooks = 0;
    for(Book book : this.books.values()) {
      if (realReadBooks == toRead) {
        break;
      }
      if (!book.isRead()) {
        this.score += book.getScore();
        realReadBooks++;
      }
    }
    this.score /= this.signUpCost;
  }

  public ResultLibrary choseLibrary() {
    return new ResultLibrary(this.id, this.books.values().stream().filter(entry ->
      !entry.isRead()
    ).limit(this.realReadBooks).peek(entry -> entry.setRead(true)).collect(Collectors.toList()));
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
