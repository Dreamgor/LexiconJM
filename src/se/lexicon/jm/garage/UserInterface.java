package se.lexicon.jm.garage;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

  private Garage garage;
  String tempString = "";

  public UserInterface(Garage garage){
    this.garage = new Garage();
  }

  //input output loop här
  public void runMenu(){
    Scanner sc = new Scanner(System.in);
    String val, fordon = "";
    String namn = "";
    Vehicle v = null;
    int spot, weight, success = 0;
    double lon = 0;
    Register reg = garage.getPersList();

    boolean keepLooping = true;
    System.out.println("Välkommen till den Glada Grannens Garage!");

    while(keepLooping){
      System.out.println("Vad vill du göra?");
      System.out.println("1: Öppna garaget. 2: Administrera personal. Q: Avsluta.");
      val = sc.nextLine();

      if(val.equals("1")){
        System.out.println("1: Parkera ett fordon. 2: Leta efter ett fordon. 3: Hämta ett fordon." +
                "4. Visa all fordon.");
        val = sc.nextLine();

        if(val.equals("1")){
          //Parkera fordon och kolla kund
          System.out.println("Vad heter kunden?");
          namn = sc.nextLine();
          boolean kundExisterar = false;
          ArrayList<Person> tempReg = reg.getArbetare();
          if(tempReg.size() != 0){
            for (int i = 0; i < tempReg.size(); i++) {
              if(tempReg.get(i).getNamn().equalsIgnoreCase(namn)){
                kundExisterar = true;
              }

            }

          }

          if(kundExisterar){
            System.out.println("Vad för typ av fordon ska parkeras?");
            fordon = sc.nextLine();
            System.out.println("Hur mycket väger det?");
            tempString = sc.nextLine();
            weight = Integer.valueOf(tempString);
            success = this.parkVehicle(namn, fordon, weight, sc);
            if(success >= 0){
              System.out.println("Fordonet har blivit parkerat. ditt nummer är: " + success + ".");
            }
            else{
              System.out.println("Inget sådant fordon existerar.");
            }
          }
          else{
            System.out.println("Skapar kund. Vad är dess lön?");
            tempString = sc.nextLine();
            lon = Double.valueOf(tempString);
            if(lon >= 0){
              garage.skapaKund(namn, lon, reg);
              System.out.println("Vad för typ av fordon ska parkeras?");
              fordon = sc.nextLine();
              System.out.println("Hur mycket väger det?");
              tempString = sc.nextLine();
              weight = Integer.valueOf(tempString);
              success = this.parkVehicle(namn, fordon, weight, sc);
              if(success >= 0){
                System.out.println("Fordonet har blivit parkerat. ditt nummer är: " + success + ".");
              }
              else{
                System.out.println("Inget sådant fordon existerar.");
              }
            }
            else{
              System.out.println("Skriv in ett positivt nummer för lön.");
            }
          }

        }
        else if(val.equals("2")){
          //Leta efter ett fordon
          System.out.println("Vilken plats är ditt fordon?");
          tempString = sc.nextLine();
          spot = sc.nextInt();
          success = this.findVehicle(spot);
          if(success >= 0){
            System.out.println("Det finns ett fordon där.");
          }
          else{
            System.out.println("Inget fordon existerar på den platsen.");
          }
        }
        else if(val.equals("3")){
          //Hämta ett fordon
          System.out.println("Vilken plats är ditt fordon?");
          tempString = sc.nextLine();
          spot = Integer.valueOf(tempString);
          v = this.getTheVehicle(spot);
          if(v != null){
            System.out.println(v.toString());
          }
          else{
            System.out.println("Inget fordon existerar på den platsen.");
          }
        }
        else if(val.equals("4")){
          //Visa alla fordon
          System.out.println(this.showAllVehiclesInGarage());
        }
        else if(val.equals("5")){
          //remove fordon
          System.out.println("Vilken plats är ditt fordon?");
          tempString = sc.nextLine();
          spot = Integer.valueOf(tempString);
          success = this.unparkVehicle(spot);
          if(success < 0){
            System.out.println("Inget fordon existerar på den platsen.");
          }
          else{
            System.out.println("Tog bort fordonet på plats: " + spot + ".");
          }
        }
        //felmeddelande
        else{
          System.out.println("Skriv ett nummer mellan 1 och 5.");
        }

      }
      else if(val.equals("2")){
        System.out.println("Detta är ett personregister.");
        System.out.println("Skriv in 1 för att registrera person, 2 för en utskrift av samtliga arbetare, 3 för att ta bort anställd.");
        System.out.println("4 för att begära uppskattad månadslön, 5 för att söka från anställningsnummer, 6 för att repetera alternativ.");
        System.out.println("7 för att avsluta programmet.");
        boolean fortsätt = true;
        while(fortsätt) {
          System.out.println("Skriv in 6 för att repetera alternativ.");
          val = sc.nextLine();

          if (val.equals("1")) {
            garage.skapaKund(namn, lon, sc, reg);
          } else if (val.equals("2")) {
            garage.utskrift(reg);
          } else if (val.equals("3")) {
            garage.taBortAnstalld(namn, sc, reg);

          } else if (val.equals("4")) {
            garage.sokNamn(sc, reg);

          } else if (val.equals("5")) {
            garage.begaraManadslon(namn, sc, reg);

          } else if (val.equals("6")) {
            garage.repeteraAlternativ();

          } else if (val.equals("7")) {
            fortsätt = garage.avsluta();
          }
          else {
            garage.felmeddelande();
          }
        }
      }
      //Avsluta programmet
      else if(val.equalsIgnoreCase("Q")){
        System.out.println("Programmet avslutas.");
        keepLooping = false;
      }
      //felmeddelande
      else{
        System.out.println("Skriv 1, 2 eller Q.");
      }
    }
    sc.close();
  }

  public int parkVehicle(String namn, String fordon, int weight, Scanner sc){
    //Lägg till flyg
    if(fordon.equalsIgnoreCase("Aeroplane")){
      System.out.println("Vad för maxhöjd klarar flyget?");
      tempString = sc.nextLine();
      int maxHeight = Integer.valueOf(tempString);
      if(maxHeight < 0){
        System.out.println("Skriv in ett positivt nummer för höjd.");
        return -1;
      }
      int spot = 0;
      ArrayList<Vehicle> vehicles = garage.getVehicles();
      for(int i = 0; i < 12; i++){
        if(vehicles.get(i) == null || vehicles.get(i).getParkSpot() != -2){
          spot = i;
          i = vehicles.size();
        }
      }
      Aeroplane aero = new Aeroplane(weight, spot, maxHeight);
      int result = garage.park(aero, namn);
      return result;
    }
    //add other vehicles
    if(fordon.equalsIgnoreCase("Boat")){
      //Lägg till båt
      boolean sail = false;
      boolean noProblem = true;
      System.out.println("Segel eller motorbåt?");
      if(sc.nextLine().equalsIgnoreCase("Segel")){
        sail = true;
      }
      else if(sc.nextLine().equalsIgnoreCase("Motor")){
        sail = false;
      }
      else{
        noProblem = false;
      }
      if(noProblem){
        int spot = 0;
        ArrayList<Vehicle> vehicles = garage.getVehicles();
        for(int i = 12; i < 30; i++){
          if(vehicles.get(i) == null || vehicles.get(i).getParkSpot() != -2){
            spot = i;
            i = vehicles.size();
          }
        }
        Boat boat = new Boat(weight, spot, sail);
        int result = garage.park(boat, namn);
        return result;
      }
      else{
        return -1;
      }
    }
    if(fordon.equalsIgnoreCase("Car")){
      //Lägg till båt
      System.out.println("Hur mycket bränsle drar bilen?");
      tempString = sc.nextLine();
      double fuelEfficency = Double.valueOf(tempString);
      if(fuelEfficency < 0){
        System.out.println("Skriv in ett positivt nummer för bränsle.");
        return -1;
      }
      int spot = 0;
      ArrayList<Vehicle> vehicles = garage.getVehicles();
      for(int i = 30; i < 60; i++){
        if(vehicles.get(i) == null || vehicles.get(i).getParkSpot() != -2){
          spot = i;
          i = vehicles.size();
        }
      }
      Car car = new Car(weight, spot, fuelEfficency);
      int result = garage.park(car, namn);
      return result;
    }
    //Lägg till ubåt
    if(fordon.equalsIgnoreCase("Submarine")){

      System.out.println("Hur djupt kan ubåten gå?");
      tempString = sc.nextLine();
      int depth = Integer.valueOf(tempString);
      if(depth < 0){
        System.out.println("Skriv in ett positivt nummer för höjd.");
        return -1;
      }
      int spot = 0;
      ArrayList<Vehicle> vehicles = garage.getVehicles();
      for(int i = 60; i < 66; i++){
        if(vehicles.get(i) == null || vehicles.get(i).getParkSpot() != -2){
          spot = i;
          i = vehicles.size();
        }
      }
      Submarine sub = new Submarine(weight, spot, depth);
      int result = garage.park(sub, namn);
      return result;
    }
    if(fordon.equalsIgnoreCase("Train")){
      //Lägg till tåg
      System.out.println("Hur många meter tar det för tåget att stanna?");
      tempString = sc.nextLine();
      double brakeLength = Double.valueOf(tempString);
      if(brakeLength < 0){
        System.out.println("Skriv in ett positivt nummer för bromslängd.");
        return -1;
      }
      int spot = 0;
      ArrayList<Vehicle> vehicles = garage.getVehicles();
      for(int i = 66; i < vehicles.size(); i++){
        if(vehicles.get(i) == null || vehicles.get(i).getParkSpot() != -2){
          spot = i;
          i = vehicles.size();
        }
      }
      Train train = new Train(weight, spot, brakeLength);
      int result = garage.park(train, namn);
      return result;
    }
    else{
      return -1;
    }
  }

  //Finns det fordon
  public int findVehicle(int spot){
    if(garage.find(spot).getParkSpot() != -2){
      return spot;
    }
    else{
      return -1;
    }
  }

  //Hämta ett fordon
  public Vehicle getTheVehicle(int spot){
    if(garage.find(spot).getParkSpot() != -2){
      return garage.find(spot);
    }
    else{
      return null;
    }
  }

  //ta bort fordon
  public int unparkVehicle(int spot){
    if(garage.find(spot).getParkSpot() != -2){
      garage.unpark(spot);
      return spot;
    }
    else{
      return -1;
    }
  }

  //Visa alla fordon
  public String showAllVehiclesInGarage(){
    return garage.toString();
  }


}