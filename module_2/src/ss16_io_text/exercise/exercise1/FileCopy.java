package ss16_io_text.exercise.exercise1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCopy {
    public static void main(String[] args) {
        List list = new ArrayList();
        try {
            File file = new File("src\\ss16_io_text\\exercise\\exercise1\\data\\input.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            int size = 0;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
                size += line.length();
            }
            System.out.println("số ký tự của file source là: " + size);
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File nguồn không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File file1 = new File("src\\ss16_io_text\\exercise\\exercise1\\data\\output.txt");
            FileWriter fileWriter = new FileWriter(file1);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Object item : list) {
                bufferedWriter.write(item.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
