package com.comp301.a01sushi;

public class CrabPortion extends IngredientPortions {
  private double amount;
  private Crab ingred = new Crab();

  public CrabPortion(double amount) {
    this.amount = amount;
    if (amount < 0) {
      throw new IllegalArgumentException();
    }
  }

  public Ingredient getIngredient() {
    return ingred;
  }

  @Override
  public double getAmount() {
    return amount;
  }

  @Override
  public String getName() {
    return ingred.getName();
  }

  @Override
  public boolean getIsVegetarian() {
    return ingred.getIsVegetarian();
  }

  @Override
  public boolean getIsRice() {
    return ingred.getIsRice();
  }

  @Override
  public boolean getIsShellfish() {
    return ingred.getIsShellfish();
  }

  @Override
  public double getCalories() {
    return (amount * ingred.getCaloriesPerOunce());
  }

  @Override
  public double getCost() {
    return (amount * ingred.getPricePerOunce());
  }

  public CrabPortion combine(IngredientPortion other) {
    if (!this.getName().equals(other.getName())) {
      throw new IllegalArgumentException();
    }
    this.amount = this.amount + other.getAmount();
    return this;
  }
}
