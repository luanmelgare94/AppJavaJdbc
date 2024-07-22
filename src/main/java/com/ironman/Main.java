package com.ironman;

import com.ironman.dao.CategoryDao;
import com.ironman.dao.impl.CategoryDaoImpl;
import com.ironman.entity.Category;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            CategoryDao categoryDao = new CategoryDaoImpl();

            System.out.println("Categories start: :)");
            List<Category> categories = categoryDao.findAll();
            categories.forEach(category -> {
                System.out.println("Category Id: " + category.getId());
                System.out.println("Category Name: " + category.getName());
                System.out.println("Category Description: " + category.getDescription());
                System.out.println("Category UrlKey: " + category.getUrlKey());
                System.out.println("Category State: " + category.getState());
                System.out.println("Category Created At: " + category.getCreatedAt());
                System.out.println("Category Updated At: " + category.getUpdatedAt());
                System.out.println();
            });
            /*Category category1 = categoryDao.findById(1000L);

            System.out.println("Category1 Id: " + category1.getId());
            System.out.println("Category1 Name: " + category1.getName());
            System.out.println("Category1 Description: " + category1.getDescription());
            System.out.println("Category1 UrlKey: " + category1.getUrlKey());
            System.out.println("Category1 State: " + category1.getState());
            System.out.println("Category1 Created At: " + category1.getCreatedAt());
            System.out.println("Category1 Updated At: " + category1.getUpdatedAt());
            System.out.println();*/
            /*Category category = new Category();
            category.setName("Categoria A2");
            category.setDescription("Sin detalles 2");
            category.setUrlKey("categoria-A2");
            category.setState("A");
            category.setCreatedAt(LocalDateTime.now());

            int result = categoryDao.create(category);
            System.out.println("Create: " + result);*/
            /*Category category = new Category();
            category.setName("Categoria A2");
            category.setDescription("Sin detalles 2");
            category.setUrlKey("categoria-a");
            category.setUpdatedAt(LocalDateTime.now());

            int result = categoryDao.update(97L, category);
            System.out.println("Update: " + result);*/
            /*categoryDao.deleteById(97L);
            System.out.println("DeleteById: ");*/
        } catch (Exception e) {
            System.out.println("Main::main:error: " + e.getMessage());
        }

    }
}