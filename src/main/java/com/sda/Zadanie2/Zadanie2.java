package com.sda.Zadanie2;

import java.io.*;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Stwórz aplikację która odczyta plik 'output_2.txt'
// i wczyta z niego linię,
// anastępnie wypisze ją na ekran:
// 1 raz "toUpperCase",1 raz "toLowerCase",1 raz "trim".
public class Zadanie2 {
    public static void main(String[] args) {
        String sciezka = "output_2.txt";
        if (new File (sciezka).exists ( )) {
            try (BufferedReader reader = new BufferedReader (new FileReader (sciezka))) {
                String linia = null;
                while ((linia = reader.readLine ( )) != null) {
                    if (linia.isEmpty ( )) {
                        // to znaczy że jest zero słów
                        continue;
                    }
                    // dla każdego znaku czytamy znak
                    char[] znaki = linia.toCharArray ( );
                    int charNumber = 0;
                    for (int i = 0; i < znaki.length; i++) {
                        char znak = znaki[i];

                        // lUbIMY DODATKOWE ZAJECIA
                        // ^            L
                        //  ^           U
                        //   ^          B
//                        System.out.println ("Znak : " + znak + " numerZnaku: " + charNumber);
                        if (charNumber % 2 == 0 && Character.isUpperCase (znak)) { // parzyste mają być małe
                            znaki[i] = Character.toLowerCase (znak);
                        } else if (charNumber % 2 != 0 && Character.isLowerCase (znak)) { // nieparzyste mają być duże
                            znaki[i] = Character.toUpperCase (znak);
                        }

                        if(Character.isAlphabetic (znak)){
                            charNumber++;
                        }

                    }
                    String wynik = new String (znaki);
                    System.out.println (wynik);
                }


                //System.out.println (matcher.find ());

                //StringBuffer newString = new StringBuffer (linia);
                //  for (int i = 0; i < linia.length ( ); i++) {

                //Sprawdza które lietey są napisane małą literą
                //   if (Character.isLowerCase (linia.charAt (i))) {
                //       //Zamiana z małej na dużą
                //       newString.setCharAt (i, Character.toUpperCase (linia.charAt (i)));
                //   }
                //   //Sprawdza które lietey są napisane duzą literą
                //   else if (Character.isUpperCase (linia.charAt (i))) {
                //       //Zamiana z dużej na mała
                //       newString.setCharAt (i, Character.toLowerCase (linia.charAt (i)));
                //     }
                //  }
                //System.out.println ("String po zmianie : " + newString);

            } catch (FileNotFoundException e) {
                System.out.println ("Nie ma takiego pliku");
            } catch (IOException e) {
                System.err.println (e.getMessage ( ));
            }
        } else {
            System.err.println ("Nie ma takiego pliku!");
        }
    }
}