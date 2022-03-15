package com.comp301.a01sushi;

import java.io.*;

import static java.lang.Math.round;

public class Nigiri implements Sushi {

  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }

  private NigiriType type;
  private IngredientPortions Tuna = new TunaPortion(0.75);
  private IngredientPortions Yellowtail = new YellowtailPortion(0.75);
  private IngredientPortions Eel = new EelPortion(0.75);
  private IngredientPortions Crab = new CrabPortion(0.75);
  private IngredientPortions Shrimp = new ShrimpPortion(0.75);
  private IngredientPortions[] ingreds = {Tuna, Yellowtail, Eel, Crab, Shrimp};

  public Nigiri(NigiriType type) {
    this.type = type;
  }

  @Override
  public String getName() {
    for (int i = 0; i < ingreds.length; i++) {
      if (type.name().equalsIgnoreCase(ingreds[i].getName())) {
        return ingreds[i].getName() + " nigiri";
      }
    }
    return "";
  }

  @Override
  public IngredientPortion[] getIngredients() {
    IngredientPortion[] typeOf = new IngredientPortion[2];
    typeOf[0] = new RicePortion(.50);
    for (int i = 0; i < ingreds.length; i++) {
      if (type.name().equalsIgnoreCase(ingreds[i].getName())) {
        typeOf[1] = ingreds[i];
      }
    }
    return typeOf;
  }

  @Override
  public int getCalories() {

    for (int i = 0; i < ingreds.length; i++) {
      if (type.name().equalsIgnoreCase(ingreds[i].getName())) {
        return (int) round(ingreds[i].getCalories() + new RicePortion(.50).getCalories());
      }
    }
    return 0;
  }

  @Override
  public double getCost() {

    for (int i = 0; i < ingreds.length; i++) {
      if (type.name().equalsIgnoreCase(ingreds[i].getName())) {
        return (ingreds[i].getCost() + new RicePortion(.50).getCost());
      }
    }
    return 0;
  }

  @Override
  public boolean getHasRice() {

    return true;
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
