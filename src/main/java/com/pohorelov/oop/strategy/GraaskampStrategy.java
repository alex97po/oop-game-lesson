package com.pohorelov.oop.strategy;

import com.pohorelov.oop.decision.BetrayDecision;
import com.pohorelov.oop.decision.CooperateDecision;
import com.pohorelov.oop.decision.Decision;

public class GraaskampStrategy extends Strategy {

  // Same as Joss, but betrays not in 10%, but on each 50th round
  @Override
  public Decision decide(Decision[] yourDecisions, Decision[] opponentDecisions,
                         int currentTurnIndex) {
    if (currentTurnIndex == 0) {
      return CooperateDecision.getInstance();
    }
    if ((currentTurnIndex + 1) % 50 == 0) {
      return BetrayDecision.getInstance();
    }
    return opponentDecisions[currentTurnIndex-1];
  }

}
