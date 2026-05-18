package com.pohorelov.oop.end;

import com.pohorelov.oop.util.RandomUtil;

public class FlexibleEndGameStrategy implements EndGameStrategy {

  private static final double GAME_END_PROBABILITY = 0.346;

  @Override
  public int getNumberOfGames() {
    int numberOfTurns = 1;
    while (!RandomUtil.trueWithProbability(GAME_END_PROBABILITY)) {
      numberOfTurns++;
    }
    return numberOfTurns;
  }
}
