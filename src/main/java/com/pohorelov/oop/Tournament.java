package com.pohorelov.oop;

import com.pohorelov.oop.decision.BetrayDecision;
import com.pohorelov.oop.decision.CooperateDecision;
import com.pohorelov.oop.decision.Decision;
import com.pohorelov.oop.end.EndGameStrategy;
import com.pohorelov.oop.noise.NoiseStrategy;
import com.pohorelov.oop.strategy.Strategy;
import com.pohorelov.oop.strategy.StrategyScanner;

public class Tournament {

  private Strategy[] participants;
  private int[][] score; //[[1, 2], [3, 4], [5, 6]]
  private double[] average; // [3, 4]

  private int numberOfGames;

  private NoiseStrategy noiseStrategy;
  private EndGameStrategy endGameStrategy;

  public void configureTournament(NoiseStrategy noiseStrategy,
                                  EndGameStrategy endGameStrategy) {
    if (this.noiseStrategy != null) {
      System.out.println("Noise strategy is already configured for this tournament! Please create a new one");
      return;
    }
    this.noiseStrategy = noiseStrategy;
    if (this.endGameStrategy != null) {
      System.out.println("End game strategy is already configured for this tournament! Please create a new one");
      return;
    }
    this.endGameStrategy = endGameStrategy;

    registerParticipants();
  }

  private void registerParticipants() {
    if (this.participants != null) {
      System.out.println("This tournament already has registered participants! Please create a new one");
      return;
    }
    this.numberOfGames = endGameStrategy.getNumberOfGames();
    this.participants = StrategyScanner.discoverStrategies();
    this.score = new int[numberOfGames][participants.length];
    this.average = new double[participants.length];
  }

  public Strategy[] run() {
    if (this.participants == null) {
      System.out.println("No participants registered for this tournament! Register participants first!");
      return new Strategy[0];
    }
    if (this.noiseStrategy == null) {
      System.out.println("Noise strategy is not defined! Register configure the tournament first!");
      return new Strategy[0];
    }
    if (this.endGameStrategy == null) {
      System.out.println("End game strategy is not defined! Register configure the tournament first!");
      return new Strategy[0];
    }
    for (int i = 0; i < numberOfGames; i++) {
      runGame(score[i]);
    }
    calculateAverage();
    return sortParticipantsToLeaderBoard();
  }

  private void runGame(int[] currentScore) {
    for (int i = 0; i < participants.length; i++) {
      for (int j = i; j < participants.length; j++) {
        Strategy first = participants[i];
        Strategy second = participants[j];
        Decision[] firstDecisions = new Decision[numberOfGames];
        Decision[] secondDecisions = new Decision[numberOfGames];
        for (int k = 0; k < numberOfGames; k++) {
          runTurn(first, second, firstDecisions, secondDecisions, k, i, j, currentScore);
        }
      }
    }
  }

  private void runTurn(Strategy first,
                       Strategy second,
                       Decision[] firstDecisions,
                       Decision[] secondDecisions,
                       int currentTurnIndex,
                       int firstIndex,
                       int secondIndex,
                       int[] currentScore) {
    Decision firstCurrentDecision = first.decide(firstDecisions, secondDecisions, currentTurnIndex);
    Decision secondCurrentDecision = second.decide(secondDecisions, firstDecisions, currentTurnIndex);

    // NOISE STRATEGY MUST WORK HERE!!!!
    firstCurrentDecision = noiseStrategy.applyNoiseIfNeeded(firstCurrentDecision); // noNoiseStrategy
    secondCurrentDecision = noiseStrategy.applyNoiseIfNeeded(secondCurrentDecision);

    firstDecisions[currentTurnIndex] = firstCurrentDecision;
    secondDecisions[currentTurnIndex] = secondCurrentDecision;
    int[] turnOutcome = calculateTurnOutcome(firstCurrentDecision, secondCurrentDecision);
    currentScore[firstIndex] += turnOutcome[0];
    currentScore[secondIndex] += turnOutcome[1];
  }

  /**
   * Return int array with 2 elements: [3,3], [0,5], [5,0], [1,1]
   * @param first
   * @param second
   * @return
   */
  private int[] calculateTurnOutcome(Decision first, Decision second) {
    if (first instanceof CooperateDecision && second instanceof CooperateDecision) {
      return new int[]{3, 3};
    }

    if (first instanceof CooperateDecision && second instanceof BetrayDecision) {
      return new int[]{0, 5};
    }

    if (first instanceof BetrayDecision && second instanceof CooperateDecision) {
      return new int[]{5, 0};
    }

    return new int[]{1, 1};
  }

  /**
   * Calculate average in score array of array. Take arr[i] from each of 5 arrays,
   * calculate average and write in average[i].
   */
  private void calculateAverage() {
    for (int i = 0; i < participants.length; i++) {
      int sum = 0;
      for (int j = 0; j < numberOfGames; j++) {
        sum += score[j][i];
      }
      average[i] = (double) sum / numberOfGames;
    }
  }

  /**
   * Implement array sort of average.
   * When you switch elements in average - switch corresponding elements in participants;
   * @return
   */
  private Strategy[] sortParticipantsToLeaderBoard() {
    int n = average.length;

    // Зовнішній цикл проходить по всьому масиву
    for (int i = 0; i < n - 1; i++) {
      // Внутрішній цикл порівнює сусідні елементи
      for (int j = 0; j < n - i - 1; j++) {
        // Якщо поточний бал менший за наступний — міняємо їх місцями (спадний порядок)
        if (average[j] < average[j + 1]) {

          // 1. Міняємо місцями бали в масиві scores
          double tempScore = average[j];
          average[j] = average[j + 1];
          average[j + 1] = tempScore;

          // 2. КРИТИЧНО: Міняємо місцями стратегії в масиві participants за тими ж індексами
          Strategy tempStrategy = participants[j];
          participants[j] = participants[j + 1];
          participants[j + 1] = tempStrategy;
        }
      }
    }
    return participants;
  }

}
