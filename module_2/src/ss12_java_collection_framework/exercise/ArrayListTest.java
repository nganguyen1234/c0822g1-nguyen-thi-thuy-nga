package ss12_java_collection_framework.exercise;

import java.util.Scanner;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayListStudy arrayListStudy = new ArrayListStudy();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===========Menu===========");
            System.out.println("1.\tThêm sản phẩm\n" +
                    "2.\tSửa sản phẩm\n" +
                    "3.\tXóa sản phẩm \n" +
                    "4.\tHiển thị danh sách\n" +
                    "5.\tTìm kiếm\n" +
                    "6.\tSắp xếp\n"
                    + "7.\tThoát");
            System.out.println("Enter your choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    arrayListStudy.add();
                    break;
                case 2:
                    arrayListStudy.edit();
                    break;
                case 3:
                    arrayListStudy.remove();
                    break;
                case 4:
                    arrayListStudy.display();
                    break;
                case 5:
                    arrayListStudy.search();
                    break;
                case 6:
                    arrayListStudy.sort();
                    break;
                case 7:
                    System.exit(7);
            }
        } while (true);


    }
}
