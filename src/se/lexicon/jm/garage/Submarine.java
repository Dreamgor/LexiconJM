package se.lexicon.jm.garage;

public class Submarine extends Vehicle {

  //unik variabel och konstruktor
  private int depth;

  public Submarine(int weight, int parkSpot, int depth) {
    super(weight, parkSpot);
    this.depth = depth;
  }

  //getter

  public int getDepth() {
    return depth;
  }

  //toString

  @Override
  public String toString() {
    return super.toString() + " Djup: " + depth + ". ";
  }
}
