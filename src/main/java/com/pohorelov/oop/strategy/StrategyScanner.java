package com.pohorelov.oop.strategy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class StrategyScanner {

  public static Strategy[] discoverStrategies() {
    try {
      String packageName = Strategy.class.getPackage().getName();
      Path[] files = Files.list(Paths.get(Strategy.class.getResource("").toURI())).toArray(Path[]::new);

      Strategy[] strategies = new Strategy[files.length];
      int count = 0;
      for (Path file : files) {
        String simpleName = file.getFileName().toString().replace(".class", "");
        Class<?> clazz = Class.forName(packageName + '.' + simpleName);
        if (Strategy.class.isAssignableFrom(clazz) && !clazz.isInterface()) {
          strategies[count++] = (Strategy) clazz.getDeclaredConstructor().newInstance();
        }
      }

      return Arrays.copyOf(strategies, count);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
