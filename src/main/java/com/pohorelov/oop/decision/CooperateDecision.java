package com.pohorelov.oop.decision;

public final class CooperateDecision implements Decision {

  private static final CooperateDecision INSTANCE = new CooperateDecision();

  public static CooperateDecision getInstance() {
    return INSTANCE;
  }

  @Override
  public Decision getOpposite() {
    return BetrayDecision.getInstance();
  }

  ;
}
