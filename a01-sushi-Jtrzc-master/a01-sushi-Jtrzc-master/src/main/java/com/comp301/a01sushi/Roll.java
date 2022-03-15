package com.comp301.a01sushi;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Roll implements Sushi {

  private String name;
  private IngredientPortion[] roll_ingrdients;
  private boolean riceChecker = false;
  private double seaweedChecker = 0;
  private ArrayList<IngredientPortion> repeats = new ArrayList<IngredientPortion>();

  public Roll(String name, IngredientPortion[] roll_ingredients) {
    this.name = name;
    roll_ingrdients = roll_ingredients.clone();
    repeats = new ArrayList<>(Arrays.asList(roll_ingrdients));
    if (roll_ingredients == null) {
      throw new IllegalArgumentException();
    }

    for (int i = 0; i < roll_ingrdients.length; i++) {
      if (roll_ingrdients[i].getName().equals("rice")) {
        riceChecker = true;
      }
      if (roll_ingrdients[i].getName().equals("seaweed")) {
        seaweedChecker = seaweedChecker + roll_ingrdients[i].getAmount();
      }

      if (roll_ingrdients[i] == null) {
        throw new IllegalArgumentException();
      }
    }

    for (int i = 0; i < repeats.size(); i++) {
      for (int j = 1; j < repeats.size(); j++) {
        if (repeats.get(i).getName().equals(repeats.get(j).getName()) && (i != j)) {
          repeats.get(j).combine(repeats.get(i));
          repeats.remove(i);
        }
      }
    }

    if (seaweedChecker == 0) {
      repeats.add(repeats.size(), new SeaweedPortion(.1));
    }
    if (seaweedChecker > 0 && (seaweedChecker < .10)) {
      repeats.add(repeats.size(), new SeaweedPortion(.1 - seaweedChecker));
    }

    roll_ingrdients = repeats.toArray(new IngredientPortion[0]);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return roll_ingrdients;
  }

  @Override
  public int getCalories() {
    double cals = 0;
    for (int i = 0; i < roll_ingrdients.length; i++) {
      cals = cals + roll_ingrdients[i].getCalories();
    }

    return (int) (Math.round(cals));
  }

  @Override
  public double getCost() {
    double cost = 0;
    for (int i = 0; i < roll_ingrdients.length; i++) {
      cost = cost + roll_ingrdients[i].getCost();
    }
    cost = Math.round(cost * 100.0) / 100.0;
    return cost;
  }

  @Override
  public boolean getHasRice() {
    return riceChecker;
  }

  @Override
  public boolean getHasShellfish() {
    return false;
  }

  @Override
  public boolean getIsVegetarian() {
    return false;
  }
}
