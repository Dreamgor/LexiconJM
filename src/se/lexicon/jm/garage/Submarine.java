package se.lexicon.jm.garage;

public class Submarine extends Vehicle {

  //unik variabel och konstruktor
  private int depth;

  public Submarine(int weight, int parkSpot, int depth) {
    super(weight, parkSpot);
    setDepth(depth);
  }

  //getter

  public int getDepth() {
    return depth;
  }

  //toString

  public void setDepth(int depth){
    if(depth < 0)
      throw new IllegalArgumentException("The depth of a submarine cannot be below 0");

    else this.depth = depth;

  }

  @Override
  public String toString() {
    return super.toString() + " Djup: " + depth + ". ";
  }
}
