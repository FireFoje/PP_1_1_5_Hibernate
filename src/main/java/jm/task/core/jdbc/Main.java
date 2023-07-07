package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private final static UserService userDao = new UserServiceImpl();
    public static void main(String[] args) throws Exception {


        userDao.createUsersTable();
        userDao.saveUser("Bob", "Bobbinson", (byte) 20);
        userDao.saveUser("Hanna", "Wilson", (byte) 25);
        userDao.saveUser("Leonel", "Messi", (byte) 31);
        userDao.saveUser("Rock", "Lee", (byte) 18);
        userDao.removeUserById(2);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
