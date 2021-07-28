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
import java.io.FileNotFoundException;
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

public class Main {
    public static void main(String[] args) {


        String sciezkaRelatywna = "Zadanie5_zapis";
        File sciezka = new File (sciezkaRelatywna);

        Scanner scanner = new Scanner (System.in);
        Gender wybranyEnum_gender = null;
        Smoker wybranyEnum_smoker = null;
        Stres wybranyEnum_stres = null;
        String skonwertowana_data_urodzenia_uzytkownika;
        LocalDate data;


        do {
            skonwertowana_data_urodzenia_uzytkownika = null;
            try  (PrintWriter writer = new PrintWriter(new FileOutputStream (sciezka))) {

                System.out.println ("Podaj datę urodzenia w formacie:yyyy-MM-dd lub quit by zakonczyc:");
                String data_uzytkownika = scanner.next ( );

                if ((data_uzytkownika.equalsIgnoreCase ("quit"))) {
                    break;
                }

                DateTimeFormatter formatczasu = DateTimeFormatter.ofPattern ("yyyy.MM.dd");
                data = LocalDate.parse (data_uzytkownika);

                skonwertowana_data_urodzenia_uzytkownika = data.format (formatczasu);
                System.out.println ("Data urodzenia użytkownika to " + skonwertowana_data_urodzenia_uzytkownika);
                writer.println(skonwertowana_data_urodzenia_uzytkownika);


            } catch (DateTimeParseException | FileNotFoundException error4) {
                System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (skonwertowana_data_urodzenia_uzytkownika == null);
        System.out.println ("Data urodzenia " + skonwertowana_data_urodzenia_uzytkownika);


        //KOBIETA czy MEZCZYZNA
        do {
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(sciezka)))
            {

                System.out.println ("Kobieta, czy mężczyzna (k/m)?: ");
                for (Gender plec : Gender.values ( )) {
                    System.out.println (" - " + plec);
                }
                String wpisanawartosc = scanner.next ( );
                wybranyEnum_gender = Gender.valueOf (wpisanawartosc.toUpperCase ( ));
                writer.println(wybranyEnum_gender);


            } catch (IllegalArgumentException | FileNotFoundException error) {
                System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (wybranyEnum_gender == null);
        System.out.println ("Wybrano " + wybranyEnum_gender);


        //ENUM PALACY/NIEPALACY
        do {
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(sciezka))) {

                System.out.println ("Palisz papierosy ?: ");
                for (Smoker smoking : Smoker.values ( )) {
                    System.out.println (" - " + smoking);
                }
                String wpisanawartosc2 = scanner.next ( );

                wybranyEnum_smoker = Smoker.valueOf (wpisanawartosc2.toUpperCase ( ));

                if (wybranyEnum_smoker == Smoker.SMOKER) {
                    System.out.println ("palący żyją średnio 9 lat i 3 miesiące krócej");
                }
                writer.println(wybranyEnum_smoker);


            } catch (IllegalArgumentException | FileNotFoundException error2) {
                System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (wybranyEnum_smoker == null);
        System.out.println ("Wybrano " + wybranyEnum_smoker);


        // STRES / NOSTRES

        do {
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(sciezka))) {

                System.out.println ("Czy żyjesz w stresie?: ");
                for (Stres stres : Stres.values ( )) {
                    System.out.println (" - " + stres);
                }
                String wpisanawartosc3 = scanner.next ( );

                wybranyEnum_stres = Stres.valueOf (wpisanawartosc3.toUpperCase ( ));

                if (wybranyEnum_stres == Stres.STRES) {
                    System.out.println ("istnieje 10% prawdopodobieństwo, żeumrzesz na zawał serca w wieku 60 lat");
                }

                writer.println(wybranyEnum_stres);


            } catch (IllegalArgumentException | FileNotFoundException error3) {
                System.out.println ("Niepoprawna wartość, spróbuj ponownie ");
            }
        } while (wybranyEnum_stres == null);
        System.out.println ("Wybrano " + wybranyEnum_stres);
    }
}
