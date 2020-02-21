package com.company.utils;

import com.company.model.Book;
import com.company.model.Library;
import com.company.model.Problem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

  public Problem parseFile(String path) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(path));
    int lineNumber = 0;
    int libraryId = 0;

    Problem problem = null;

    String line = br.readLine();
    while (line != null) {
      System.out.println(line);
      String[] values = line.split(" ");

      if (lineNumber == 0) {
        problem = new Problem(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]));
      } else if (lineNumber == 1) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
          books.add(i, new Book(i, Integer.parseInt(values[i])));
        }
        problem.books = books;
      } else if (lineNumber % 2 == 0){
        problem.libraries.add(new Library(libraryId++, Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2])));
      } else {
        Library library = problem.libraries.get(problem.libraries.size() - 1);
        List<Book> booksToInsert = new ArrayList<>();
        for (String bookId: values) {
          booksToInsert.add(problem.books.get(Integer.parseInt(bookId)));
        }
        library.setBooks(booksToInsert);
      }

      line = br.readLine();
      lineNumber++;
    }
    br.close();

    return problem;
  }

  public void writeOutput(String path, Problem problem) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(path));
    writer.write(String.valueOf(problem.getLibraryNumber()));
    writer.newLine();

    for (Library library : problem.libraries) {
      writer.write(String.format("%d %d", library.getId(), library.books.size()));
      writer.newLine();
      for (Book book : library.books.values()) {
        writer.write(String.valueOf(book.getId()));
        writer.write(" ");
      }
      writer.newLine();
    }

    writer.close();
  }
}
