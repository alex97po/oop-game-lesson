package com.pohorelov.oop.strategy;

import com.pohorelov.oop.decision.Decision;

public interface Strategy {

  Decision decide(Decision[] yourDecision,
                  Decision[] opponentDecisions,
                  int currentTurnIndex);

}
