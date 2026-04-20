package com.pohorelov.oop.strategy;

import com.pohorelov.oop.decision.BetrayDecision;
import com.pohorelov.oop.decision.CooperateDecision;
import com.pohorelov.oop.decision.Decision;

public class JossStrategy extends Strategy {

    @Override
    public Decision decide(
            Decision[] yourDecisions,
            Decision[] opponentDecisions,
            int currentTurnIndex) {

        if (currentTurnIndex == 0) {
            return CooperateDecision.getInstance();
        }

        if (opponentDecisions[currentTurnIndex - 1] instanceof BetrayDecision) {
            if (Math.random() < 0.1) {
                return CooperateDecision.getInstance();
            }

            return BetrayDecision.getInstance();
        }

        return CooperateDecision.getInstance();
    }
}