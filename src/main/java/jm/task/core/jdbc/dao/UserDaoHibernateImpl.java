package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.*;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }
    public void createUsersTable() {
        try {
            Session session = Util.getHibernateConnection();
            session.beginTransaction();
            NativeQuery query = session.createSQLQuery("CREATE TABLE `user` (`id` INT NOT NULL AUTO_INCREMENT,`name` VARCHAR(45) NULL,`lastName` VARCHAR(45) NULL,`age` INT NULL,PRIMARY KEY (`id`),UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception ignore) {
        }
    }
    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getHibernateConnection()) {
            transaction = session.beginTransaction();
            String stringQuery = "DROP TABLE IF EXISTS sys.user";
            session.createSQLQuery(stringQuery).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        User user = new User(name, lastName, age);
        try (Session session = Util.getHibernateConnection()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (Exception e) {
        }
    }


    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = Util.getHibernateConnection()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersList = null;
        Transaction transaction = null;
        try (Session session = Util.getHibernateConnection()) {
            transaction = session.beginTransaction();
            usersList= session.createSQLQuery("SELECT * FROM user").addEntity(User.class).list();
            transaction.commit();
        } catch (Exception e) {
        }
        return usersList;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getHibernateConnection()) {
            transaction = session.beginTransaction();
            session.createNativeQuery("DELETE FROM sys.user").executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        }
    }


}


