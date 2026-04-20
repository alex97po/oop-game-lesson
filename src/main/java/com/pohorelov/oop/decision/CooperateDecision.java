package com.pohorelov.oop.decision;

public final class CooperateDecision extends Decision {

  private static final CooperateDecision INSTANCE = new CooperateDecision();

  public static CooperateDecision getInstance() {
    return INSTANCE;
  }
;
}
