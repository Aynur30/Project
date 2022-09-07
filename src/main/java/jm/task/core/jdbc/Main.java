package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
    // реализуйте алгоритм здесь
        UserService service = new UserServiceImpl();

        service.createUsersTable();
        
        for(int i = 0; i < 3; i++){
            service.saveUser("name", "ln", (byte)i);
            System.out.println("User с именем name" + i +  "в базу данных" );
        }
        ArrayList<User> users = (ArrayList<User>) service.getAllUsers();
        users.forEach(el -> System.out.println(el));
        users.clear();
        //users.forEach(el -> service.removeUserById(el.getId()));
        service.cleanUsersTable();
        // System.out.println(Util.getConnection());
        service.dropUsersTable();
    }
}
