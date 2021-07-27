package com.sda.zapis_plikow.Zadanie3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

// Napisz aplikację w której:
//w pętli while czyta ze Scannera wejście użytkownika z konsoli,
// a następnie linia polinii wypisujetekst do pliku 'output_3.txt'.
// Aplikacja ma się zamykać po wpisaniu przez użytkownika komendy "quit".
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Podaj tekst ");
        String sciezkaRelatywna = "output_3.txt";

        File sciezka = new File(sciezkaRelatywna);
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(sciezka))) {
            String linia ;
            do {
                // czytam linie
                linia = input.nextLine();

                if ((linia.equalsIgnoreCase("quit"))){
                    break;
                }
                // zapis do pliku
                writer.println(linia);

                // wyczyść bufor, wymuś zapis do pliku
                writer.flush();

                // sprawdzenie czy linia byla quit.
            }while (!linia.equalsIgnoreCase("quit"));
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
        }
    }
}
