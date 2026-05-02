package com.pohorelov.oop;

import com.pohorelov.oop.strategy.Strategy;
import com.pohorelov.oop.strategy.StrategyRegistrar;

public class Main {

  public static void main(String[] args) {
    Tournament tournament = new Tournament();
    tournament.registerParticipants(StrategyRegistrar.getStrategies());
    Strategy[] leaderBoard = tournament.run();
    for (int i = 0; i < leaderBoard.length; i++) {
      System.out.println(i + 1 + ". " + leaderBoard[i]);
    }
  }

}
