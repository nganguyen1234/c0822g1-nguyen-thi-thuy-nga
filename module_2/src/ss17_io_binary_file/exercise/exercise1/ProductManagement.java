package ss17_io_binary_file.exercise.exercise1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManagement {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Product> products = new ArrayList<>();

    private static void writeFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src\\ss17_io_binary_file\\exercise\\exercise1\\data\\data.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("=========Menu=========\n" +
                    "1.\tThêm sản phẩm\n" +
                    "2.\tHiển thị sản phẩm\n" +
                    "3.\tTìm kiếm thông tin sản phẩm\n" +
                    "4.\tThoát\n" +
                    "*****Nhập vào lựa chọn của bạn*****");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProduct();
                    writeFile();
                    break;
                case 2:
                    displayList();
                    break;
                case 3:
                    searchInfor();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập đúng lựa chọn hệ thống cung cấp");
            }
        } while (true);

    }

    private static void addProduct() {
        Product product = new Product();
        System.out.println("Nhập vào thông tin sản phẩm");
        System.out.println("Mã sản phẩm:");
        product.setId(Integer.parseInt(scanner.nextLine()));
        System.out.println("Tên sản phẩm:");
        product.setName(scanner.nextLine());
        System.out.println("Hãng sản xuất:");
        product.setManufacturer(scanner.nextLine());
        System.out.println("Gía:");
        product.setPrice(Double.parseDouble(scanner.nextLine()));
        System.out.println("Các mô tả khác:");
        product.setDescribe(scanner.nextLine());
        products.add(product);

    }

    private static void displayList() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void searchInfor() {
        System.out.println("Nhập mã sản phẩm cần tìm");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm");
    }
}
