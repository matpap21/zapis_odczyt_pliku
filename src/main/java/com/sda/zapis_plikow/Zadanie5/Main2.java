package com.sda.zapis_plikow.Zadanie5;

import jdk.jshell.spi.ExecutionControl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        String sciezkaRelatywna = "Zadanie5_zapis";
        File sciezka = new File (sciezkaRelatywna);
        Scanner scanner = new Scanner (System.in);

        try (PrintWriter writer = new PrintWriter (new FileOutputStream (sciezka))) {
            String skonwertowana_data_urodzenia_uzytkownika;
            skonwertowana_data_urodzenia_uzytkownika = null;
            Gender wybranyEnum_gender;
            wybranyEnum_gender = null;
            Smoker wybranyEnum_smoker;
            wybranyEnum_smoker = null;
            Stres wybranyEnum_stres;
            wybranyEnum_stres = null;
            LocalDate data;
            String linia;

            do {
                System.out.println ("Podaj datę urodzenia w formacie:yyyy-MM-dd lub quit by zakonczyc:");
                String data_uzytkownika = scanner.next ( );
                DateTimeFormatter formatczasu = DateTimeFormatter.ofPattern ("yyyy.MM.dd");
                data = LocalDate.parse (data_uzytkownika);
                skonwertowana_data_urodzenia_uzytkownika = data.format (formatczasu);
                System.out.println ("Data urodzenia użytkownika to " + skonwertowana_data_urodzenia_uzytkownika);

                if(data_uzytkownika.equalsIgnoreCase ("quit")) {
                    System.out.println ("Zakonczono przez użytkownika" );
                    break;
                }

                System.out.println ("Kobieta, czy mężczyzna (k/m)?: ");
                for (Gender plec : Gender.values ( )) {
                    System.out.println (" - " + plec);
                }
                String wpisanawartosc = scanner.next ( );
                wybranyEnum_gender = Gender.valueOf (wpisanawartosc.toUpperCase ( ));

                System.out.println ("Palisz papierosy ?: ");
                for (Smoker smoking : Smoker.values ( )) {
                    System.out.println (" - " + smoking);
                }
                String wpisanawartosc2 = scanner.next ( );

                wybranyEnum_smoker = Smoker.valueOf (wpisanawartosc2.toUpperCase ( ));

                if (wybranyEnum_smoker == Smoker.SMOKER) {
                    System.out.println ("palący żyją średnio 9 lat i 3 miesiące krócej");
                }

                System.out.println ("Czy żyjesz w stresie?: ");
                for (Stres stres : Stres.values ( )) {
                    System.out.println (" - " + stres);
                }
                String wpisanawartosc3 = scanner.next ( );

                wybranyEnum_stres = Stres.valueOf (wpisanawartosc3.toUpperCase ( ));

                if (wybranyEnum_stres == Stres.STRES) {
                    System.out.println ("istnieje 10% prawdopodobieństwo, żeumrzesz na zawał serca w wieku 60 lat");
                }

                writer.println (skonwertowana_data_urodzenia_uzytkownika);
                writer.println (wybranyEnum_gender);
                writer.println (wybranyEnum_smoker);
                writer.println (wybranyEnum_stres);
                writer.flush ( );

            } while (wybranyEnum_gender == null && wybranyEnum_smoker == null && wybranyEnum_stres == null && skonwertowana_data_urodzenia_uzytkownika == null);
            System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
        } catch (FileNotFoundException exception) {
            exception.printStackTrace ( );
            System.out.println ("Nie znaleziono pliku");
        }
    }
}
