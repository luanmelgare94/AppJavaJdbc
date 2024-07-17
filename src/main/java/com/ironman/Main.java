package com.ironman;

import com.ironman.entity.Category;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Category category = new Category();
        category.setId(1L);
        category.setName("Category 1");
        category.setDescription("Description 1");
        category.setUrlKey("URL Key 1");
        category.setState("A");

        System.out.println("Category Id: " + category.getDescription());

        Category category2 = new Category(2L, "Category 2", "Description 2", "URL Key 2", "B", null, null);
        System.out.println("Category 2 description: " + category2.getDescription());
    }
}