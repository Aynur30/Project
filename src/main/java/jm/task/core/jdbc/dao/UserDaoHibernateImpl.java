package jm.task.core.jdbc.dao;
/*
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getHibernateConnection()) {
            // start a transaction
            transaction = session.beginTransaction();
            String stringQuery = "TABLE sys.user"
            + " (ID Long, name VARCHAR(20), lastname VARCHAR(20), "
            + " age DOUBLE)";
            Query query = session.createQuery(stringQuery);
            query.executeUpdate();
            transaction.commit();
        } catch (SQLException e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getHibernateConnection()) {
            // start a transaction
            transaction = session.beginTransaction();
            String stringQuery = "DROP TABLE sys.user";
            Query query = session.createQuery(stringQuery);
            query.executeUpdate();
            transaction.commit();
        } catch (SQLException e) {
            if (transaction != null) {
                try{
                    transaction.rollback();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = Util.getHibernateConnection()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.saveOrUpdate(new User(name, lastName, age));
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = Util.getHibernateConnection()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a persistent object
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction;
        try (Session session = Util.getHibernateConnection()) {
            // start a transaction
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM");
            List<User> usersList = (List<User>)query.addEntity(User.class).list();
            transaction.commit();
            return usersList != null ? usersList : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cleanUsersTable() {

        try (Session session = Util.getHibernateConnection()) {
            // start a transaction
            transaction = session.beginTransaction();
            String stringQuery = "DELETE FROM sys.user";
            Query query = session.createQuery(stringQuery);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


}


 */