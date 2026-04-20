package com.pohorelov.oop.strategy;

public class StrategyRegistrar {

  private static final Strategy[] STRATEGIES = new Strategy[] {
      new SampleStrategy(),
      new GenerousTikForTatStrategy()
      new TikForTatStrategy()
  };

  public static Strategy[] getStrategies() {
    return STRATEGIES;
  }

}
