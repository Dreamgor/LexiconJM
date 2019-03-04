package se.lexicon.jm.garage;

public class Train extends Vehicle {

  //unik variabel och konstruktor
  private double brakeLength;
  public Train(int weight, int parkSpot, double brakeLength) {
    super(weight, parkSpot);
    setBrakeLength(brakeLength);
  }

  //getter

  public double getBrakeLength() {
    return brakeLength;
  }

  //Setter

  public void setBrakeLength(double brakeLength) {
    if (brakeLength < 0 && brakeLength != -2) {
      throw new IllegalArgumentException("Den får inte vara mindre än 0.");
    }
    this.brakeLength = brakeLength;

  }


  //toString

  @Override
  public String toString() {
    return super.toString() + " Bromslängd: " + brakeLength + ". ";
  }
}
