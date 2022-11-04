package test;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        List<Post> postList = null;
        try {
            postList = fileService.readFile("src\\test\\data");
            postList.add(new Post(1, "a", "b", "c", 5));
            postList.add(new Post(2, "d", "e", "f", 6));
            fileService.writeFile("src\\test\\data", postList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
