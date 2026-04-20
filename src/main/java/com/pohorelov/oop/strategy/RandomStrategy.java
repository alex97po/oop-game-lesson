package com.pohorelov.oop.strategy;

import com.pohorelov.oop.decision.BetrayDecision;
import com.pohorelov.oop.decision.CooperateDecision;
import com.pohorelov.oop.decision.Decision;
import com.pohorelov.oop.util.RandomUtil;

public class RandomStrategy  extends Strategy {

  @Override
  public Decision decide(Decision[] yourDecision,
                         Decision[] opponentDecisions,
                         int currentTurnIndex) {
    if (RandomUtil.trueWithProbability(50)) {
      return CooperateDecision.getInstance();
    }
    return BetrayDecision.getInstance();
  }

}
