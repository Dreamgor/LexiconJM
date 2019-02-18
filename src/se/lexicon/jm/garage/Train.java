package se.lexicon.jm.garage;

public class Train extends Vehicle {

  //unik variabel och konstruktor
  private double brakeLength;
  public Train(int weight, int parkSpot, double brakeLength) {
    super(weight, parkSpot);
    this.brakeLength = brakeLength;
  }

  //getter

  public double getBrakeLength() {
    return brakeLength;
  }

  //toString

  @Override
  public String toString() {
    return super.toString() + " Bromslängd: " + brakeLength + ". ";
  }
}
