package se.lexicon.jm.garage;

public class Aeroplane extends Vehicle {
  //konstruktor och unik variabel
  private int maxHeight;
  public Aeroplane(int weight, int parkSpot, int maxHeight) {
    super(weight, parkSpot);
    this.maxHeight = maxHeight;
  }

  //getter
  public int getMaxHeight() {
    return maxHeight;
  }

  //Setter

  public void setMaxHeight(int maxHeight) {
    if(maxHeight < 0){
      throw new IllegalArgumentException("Maxhöjd kan inte vara under 0.");
    }
    else{
      this.maxHeight = maxHeight;
    }
  }

  //toString
  @Override
  public String toString() {
    return super.toString() + " Maxhöjd: " + maxHeight + ". ";
  }
}
