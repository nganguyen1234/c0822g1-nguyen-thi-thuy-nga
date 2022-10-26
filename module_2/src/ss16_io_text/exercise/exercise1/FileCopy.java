package ss16_io_text.exercise.exercise1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\ss16_io_text\\exercise\\exercise1\\data\\input.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List list = new ArrayList();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }
        System.out.println(list);
        bufferedReader.close();
        File file1 = new File("src\\ss16_io_text\\exercise\\exercise1\\data\\output.txt");
        FileWriter fileWriter = new FileWriter(file1);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Object item : list) {
            bufferedWriter.write(item.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

}
