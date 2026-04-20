package com.pohorelov.oop.decision;

public final class BetrayDecision extends Decision {

  private static final BetrayDecision INSTANCE = new BetrayDecision();

  public static BetrayDecision getInstance() {
    return INSTANCE;
  }

}
