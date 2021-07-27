package com.sda.zapis_plikow.Zadanie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

// Napisz aplikację która otwiera plik 'output_1.txt',
// zapisuje do niego "Hello World!"
// a następnie zamyka plik.
public class Main {
    public static void main(String[] args) {

        String sciezkaAbsolutna = "C:/Users/Mateusz/Desktop/repoz/";
        String sciezkaRelatywna = "output_1.txt";

        File sciezka = new File(sciezkaRelatywna);

        try (PrintWriter writer = new PrintWriter
                (new FileOutputStream(sciezka))) {
            String linia ;

            // czytam linie
            linia = "Hello World!";

            // zapis do pliku
            writer.println(linia);

            // wyczyść bufor, wymuś zapis do pliku
            writer.flush();

            // sprawdzenie czy linia byla quit.
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
        }
    }
}