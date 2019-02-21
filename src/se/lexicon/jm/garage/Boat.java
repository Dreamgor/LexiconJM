package se.lexicon.jm.garage;

public class Boat extends Vehicle {
  //konstruktor och unik variabel
  private boolean sail;
  public Boat(int weight, int parkSpot, boolean sail) {
    super(weight, parkSpot);
    setSail(sail);
  }

  //getter
  public boolean isSail() {
    return sail;
  }

  //Setter


  public void setSail(boolean sail) {
    this.sail = sail;
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
