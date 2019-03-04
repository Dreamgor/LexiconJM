package se.lexicon.jm.garage;

public class Aeroplane extends Vehicle {
  //konstruktor och unik variabel
  private int maxHeight;
  public Aeroplane(int weight, int parkSpot, int maxHeight) {
    super(weight, parkSpot);
    setMaxHeight(maxHeight);
  }

  //getter
  public int getMaxHeight() {
    return maxHeight;
  }

  //Setter

  public void setMaxHeight(int maxHeight) {
    try{
      if(maxHeight < 0){
        throw new IllegalArgumentException();
      }
      this.maxHeight = maxHeight;
    }catch(IllegalArgumentException e){
      System.out.println("Maxhöjd kan inte vara under 0.");
    }

  }

  //toString
  @Override
  public String toString() {
    return super.toString() + " Maxhöjd: " + maxHeight + ". ";
  }
}
