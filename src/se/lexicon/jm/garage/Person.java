package se.lexicon.jm.garage;

import java.util.ArrayList;

public class Person {
  private String namn;
  private double timLon;
  private ArrayList<Vehicle> vehicles = new ArrayList<>();

  public Person(String nyNamn, double nyLön){
    namn = nyNamn;
    timLon = nyLön;
    this.vehicles = this.helpSetupEachPerson();
  }

  public String getNamn() {
    return namn;
  }

  public double getTimLon() {
    return timLon;
  }

  public double getMånadsLon(int timmar){
    return timmar * timLon;
  }

  public void addVehicle(Vehicle v) {
    boolean check = false;
    for(int i = 0; i < vehicles.size(); i++){
      if(vehicles.get(i).getParkSpot() == -2 || vehicles.get(i).equals(null)){
        vehicles.set(i, v);
        check = true;
        i = vehicles.size();
      }
    }
    if(!check){
      vehicles.add(v);
    }
  }

  public ArrayList<Vehicle> getVehicles() {
    return vehicles;
  }

  @Override
  public String toString() {
    String vehicleList = "";
    for(int i = 0; i < vehicles.size(); i++){
      if(vehicles.get(i) == null || vehicles.get(i).getParkSpot() == -2){
        vehicleList += vehicles.get(i).toString();
      }

    }
    return "Namn: " + namn + ". timLön: " + timLon +
            ". Vehicles: " + vehicleList + ". ";
  }

  public ArrayList<Vehicle> helpSetupEachPerson(){
    //fyll listan för inga indexoutofbounds exception
    ArrayList<Vehicle> tempList = new ArrayList<>(10);
    for (int i = 0; i < 10; i++) {
      tempList.add(new Car(-2, -2, -2));
    }
    return tempList;
  }
}
