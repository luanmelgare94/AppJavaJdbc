package com.ironman.dao;

import com.ironman.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    public List<Category> findAll() {
        // Attributes
        List<Category> categories = new ArrayList<>();

        Category category;

        String sqlQuery;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        // process
        try {
            // sql query
            sqlQuery = "select * from categories";

            // Get connection
            connection = new ConnectionCore().getConnection();

            // Prepare statement
            preparedStatement = connection.prepareStatement(sqlQuery);

            // Execute query
            resultSet = preparedStatement.executeQuery();

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
        } catch (Exception e) {
            System.out.println("CategoryDao::findAl::Error: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }

                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("CategoryDao::findAll::finally: " + e.getMessage());
            }
        }
        // result
        return categories;
    }

}