package com.pohorelov.oop.strategy;

import com.pohorelov.oop.decision.BetrayDecision;
import com.pohorelov.oop.decision.CooperateDecision;
import com.pohorelov.oop.decision.Decision;
import com.pohorelov.oop.util.RandomUtil;

public class GenerousTikForTatStrategy extends Strategy {

  @Override
  public Decision decide(Decision[] yourDecision,
                         Decision[] opponentDecisions,
                         int currentTurnIndex) {
    if (currentTurnIndex == 0) {
      return CooperateDecision.getInstance();
    }
    if (opponentDecisions[currentTurnIndex - 1] instanceof BetrayDecision) {
      if (RandomUtil.trueWithProbability(90)) {
        return BetrayDecision.getInstance();
      }
    }
    return CooperateDecision.getInstance();
  }

}
