package se.lexicon.jm.garage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Garage implements GarageInterface<Vehicle> {

  //Lista
  private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>(72);
  private Register persList = new Register();
  String tempString = "";

  public Garage(){
    vehicles = helpSetupGarage();
  }

  //parkera fordon
  public int park(Vehicle vehicle){
    int spot = vehicle.getParkSpot();
    vehicles.add(spot, vehicle);
    return spot;
  }

  //parkera fordon och lägg till hos person
  public int park(Vehicle vehicle, String namn){
    int spot = vehicle.getParkSpot();
    vehicles.add(spot, vehicle);
    Person p = null;
    for (int i = 0; i < persList.getArbetare().size(); i++) {
      if(namn.equalsIgnoreCase(persList.getArbetare().get(i).getNamn())){
        p = persList.getArbetare().get(i);
      }
    }
    p.addVehicle(vehicle);

    return spot;
  }

  //hitta fordon
  public Vehicle find(int parkingLot){
    Vehicle v = vehicles.get(parkingLot);
    return v;
  }

  //ta bort fordon
  public Vehicle unpark(int parkingLot){
    Vehicle v = vehicles.get(parkingLot);
    vehicles.remove(parkingLot);
    return v;
  }

  //skriv ut fordon
  @Override
  public String toString(){
    String resultat = "";
    for (int i = 0; i < vehicles.size(); i++) {
      if(vehicles.get(i).getParkSpot() != -2 && vehicles.get(i) != null){
        resultat += vehicles.get(i).toString();
      }

    }
    return resultat;
  }

  //getter
  public ArrayList<Vehicle> getVehicles() {
    return vehicles;
  }

  //PersonalRegister metoder
  public  void skapaKund(String namn, double lon, Scanner sc, Register reg){
    System.out.println("Vad heter personen?");
    do{
      try{
        namn = sc.nextLine();
        if(namn.equals("")){
          throw new IllegalArgumentException();
        }
      }catch(IllegalArgumentException e){
        System.out.println("Skriv inte en tom sträng.");
      }
    }while(namn.equals(""));


    System.out.println("Vad är dess lön?");
    lon = -1;
    do{
      try{
        tempString = sc.nextLine();
        lon = Double.valueOf(tempString);
        if(lon < 0){
          throw new IllegalArgumentException();
        }
      }catch(IllegalArgumentException e){
        System.out.println("Skriv in ett positivt nummer för lön.");
      }
    }while(lon < 0);

    Person tempPer = new Person(namn, lon);
    reg.addPerson(tempPer);
  }

  public  void skapaKund(String namn, double lon, Register reg){
    Person tempPer = new Person(namn, lon);
    reg.addPerson(tempPer);
  }

  public void utskrift(Register reg){
    ArrayList<Person> tempReg = reg.getArbetare();
    for (int i = 0; i < tempReg.size(); i++){
      if(tempReg.get(i).getTimLon() != -2){
        System.out.println(tempReg.get(i).toString());
      }
    }

  }

  public void taBortAnstalld(String namn, Scanner sc, Register reg){
    boolean check = false;
    System.out.println("Ange anställningsnummer: ");
    int plats = -1;
    do{
      try{
        tempString = sc.nextLine();
        plats = Integer.valueOf(tempString);
        if(plats < 0){
          throw new IllegalArgumentException();
        }
      }catch(IllegalArgumentException e){
        System.out.println("plats kan inte vara mindre än 0.");
      }
    }while(plats < 0);


    if(reg.getAnstallningsnummer(plats) == plats){
      namn = reg.getArbetare().get(plats).getNamn();
      reg.removeArbetare(plats);
      check = true;
    }
    if(check){
      System.out.println("Tog bort " + namn + ".");
    }
    else{
      System.out.println("Den personen finns inte i registret.");
    }

  }
  public void sokNamn(Scanner sc, Register reg){
    Person p = null;
    System.out.println("Ange anställningsnummer: ");
    int plats = -1;
    do{
      try{
        tempString = sc.nextLine();
        plats = Integer.valueOf(tempString);
        if(plats < 0){
          throw new IllegalArgumentException();
        }
      }catch(IllegalArgumentException e){
        System.out.println("plats kan inte vara mindre än 0.");
      }
    }while(plats < 0);

    if(reg.getAnstallningsnummer(plats) == plats){
      p = reg.getArbetare().get(plats);
    }
    if(p != null){
      System.out.println(p.toString());
    }
    else{
      System.out.println("Den personen finns inte i registret.");

    }

  }

  public void begaraManadslon(String namn, Scanner sc, Register reg){
    //sök från anställningsnummer
    double manadslon = -1;
    System.out.println("Ange anställningsnummer: ");
    int plats = -1;
    do{
      try{
        tempString = sc.nextLine();
        plats = Integer.valueOf(tempString);
        if(plats < 0){
          throw new IllegalArgumentException();
        }
      }catch(IllegalArgumentException e){
        System.out.println("plats kan inte vara mindre än 0.");
      }
    }while(plats < 0);


    System.out.println("Ange timmar som personen arbetat: ");
    int timmar = -1;
    do{
      try{
        tempString = sc.nextLine();
        timmar = Integer.valueOf(tempString);

      }catch(IllegalArgumentException e){
        System.out.println("plats kan inte vara mindre än 0.");
        sc.next();
      }
    }while(timmar <0);


    for (int i = 0; i < reg.getArbetare().size(); i++) {
      if(reg.getAnstallningsnummer(i) == plats){
        namn = reg.getArbetare().get(i).getNamn();
        manadslon = reg.getArbetare().get(i).getMånadsLon(timmar);
      }

    }
    if(manadslon >= 0){
      System.out.println(namn + "'s månadslön är: " + manadslon + ".");
    }
    else{
      System.out.println("Den personen finns inte i registret.");
    }
  }

  public void repeteraAlternativ(){
    System.out.println("Skriv in 1 för att registrera person, 2 för en utskrift av samtliga arbetare, 3 för att ta bort anställd.");
    System.out.println("4 för att begära uppskattad månadslön, 5 för att söka från anställningsnummer, 6 för att repetera alternativ.");
    System.out.println("7 för att avsluta programmet.");
  }
  public boolean avsluta(){
    System.out.println("Avslutar programmet.");
    return false;
  }

  public void felmeddelande(){
   throw new IllegalArgumentException("Skriv ett nummer mellan 1-7.");
  }

  public Register getPersList() {
    return persList;
  }

  public ArrayList<Vehicle> helpSetupGarage(){
    //fyll listan för inga indexoutofbounds exception
    ArrayList<Vehicle> tempList = new ArrayList<>(72);
    for (int i = 0; i < 72; i++) {
      tempList.add(new Car(-2, -2, -2));
    }
    return tempList;
  }
}
