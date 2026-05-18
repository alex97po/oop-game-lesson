package com.pohorelov.oop.noise;

import com.pohorelov.oop.util.RandomUtil;

public class FlexibleNoiseStrategy implements NoiseStrategy {

  @Override
  public boolean doYouWantToChangeDecision() {
    return RandomUtil.trueWithProbability(5); // true
  }

}
