package com.pohorelov.oop.strategy;

import com.pohorelov.oop.decision.CooperateDecision;
import com.pohorelov.oop.decision.Decision;

public class TikForTatStrategy extends Strategy {

  @Override
  public Decision decide(Decision[] yourDecision,
                         Decision[] opponentDecisions,
                         int currentTurnIndex) {
    if (currentTurnIndex == 0) {
      return CooperateDecision.getInstance();
    }

    return opponentDecisions[currentTurnIndex - 1];
  }

}
