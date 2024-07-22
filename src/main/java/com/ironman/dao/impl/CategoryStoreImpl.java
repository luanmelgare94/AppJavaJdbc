package com.ironman.dao.impl;

import com.ironman.dao.CategoryDao;
import com.ironman.dao.ConnectionCore;
import com.ironman.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CategoryStoreImpl implements CategoryDao {

    @Override
    public List<Category> findAll() throws Exception {
        // Attributes
        List<Category> categories = new LinkedList<>();

        Category category;

        String sqlQuery;

        // sql query
        sqlQuery = "select * from categories";

        // process
        try (
                // Get connection
                Connection connection = new ConnectionCore().getConnection();

                // Prepare statement
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

                // Execute query
                ResultSet resultSet = preparedStatement.executeQuery();) {

            // Set data
            while (resultSet.next()) {
                category = new Category();
                category.setId(resultSet.getLong("id"));
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));
                category.setUrlKey(resultSet.getString("url_key"));
                category.setState(resultSet.getString("state"));
                category.setCreatedAt(resultSet.getObject("created_at", LocalDateTime.class));
                category.setUpdatedAt(resultSet.getObject("updated_at", LocalDateTime.class));
                categories.add(category);
            }
        }
        // result
        return categories;
    }

    @Override
    public Category findById(Long id) throws Exception {
        // Attributes
        Category category = null;
        String sqlQuery;

        // Process
        sqlQuery = "select * from categories where id = ?";

        try (
                // Get connection
                Connection connection = new ConnectionCore().getConnection();

                // Prepare statement
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

        ) {
            // set parameter
            preparedStatement.setLong(1, id);

            try (
                    // Execute query
                    ResultSet resultSet = preparedStatement.executeQuery();) {
                // Set data
                if (resultSet.next()) {
                    category = new Category();
                    category.setId(resultSet.getLong("id"));
                    category.setName(resultSet.getString("name"));
                    category.setDescription(resultSet.getString("description"));
                    category.setUrlKey(resultSet.getString("url_key"));
                    category.setState(resultSet.getString("state"));
                    category.setCreatedAt(resultSet.getObject("created_at", LocalDateTime.class));
                    category.setUpdatedAt(resultSet.getObject("updated_at", LocalDateTime.class));
                }

            }
        }

        // Result
        return category;
    }

}