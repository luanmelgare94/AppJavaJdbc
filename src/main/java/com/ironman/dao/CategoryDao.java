package com.ironman.dao;

import com.ironman.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    public List<Category> findAll() throws Exception{
        // Attributes
        List<Category> categories = new ArrayList<>();

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
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {

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

}