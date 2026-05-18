package com.pohorelov.oop.noise;

import com.pohorelov.oop.decision.Decision;

public interface NoiseStrategy {

  default Decision applyNoiseIfNeeded(Decision decision) {
    if (doYouWantToChangeDecision()) {
      return decision.getOpposite();
    }
    return decision;
  }

  boolean doYouWantToChangeDecision();

}
