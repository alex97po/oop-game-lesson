package com.pohorelov.oop.decision;

public sealed interface Decision permits BetrayDecision, CooperateDecision {

  Decision getOpposite();

}
