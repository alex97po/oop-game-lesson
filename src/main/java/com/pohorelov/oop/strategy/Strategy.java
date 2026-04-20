package com.pohorelov.oop.strategy;

import com.pohorelov.oop.decision.Decision;

public abstract class Strategy {

  public abstract Decision decide(Decision[] yourDecision,
                                  Decision[] opponentDecisions,
                                  int currentTurnIndex);

}
