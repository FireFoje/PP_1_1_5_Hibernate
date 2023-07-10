package jm.task.core.jdbc.service;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao daoJDBC = new UserDaoJDBCImpl();

    public void createUsersTable() throws SQLException {
        daoJDBC.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        daoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        daoJDBC.saveUser(name, lastName, age);
        System.out.println("User с именем – " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) throws SQLException {
        daoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> list = daoJDBC.getAllUsers();
        for (User s : list) {
            System.out.println(s);
        }
        return list;
    }

    public void cleanUsersTable() throws SQLException {
        daoJDBC.cleanUsersTable();
    }
}
