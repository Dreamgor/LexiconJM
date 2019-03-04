package se.lexicon.jm.garage;

public interface GarageInterface<V> {

  //Parkera fordon
  int park(V vehicle);

  //hitta fordon
  V find(int parkingLot);

  //ta bort fordon
  V unpark(int parkingLot);

  //skriv ut fordon
  String toString();

}
