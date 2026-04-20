package com.pohorelov.oop;

import com.pohorelov.oop.strategy.Strategy;
import com.pohorelov.oop.strategy.StrategyRegistrar;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Tournament tournament = new Tournament();
    tournament.registerParticipants(StrategyRegistrar.getStrategies());
    Strategy[] leaderBoard = tournament.run();
    System.out.println(Arrays.toString(leaderBoard));
  }

}
