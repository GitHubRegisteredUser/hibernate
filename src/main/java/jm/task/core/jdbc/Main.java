package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.HibernateUtil;
import org.hibernate.HibernateException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan", "Petrov", (byte) 20);
        userService.saveUser("Petr", "Ivanov", (byte) 30);
        userService.saveUser("Billy", "Herrington", (byte) 48);
        userService.saveUser("Van", "Darkholme", (byte) 51);
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
        if (HibernateUtil.getSessionFactory() != null) {
            try {
                HibernateUtil.getSessionFactory().close();
            } catch (HibernateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
