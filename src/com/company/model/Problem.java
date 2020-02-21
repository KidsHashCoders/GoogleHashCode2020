package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Problem {
private int bookNumber;

private int libraryNumber;

private int days;

private int daysLeft;

public List<Book> books;

public List<Library> libraries;

public Problem(int bookNumber, int libraryNumber, int days) {
  this.bookNumber = bookNumber;
  this.libraryNumber = libraryNumber;
  this.days = days;
  this.books = new ArrayList<>(bookNumber);
  this.libraries = new ArrayList<>(libraryNumber);
  this.daysLeft = days;
}

  public int getDaysLeft() {
    return daysLeft;
  }

  public void setDaysLeft(int daysLeft) {
    this.daysLeft = daysLeft;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  public List<Library> getLibraries() {
    return libraries;
  }

  public void setLibraries(List<Library> libraries) {
    this.libraries = libraries;
  }

  public int getBookNumber() {
    return bookNumber;
  }

  public void setBookNumber(int bookNumber) {
    this.bookNumber = bookNumber;
  }

  public int getLibraryNumber() {
    return libraryNumber;
  }

  public void setLibraryNumber(int libraryNumber) {
    this.libraryNumber = libraryNumber;
  }

  public int getDays() {
    return days;
  }

  public void setDays(int days) {
    this.days = days;
  }
}
