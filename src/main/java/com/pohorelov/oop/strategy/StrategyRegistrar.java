package com.pohorelov.oop.strategy;

public class StrategyRegistrar {

  private static final Strategy[] STRATEGIES = new Strategy[] {
      new SampleStrategy(),
      new GenerousTikForTatStrategy(),
      new FriedmanStrategy(),
      new GraaskampStrategy(),
      new TikForTatStrategy()
  };

  public static Strategy[] getStrategies() {
    return STRATEGIES;
  }

}
