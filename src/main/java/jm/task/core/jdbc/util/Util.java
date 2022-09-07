package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/sys";
    private static final String USER = "root";
    private static final String PASS = "root";
    

    public static Connection getConnection()
    {
      try {
          return DriverManager.getConnection(URL, USER, PASS);
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
    }

    public static Session getHibernateConnection()
    {
        SessionFactory factory = new Configuration().configure(URL)
                .addAnnotatedClass(User.class).buildSessionFactory();
        return factory.getCurrentSession();
    }
    
}
