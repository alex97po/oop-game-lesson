package com.pohorelov.oop.strategy;

import com.pohorelov.oop.decision.BetrayDecision;
import com.pohorelov.oop.decision.CooperateDecision;
import com.pohorelov.oop.decision.Decision;
import com.pohorelov.oop.util.RandomUtil;

public class JossStrategy extends Strategy {

    @Override
    public Decision decide(
            Decision[] yourDecisions,
            Decision[] opponentDecisions,
            int currentTurnIndex) {
        if (currentTurnIndex == 0) {
            return CooperateDecision.getInstance();
        }
        if (RandomUtil.trueWithProbability(10)) {
            return BetrayDecision.getInstance();
        }
        return opponentDecisions[currentTurnIndex - 1];
    }
}