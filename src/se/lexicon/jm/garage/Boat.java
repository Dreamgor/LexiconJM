package se.lexicon.jm.garage;

public class Boat extends Vehicle {
  //konstruktor och unik variabel
  private boolean sail;
  public Boat(int weight, int parkSpot, boolean sail) {
    super(weight, parkSpot);
    this.sail = sail;
  }

  //getter
  public boolean isSail() {
    return sail;
  }

  //toString
  @Override
  public String toString() {
    if (sail) {
      return super.toString() + " Segelbåt.";
    }
    else {
      return super.toString() + " Motorbåt.";
    }
  }
}
