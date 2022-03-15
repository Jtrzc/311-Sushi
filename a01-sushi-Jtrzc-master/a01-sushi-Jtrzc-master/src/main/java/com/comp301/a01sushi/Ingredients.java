package com.comp301.a01sushi;

public class Ingredients implements Ingredient {

  private String name;
  private double pricePerOunce;
  private int caloriesPerOunce;
  private boolean isVegetarian;
  private boolean hasRice;
  private boolean hasShellfish;

  public Ingredients(
      String _name,
      double _pricePerOunce,
      int _caloriesPerOunce,
      boolean _isVegetarian,
      boolean _hasRice,
      boolean _hasShellfish) {
    name = _name;
    pricePerOunce = _pricePerOunce;
    caloriesPerOunce = _caloriesPerOunce;
    isVegetarian = _isVegetarian;
    hasRice = _hasRice;
    hasShellfish = _hasShellfish;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getCaloriesPerDollar() {
    return (caloriesPerOunce / pricePerOunce);
  }

  @Override
  public int getCaloriesPerOunce() {
    return caloriesPerOunce;
  }

  @Override
  public double getPricePerOunce() {
    return pricePerOunce;
  }

  @Override
  public boolean getIsVegetarian() {
    return isVegetarian;
  }

  @Override
  public boolean getIsRice() {
    return hasRice;
  }

  @Override
  public boolean getIsShellfish() {
    return hasShellfish;
  }

  @Override
  public boolean equals(Ingredient other) {
    if (!this.getName().equals(other.getName())) {
      return false;
    } else {
      return true;
    }
  }
}
