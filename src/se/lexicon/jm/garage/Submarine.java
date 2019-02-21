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

  //setter
  public void setDepth(int depth){
    try{
      if(depth < 0)
        throw new IllegalArgumentException();

      this.depth = depth;
    }catch(IllegalArgumentException e){
      System.out.println("The depth of a submarine cannot be below 0");
    }


  }

  //toString

  @Override
  public String toString() {
    return super.toString() + " Djup: " + depth + ". ";
  }
}
