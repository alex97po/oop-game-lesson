package com.pohorelov.oop.strategy;

import com.pohorelov.oop.decision.BetrayDecision;
import com.pohorelov.oop.decision.CooperateDecision;
import com.pohorelov.oop.decision.Decision;

public class FriedmanStrategy extends Strategy {

  @Override
  public Decision decide(Decision[] yourDecision,
                         Decision[] opponentDecisions,
                         int currentTurnIndex) {
    boolean opponentBetrayed = false;
    for (int i = 0; i < currentTurnIndex; i++) {
      if (opponentDecisions[i] instanceof BetrayDecision) {
        opponentBetrayed = true;
        break;
      }
    }
    if (opponentBetrayed) {
      return BetrayDecision.getInstance();
    }
    return CooperateDecision.getInstance();
  }

}
