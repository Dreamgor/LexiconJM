package se.lexicon.jm.garage;

public class Car extends Vehicle {

  //konstruktor och unik variabel
  private double fuelEfficency;
  public Car(int weight, int parkSpot, double fuelEfficency) {
    super(weight, parkSpot);
    setFuelEfficency(fuelEfficency);
  }

  public double getFuelEfficency() {
    return fuelEfficency;
  }

  //Setter

  public void setFuelEfficency(double fuelEfficency) {
    try{
      if(fuelEfficency < 0 && fuelEfficency != -2){
        throw new IllegalArgumentException();
      }
      this.fuelEfficency = fuelEfficency;
    }catch(IllegalArgumentException e){
      System.out.println("Bränsleeffektivitet kan inte vara under 0.");
    }

  }


  //toString

  @Override
  public String toString() {
    return super.toString() + " Bränsleeffektivitet: " + fuelEfficency + ". ";
  }
}
