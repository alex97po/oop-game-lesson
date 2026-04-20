package com.pohorelov.oop.strategy;

import com.pohorelov.oop.decision.BetrayDecision;
import com.pohorelov.oop.decision.CooperateDecision;
import com.pohorelov.oop.decision.Decision;

public class SampleStrategy extends Strategy {

  @Override
  public Decision decide(Decision[] yourDecision,
                         Decision[] opponentDecisions,
                         int currentTurnIndex) {
    if (currentTurnIndex < 2) {
      return CooperateDecision.getInstance();
    }
    if (opponentDecisions[currentTurnIndex - 1] instanceof BetrayDecision
        && opponentDecisions[currentTurnIndex - 2] instanceof BetrayDecision) {
      return BetrayDecision.getInstance();
    }
    return CooperateDecision.getInstance();
  }

}
