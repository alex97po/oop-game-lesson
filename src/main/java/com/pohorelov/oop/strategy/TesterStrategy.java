package com.pohorelov.oop.strategy;

import com.pohorelov.oop.decision.BetrayDecision;
import com.pohorelov.oop.decision.CooperateDecision;
import com.pohorelov.oop.decision.Decision;

public class TesterStrategy extends Strategy {

  public Decision decide(Decision[] yourDecisions,
                         Decision[] opponentDecisions,
                         int currentTurnIndex) {

    if (currentTurnIndex == 0) {
      return BetrayDecision.getInstance();
    }
    if (opponentDecisions[currentTurnIndex - 1] instanceof BetrayDecision) {
      return BetrayDecision.getInstance();
    }
    if (currentTurnIndex % 2 == 0) {
      return BetrayDecision.getInstance();
    }
    return CooperateDecision.getInstance();
  }
}