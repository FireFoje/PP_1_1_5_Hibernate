package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private final static UserDaoHibernateImpl userDao = new UserDaoHibernateImpl();

    public static void main(String[] args) {


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
