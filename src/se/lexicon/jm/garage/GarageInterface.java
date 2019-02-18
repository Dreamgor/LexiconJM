package se.lexicon.jm.garage;

public interface GarageInterface {

  //Parkera fordon
  int park(Vehicle vehicle);

  //hitta fordon
  Vehicle find(int parkingLot);

  //ta bort fordon
  Vehicle unpark(int parkingLot);

  //skriv ut fordon
  String toString();

}
