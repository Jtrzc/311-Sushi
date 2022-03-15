package com.comp301.a01sushi;

import static java.lang.Math.round;

public class Sashimi implements Sushi {

  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }

  private SashimiType type;
  private IngredientPortions Tuna = new TunaPortion(0.75);
  private IngredientPortions Yellowtail = new YellowtailPortion(0.75);
  private IngredientPortions Eel = new EelPortion(0.75);
  private IngredientPortions Crab = new CrabPortion(0.75);
  private IngredientPortions Shrimp = new ShrimpPortion(0.75);
  private IngredientPortions[] ingreds = {Tuna, Yellowtail, Eel, Crab, Shrimp};

  public Sashimi(SashimiType type) {
    this.type = type;
  }

  @Override
  public String getName() {
    for (int i = 0; i < ingreds.length; i++) {
      if (type.name().equalsIgnoreCase(ingreds[i].getName())) {
        return ingreds[i].getName() + " sashimi";
      }
    }
    return "";
  }

  @Override
  public IngredientPortion[] getIngredients() {
    IngredientPortion[] typeOf = new IngredientPortion[1];
    for (int i = 0; i < ingreds.length; i++) {
      if (type.name().equalsIgnoreCase(ingreds[i].getName())) {
        typeOf[0] = ingreds[i];
      }
    }
    return typeOf;
  }

  @Override
  public int getCalories() {

    for (int i = 0; i < ingreds.length; i++) {
      if (type.name().equalsIgnoreCase(ingreds[i].getName())) {
        return (int) round(ingreds[i].getCalories());
      }
    }
    return 0;
  }

  @Override
  public double getCost() {

    for (int i = 0; i < ingreds.length; i++) {
      if (type.name().equalsIgnoreCase(ingreds[i].getName())) {
        return ingreds[i].getCost();
      }
    }
    return 0;
  }

  @Override
  public boolean getHasRice() {

    for (int i = 0; i < ingreds.length; i++) {
      if (type.name().equalsIgnoreCase(ingreds[i].getName())) {
        return ingreds[i].getIsRice();
      }
    }
    return false;
  }

  @Override
  public boolean getHasShellfish() {

    for (int i = 0; i < ingreds.length; i++) {
      if (type.name().equalsIgnoreCase(ingreds[i].getName())) {
        return ingreds[i].getIsShellfish();
      }
    }
    return false;
  }

  @Override
  public boolean getIsVegetarian() {

    for (int i = 0; i < ingreds.length; i++) {
      if (type.name().equalsIgnoreCase(ingreds[i].getName())) {
        return ingreds[i].getIsVegetarian();
      }
    }
    return false;
  }
}
