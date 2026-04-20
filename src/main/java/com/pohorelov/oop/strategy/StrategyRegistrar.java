package com.pohorelov.oop.strategy;

public class StrategyRegistrar {

  private static final Strategy[] STRATEGIES = new Strategy[] {
      new SampleStrategy(),
      new GenerousTikForTatStrategy()
  };

  public static Strategy[] getStrategies() {
    return STRATEGIES;
  }

}
