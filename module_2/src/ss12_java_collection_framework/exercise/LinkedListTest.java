package ss12_java_collection_framework.exercise;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedListStudy linkedList = new LinkedListStudy();
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
                    linkedList.add();
                    break;
                case 2:
                    linkedList.edit();
                    break;
                case 3:
                    linkedList.remove();
                    break;
                case 4:
                    linkedList.display();
                    break;
                case 5:
                    linkedList.search();
                    break;
                case 6:
                    linkedList.sort();
                    break;
                case 7:
                    System.exit(7);
            }
        } while (true);


    }
}
