package com.company.model;

import java.util.Collection;

public class ResultLibrary {

    private int id;

    private Collection<Book> scannedBooks;

    public ResultLibrary(int id, Collection<Book> scannedBooks) {
        this.id = id;
        this.scannedBooks = scannedBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Book> getScannedBooks() {
        return scannedBooks;
    }

    public void setScannedBooks(Collection<Book> scannedBooks) {
        this.scannedBooks = scannedBooks;
    }
}
