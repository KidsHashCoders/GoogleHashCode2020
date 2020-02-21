package com.company.model;

import java.util.Comparator;

public class ScoringComparator implements Comparator<Scoring> {

  public static final ScoringComparator instance = new ScoringComparator();

  @Override
  public int compare(Scoring o1, Scoring o2) {
    return o2.getScore() - o1.getScore();
  }
}
