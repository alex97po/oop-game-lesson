package com.pohorelov.oop.end;

public class FixedEndGameStrategy implements EndGameStrategy {

  private static final int NUMBER_OF_TURNS = 200;

  @Override
  public int getNumberOfGames() {
    return NUMBER_OF_TURNS;
  }
}
