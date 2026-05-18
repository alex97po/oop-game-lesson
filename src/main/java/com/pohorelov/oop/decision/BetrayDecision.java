package com.pohorelov.oop.decision;

public final class BetrayDecision implements Decision {

  private static final BetrayDecision INSTANCE = new BetrayDecision();

  public static BetrayDecision getInstance() {
    return INSTANCE;
  }

  @Override
  public Decision getOpposite() {
    return CooperateDecision.getInstance();
  }

}
