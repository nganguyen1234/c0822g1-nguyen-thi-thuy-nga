package com.codegym.repository.impl;

import com.codegym.repository.BaseRepository;
import com.codegym.model.User;
import com.codegym.repository.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String INSERT_USERS_SQL = "INSERT INTO users(name, email, country) VALUES(?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_USER_BY_COUNTRY = "select id,name,email,country from users where country like ?";
    private static final String SORT_BY_NAME = "select * from users order by name";
    private static final String DISPLAY_ALL_USERS_PROCEDURE = "call display_user()";
    private static final String DELETE_USER_PROCEDURE = "call delete_user(?)";
    private static final String UPDATE_USER_PROCEDURE = "call edit_users(?,?,?,?)";


    public List<User> searchByCountry(String searchName) {
        List<User> userList = new ArrayList<>();
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = baseRepository.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY)) {
            preparedStatement.setString(1, "%" + searchName + "%");
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return userList;
    }

    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = baseRepository.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {

        List<User> users = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(DISPLAY_ALL_USERS_PROCEDURE);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection = baseRepository.getConnection();
        CallableStatement callableStatement = connection.prepareCall(DELETE_USER_PROCEDURE);
        callableStatement.setInt(1, id);
        rowDeleted = callableStatement.executeUpdate() > 0;
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        Connection connection = baseRepository.getConnection();
        CallableStatement statement = connection.prepareCall(UPDATE_USER_PROCEDURE);
        statement.setInt(1, user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getCountry());
        rowUpdated = statement.executeUpdate() > 0;
        return rowUpdated;
    }

    @Override
    public List<User> sortByName() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = baseRepository.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_NAME);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
