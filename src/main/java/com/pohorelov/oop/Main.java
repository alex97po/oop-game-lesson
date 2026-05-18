package com.pohorelov.oop;

import com.pohorelov.oop.end.FixedEndGameStrategy;
import com.pohorelov.oop.noise.FlexibleNoiseStrategy;
import com.pohorelov.oop.strategy.Strategy;
import com.pohorelov.oop.strategy.StrategyScanner;

public class Main {

  public static void main(String[] args) throws Exception {
    Tournament tournament = new Tournament();
//    tournament.registerParticipants(StrategyScanner.discoverStrategies());
    tournament.configureTournament(new FlexibleNoiseStrategy(), new FixedEndGameStrategy());
    Strategy[] leaderBoard = tournament.run();
    for (int i = 0; i < leaderBoard.length; i++) {
      System.out.println(i + 1 + ". " + leaderBoard[i]);
    }
  }

}
