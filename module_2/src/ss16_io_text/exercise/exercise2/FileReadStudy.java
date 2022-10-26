package ss16_io_text.exercise.exercise2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadStudy {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\ss16_io_text\\exercise\\exercise2\\data\\input.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Country> list = new ArrayList();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] infor = line.split(",");
            Country country = new Country(Integer.parseInt(infor[0]), infor[1], infor[2]);
            list.add(country);
        }
        for (Country country: list) {
            System.out.println(country.toString());
        }
        bufferedReader.close();
    }

}

