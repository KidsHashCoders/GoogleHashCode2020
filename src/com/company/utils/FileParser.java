package com.company.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {


  public void parseFile(String path) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(path));
    String line = br.readLine();
    while (line != null) {
      System.out.println(line);
      // read next line
      line = br.readLine();
    }
    br.close();
  }
}
