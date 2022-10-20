package ss12_java_collection_framework.exercise;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListStudy {
    LinkedList<Product> list = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);

    public void add() {
        Product product = new Product();
        System.out.println("Nhập vào id sản phẩm muốn thêm:");
        product.setId(Integer.parseInt(scanner.nextLine()));
        System.out.println("Nhập vào tên sản phẩm muốn thêm:");
        product.setName(scanner.nextLine());
        System.out.println("Nhập vào giá tiền của sản phẩm");
        product.setPrice(Double.parseDouble(scanner.nextLine()));
        list.add(product);
    }

    public void remove() {
        System.out.println("Nhập vào id sản phẩm muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : list) {
            if (product.getId() == id) {
                list.remove(product);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm");
    }

    public void edit() {
        System.out.println("Nhập vào id sản phẩm muốn sửa:");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : list) {
            if (product.getId() == id) {
                System.out.println("Nhập vào id mới:");
                product.setId(Integer.parseInt(scanner.nextLine()));
                System.out.println("Nhập vào tên sản phẩm mới:");
                product.setName(scanner.nextLine());
                System.out.println("Nhập vào giá tiền mới của sản phẩm");
                product.setPrice(Double.parseDouble(scanner.nextLine()));
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm");
    }

    public void display() {
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }

    public void search() {
        System.out.println("Nhập vào id sản phẩm muốn tìm kiếm");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : list) {
            if (product.getId() == id) {
                System.out.println(product.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm");
    }
    public void sort(){
        list.sort(Product::compareTo);
        display();
    }
}
