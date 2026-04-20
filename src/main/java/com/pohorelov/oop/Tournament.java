package com.pohorelov.oop;

import com.pohorelov.oop.decision.Decision;
import com.pohorelov.oop.strategy.Strategy;

public class Tournament {

  private static final int NUMBER_OF_GAMES = 5;
  private static final int NUMBER_OF_TURNS = 200;

  private Strategy[] participants;
  private int[][] score; //[[1, 2], [3, 4], [5, 6]]
  private double[] average; // [3, 4]

  public void registerParticipants(Strategy[] strategies) {
    if (this.participants != null) {
      System.out.println("This tournament already has registered participants! Please create a new one");
      return;
    }
    this.participants = strategies;
    this.score = new int[NUMBER_OF_GAMES][participants.length];
    this.average = new double[participants.length];
  }

  public Strategy[] run() {
    if (this.participants == null) {
      System.out.println("No participants registered for this tournament! Register participants first!");
      return new Strategy[0];
    }
    for (int i = 0; i < NUMBER_OF_GAMES; i++) {
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
        Decision[] firstDecisions = new Decision[NUMBER_OF_TURNS];
        Decision[] secondDecisions = new Decision[NUMBER_OF_TURNS];
        for (int k = 0; k < NUMBER_OF_TURNS; k++) {
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
    //TODO
    return new int[0];
  }

  /**
   * Calculate average in score array of array. Take arr[i] from each of 5 arrays,
   * calculate average and write in average[i].
   */
  private void calculateAverage() {
    // TODO
  }

  /**
   * Implement array sort of average.
   * When you switch elements in average - switch corresponding elements in participants;
   * @return
   */
  private Strategy[] sortParticipantsToLeaderBoard() {
    // TODO
    return participants;
  }

}
