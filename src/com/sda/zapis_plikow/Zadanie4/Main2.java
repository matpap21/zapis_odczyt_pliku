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
import java.util.Date;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide file path:");

        String sciezkaRelatywna = "output_3.txt";
        File sciezka = new File(sciezkaRelatywna);

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(sciezka))) {
            String linia;
            do {
                // czytam linie
                linia = scanner.nextLine();

                // sprawdzenie czy linia byla quit.
                if ((linia.equalsIgnoreCase("quit"))) {
                    break;
                }
            } while (!linia.equalsIgnoreCase(sciezka.toString()));
            {

                if (sciezka.exists()) {
                    System.out.println("Plik istnieje");
                } else {
                    System.out.println("Plik nie istnieje");
                }

                if (sciezka.isFile()) {
                    System.out.println("to jest plik");
                } else {
                    System.out.println("to jest katalog");
                }

                System.out.println("Czas ostatniej modyfikacji: ");
                Date lastModified = new Date(sciezka.lastModified());
                System.out.println(lastModified);


                System.out.println("Rozmiar pliku: ");
                double size_in_Megabites = (double) (sciezka.length() / (1024 * 1024));
                System.out.println("Rozmiar pliku w Mb " + size_in_Megabites);

                double size_in_kilobytes = (double) (sciezka.length() / (1024));
                System.out.println("Rozmiar pliku w Kb " + size_in_kilobytes);

                double size_in_bytes = (double) (sciezka.length());
                System.out.println("Rozmiar pliku w b " + size_in_bytes);


                if (sciezka.canRead()) {
                    System.out.println("masz prawo do odczytu pliku");
                } else {
                    System.out.println("Nie masz uprawnień do odczytu pliku");
                }


                boolean czy_mozna_zapisywać = sciezka.canWrite();
                if (czy_mozna_zapisywać) {
                    System.out.println("Plik można zapisywać");
                } else {
                    System.out.println("Pliku nie można zapisywać");
                }
            }

            } catch(FileNotFoundException error){
                System.out.println("Nie znaleziono pliku.");
            }
        }
    }
