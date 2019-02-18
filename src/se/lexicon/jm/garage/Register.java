package se.lexicon.jm.garage;

import java.util.ArrayList;

public class Register {

  private ArrayList<Person> arbetare = new ArrayList<Person>(10);


  public Register(){
    //fyll listan för inga indexoutofbounds exception
    for (int i = 0; i < 10; i++) {
      arbetare.add(i, new Person("", -2));
    }
    //System.out.println(this.toString());
  }

  public void addPerson(Person p){
    boolean check = false;
    for (int i = 0; i < arbetare.size(); i++) {

      if(arbetare.get(i).getTimLon() == -2 || arbetare.get(i) == null){
        arbetare.add(i, p);
        check = true;
        i = arbetare.size();
      }
    }
    if(!check){
      arbetare.add(p);
    }

  }

  public ArrayList<Person> getArbetare() {
    return arbetare;
  }
  public void removeArbetare(int plats){
    arbetare.remove(plats);
  }

  @Override
  public String toString() {
    String tempString = "";
    for (int i = 0; i < arbetare.size(); i++) {
      tempString += "Person: " + arbetare.get(i).toString() + ". ";
    }
    return tempString;
  }
}
