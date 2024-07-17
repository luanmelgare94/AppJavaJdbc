package com.ironman;

import com.ironman.dao.ConnectionCore;
import com.ironman.entity.Category;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ConnectionCore connectionCore = new ConnectionCore();
        connectionCore.getConnection();

        System.out.println("Connection successful");
    }
}