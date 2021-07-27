package com.sda.zapis_plikow.Zadanie4;

//Napisz program, a w tym programie wczytaj jedną linięze skanera od użytkownika.
// Poproś użytkownika o 'adres pliku'.
// Po wpisaniuzweryfikuj czy:
// wybrany plik/katalog istnieje,
// czyjestplikiem/katalogiem,
// jaki jest jego: rozmiar, czas ostatniej modyfikacji
// i czy mamy prawa do odczytu/zapisu dotegopliku/katalogu.

import java.awt.*;
import java.io.*;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide file path , jeśli nie chcesz kontynuować, wpisz 'quit'");

        String sciezkaRelatywna = "output_3.txt";
        File sciezka = new File(sciezkaRelatywna);

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(sciezka))) {
            String linia;
            do {
                // czytam linie
                linia = scanner.nextLine();


                if ((linia.equals(sciezka))) {
                    System.out.println("sciezka istnieje ?: ");

                    if (sciezka.exists()) {
                        System.out.println("File exists");
                    } else {
                        System.out.println("File not found!");
                    }

                    if (sciezka.isFile()) {
                        System.out.println("to jest plik");
                    } else {
                        System.out.println("to jest katalog");
                    }

                    System.out.println("Czas ostatniej modyfikacji: ");
                    sciezka.lastModified();
                    System.out.println("Rozmiar pliku w Mb ");
                    double size_in_Megabites = (double) sciezka.length() / (1024 * 1024);
                    System.out.println("Rozmiar pliku w Kb ");
                    double size_in_kilobytes = (double) sciezka.length() / (1024);
                    System.out.println("Rozmiar pliku w b ");
                    double size_in_bytes = (double) sciezka.length();

                    if (sciezka.canRead()){
                        System.out.println("masz prawo do odczytu pliku");
                    }else {
                        System.out.println("Nie masz uprawnień do odczytu pliku");
                    }

                    // sprawdzenie czy linia byla quit.
                    if ((linia.equalsIgnoreCase("quit"))) {
                        break;
                    }
                }
            }
            while (!linia.equalsIgnoreCase("quit"));
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
        }
    }
}
