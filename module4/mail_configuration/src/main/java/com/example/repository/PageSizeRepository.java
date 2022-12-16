package com.example.repository;

import java.util.ArrayList;
import java.util.List;

public class PageSizeRepository {
    public static List<Integer> pageSizeList =new ArrayList<>();
    static {
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }
}
