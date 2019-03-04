package se.lexicon.jm.garage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      //Sätt igång programmet via UserInterface

      UserInterface ui = new UserInterface(new Garage());
      ui.runMenu();

      //Avsluta programmet
      System.out.println("Ha en trevlig dag.");
    }
}
