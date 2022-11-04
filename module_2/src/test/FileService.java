package test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public List<Post> readFile(String path) throws IOException {
        List<Post> postList = new ArrayList<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(",");
                Post post = new Post();
                post.setId(Integer.parseInt(info[0]));
                post.setTitle(info[1]);
                post.setSubtitle(info[2]);
                post.setContent(info[3]);
                post.setViews(Integer.parseInt(info[4]));
                postList.add(post);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public void writeFile(String path, List<Post> postList) {
        List<String> strings = new ArrayList<>();
        for (Post post : postList) {
            strings.add(post.convertLine());
        }
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line : strings) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
