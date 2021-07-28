package com.sda.zapis_plikow.Zadanie1;

import lombok.SneakyThrows;
// Napisz aplikację która otwiera plik 'output_1.txt',
//*usuwa jakiekolwiek linie tekstu w pliku,
// zapisuje do niego "Hello World!"
// a następnie zamyka plik.
import java.io.*;
public class Main2 {
    @SneakyThrows
    public static void main(String[] args) {

        String relative_file_path = "output_1.txt";

        File path = new File(relative_file_path);
        BufferedReader reader = new BufferedReader(new FileReader(path));

        try (PrintWriter writer = new PrintWriter
                (new FileOutputStream(path))){

            //definicja nowej linni jako Hello World!
            String new_line = "Hello World!";

            //usuwanie jakichkolwiek innych linii tekstu w pliku przed nadpisem
            for (String line;
                 (line = reader.readLine()) != null;) {
                String line2 = line.replace (new_line, " ");
            }

            // wyczyść bufor, wymuś zapis do pliku
            writer.flush();

            //zapis pliku
            writer.println(new_line);

            // czyszczenie bufora, wymuś zapis do pliku
            writer.flush();

        }catch(FileNotFoundException error){
            System.out.println("File not exist");
        }
    }
}
