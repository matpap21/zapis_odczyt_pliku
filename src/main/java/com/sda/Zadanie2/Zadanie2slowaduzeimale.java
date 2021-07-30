package com.sda.Zadanie2;

import java.io.*;

//Stwórz aplikację która odczyta plik 'output_2.txt'
// i wczyta z niego linię,
// anastępnie wypisze ją na ekran:
// 1 raz "toUpperCase",1 raz "toLowerCase",1 raz "trim".
public class Zadanie2slowaduzeimale {
    public static void main(String[] args) {
        String sciezka = "output_2.txt";
        if (new File (sciezka).exists ( )) {
            try (BufferedReader reader = new BufferedReader (new FileReader (sciezka))) {
                String linia = null;
//                Pattern pattern = Pattern.compile ("^[a-zA-Z ._-]*$"); //  przeszukiwanie tresci, szukam konkretneog slowa
//                Pattern pattern1 =Pattern.compile ("[A-Z]*[a-z][A-Z]*");
                //Matcher matcher = pattern.matcher (linia);

                while ((linia = reader.readLine ( )) != null) {
                    if (linia.isEmpty ( )) {
                        // to znaczy że jest zero słów
                        continue;
                    }
                    System.out.println (linia.toUpperCase ( ));
                    System.out.println (linia.toLowerCase ( ));
                    System.out.println (linia.trim ( ));
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