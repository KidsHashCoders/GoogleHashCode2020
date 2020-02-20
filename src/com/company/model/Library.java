package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Library {

  private int id;

  private List<Book> books;

  private int signUpCost;

  private int booksPerDay;

  public void addBook(Book book) {
    if (this.books == null) {
      this.books = new ArrayList<>();
    }
    this.books.add(book.getId(), book);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
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
