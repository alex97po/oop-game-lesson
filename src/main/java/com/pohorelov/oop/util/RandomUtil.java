package com.pohorelov.oop.util;

import java.util.Random;

public class RandomUtil {

  private static final Random RANDOM = new Random();

  public static boolean trueWithProbability(int probability) {
    checkProbabilityBoundaries(probability);
    final int number = RANDOM.nextInt(100) + 1;
    return number <= probability;
  }

  public static boolean trueWithProbability(double probability) {
    checkProbabilityBoundaries(probability);
    final double number = RANDOM.nextDouble(100.0) + 0.001;
    return number <= probability;
  }

  private static void checkProbabilityBoundaries(int probability) {
    if (probability < 0 || probability > 100) {
      System.out.println("WARNING: Probability should be between 0 and 100 (%)!");
    }
  }

  private static void checkProbabilityBoundaries(double probability) {
    if (probability < 0.0 || probability > 100.0) {
      System.out.println("WARNING: Probability should be between 0 and 100 (%)!");
    }
  }

}
