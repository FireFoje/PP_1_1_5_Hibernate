package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {}

    public void createUsersTable() {
        String createTable = "create table if not exists user\n" +
                "(\n" +
                "    id       BIGINT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    name     VARCHAR(40),\n" +
                "    lastName VARCHAR(40),\n" +
                "    age      INT\n" +
                ")";
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(createTable);
        } catch (SQLException ignored) {
            System.out.println("Error of ctreating");
            throw new RuntimeException();
        }
    }


    public void dropUsersTable() throws SQLException {
        String drop = "DROP TABLE IF EXISTS user";
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(drop);
        } catch (SQLException e) {
            System.out.println("Error dropped");
            throw new RuntimeException(e);
        }
    }


    public void saveUser(String name, String lastName, byte age) {
        String save = "INSERT INTO user(name, lastName, age) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(save)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error saved");
            throw new RuntimeException(e);
        }

    }


    public void removeUserById(long id) throws SQLException {
        String deleteById = "DELETE FROM user WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteById)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete by id Error");
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String getAll = "SELECT * FROM user";
        try (ResultSet resultSet = connection.createStatement().executeQuery(getAll)) {
            while (resultSet.next()) {
                User user = new User(resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getByte("age"));
                user.setId(resultSet.getLong("id"));
                list.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error get all");
            throw new RuntimeException(e);
        }
        return list;
    }

    public void cleanUsersTable() {
        String clean = "TRUNCATE TABLE user;";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(clean);
        } catch (SQLException e) {
            System.out.println("Error clean");
            throw new RuntimeException();
        }
    }
}
