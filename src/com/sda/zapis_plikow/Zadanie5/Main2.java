package com.sda.zapis_plikow.Zadanie5;
//Kalkulator długości życia.
// Napisz aplikację która po odpowiedzi użytkownika napytania:
// a.Podaj datę urodzenia w formacie:yyyy-MM-dd:
// b.Kobieta, czy mężczyzna (k/m) (enum)i.mężczyźni żyją średnio o 10 lat krócej
// c.Czy palisz papierosy? (smoker/non_smoker) (enum)
//i.palący żyją średnio 9 lat i 3 miesiące krócej
// d.Czy żyjesz w stresie?
// i.jeśli tak, istnieje 10% prawdopodobieństwo, żeumrzesz na zawał serca w wieku 60 lat

// Zbierz wyniki odpowiedzi użytkownika do pliku
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.instrument.IllegalClassFormatException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.IllegalFormatException;
import java.util.Locale;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {


        String sciezkaRelatywna = "Zadanie5_zapis";
        File sciezka = new File (sciezkaRelatywna);

        Scanner scanner = new Scanner (System.in);
        Gender wybranyEnum_gender = null;
        smoker wybranyEnum_smoker = null;
        STRES wybranyEnum_stres = null;
        String skonwertowana_data_urodzenia_użytkownika;
        LocalDate data;


        do {
            skonwertowana_data_urodzenia_użytkownika = null;
            try {
                System.out.println ("Podaj datę urodzenia w formacie:yyyy-MM-dd lub quit by zakonczyc:");
                String data_uzytkownika = scanner.next ( );

                if ((data_uzytkownika.equalsIgnoreCase ("quit"))) {
                    break;
                }

                DateTimeFormatter formatczasu = DateTimeFormatter.ofPattern ("yyyy.MM.dd");
                data = LocalDate.parse (data_uzytkownika);

                skonwertowana_data_urodzenia_użytkownika = data.format (formatczasu);
                System.out.println ("Data urodzenia użytkownika to " + skonwertowana_data_urodzenia_użytkownika);

            } catch (DateTimeParseException error4) {
                System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (skonwertowana_data_urodzenia_użytkownika == null);
        System.out.println ("Data urodzenia " + skonwertowana_data_urodzenia_użytkownika);


        //KOBIETA czy MEZCZYZNA
        do {
            try {

                System.out.println ("Kobieta, czy mężczyzna (k/m)?: ");
                for (Gender płeć : Gender.values ( )) {
                    System.out.println (" - " + płeć);
                }
                String wpisanawartosc = scanner.next ( );
                wybranyEnum_gender = Gender.valueOf (wpisanawartosc.toUpperCase ( ));

            } catch (IllegalArgumentException error) {
                System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (wybranyEnum_gender == null);
        System.out.println ("Wybrano " + wybranyEnum_gender);


        //ENUM PALACY/NIEPALACY
        do {
            try {
                System.out.println ("Palisz papierosy ?: ");
                for (smoker smoking : smoker.values ( )) {
                    System.out.println (" - " + smoking);
                }
                String wpisanawartosc2 = scanner.next ( );

                wybranyEnum_smoker = smoker.valueOf (wpisanawartosc2.toUpperCase ( ));

                if (wybranyEnum_smoker == smoker.SMOKER) {
                    System.out.println ("palący żyją średnio 9 lat i 3 miesiące krócej");
                }

            } catch (IllegalArgumentException error2) {
                System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (wybranyEnum_smoker == null);
        System.out.println ("Wybrano " + wybranyEnum_smoker);


        // STRES / NOSTRES

        do {
            try {
                System.out.println ("Czy żyjesz w stresie?: ");
                for (STRES stres : STRES.values ( )) {
                    System.out.println (" - " + stres);
                }
                String wpisanawartosc3 = scanner.next ( );

                wybranyEnum_stres = STRES.valueOf (wpisanawartosc3.toUpperCase ( ));

                if (wybranyEnum_stres == STRES.STRES) {
                    System.out.println ("istnieje 10% prawdopodobieństwo, żeumrzesz na zawał serca w wieku 60 lat");
                }

            } catch (IllegalArgumentException error3) {
                System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (wybranyEnum_stres == null);
        System.out.println ("Wybrano " + wybranyEnum_stres);
    }
}

