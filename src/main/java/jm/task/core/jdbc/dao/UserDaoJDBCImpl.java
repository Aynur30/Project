package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        try (Connection conn =  Util.getConnection()){
            conn.setAutoCommit(false);
            try (Statement createTable = conn.createStatement();){
                int res = createTable.executeUpdate ("CREATE TABLE sys.user"
                        + " (ID Long, name VARCHAR(20), lastname VARCHAR(20), "
                        + " age DOUBLE)");
                conn.commit();
            } catch(SQLException e){
                conn.rollback();
            }
            conn.setAutoCommit(true);
        }
    }


    public void dropUsersTable() throws SQLException {
        try (Connection conn =  Util.getConnection()){
            conn.setAutoCommit(false);
            try (Statement dropTable = conn.createStatement();){
                dropTable.executeUpdate ("DROP TABLE sys.user");
                conn.commit();
            } catch (SQLException e){
                conn.rollback();
            }
            conn.setAutoCommit(true);
        }
    }


    public void saveUser(String name, String lastName, byte age) throws SQLException {
        try (Connection conn =  Util.getConnection()) {
            conn.setAutoCommit(false);
            try(PreparedStatement ps = conn.prepareStatement("INSERT INTO sys.user VALUES (?, ?, ?, ?)");){
                ps.setLong(1, age + 2);
                ps.setString(2, name);
                ps.setString(3, lastName);
                ps.setInt(4, age);
                ps.executeUpdate();
                conn.commit();
            } catch(SQLException e) {
                conn.rollback();
            }
            conn.setAutoCommit(true);
        }
    }
    public void removeUserById(long id) throws SQLException {
        try (Connection conn =  Util.getConnection()) {
            conn.setAutoCommit(false);
            try(Statement removeUserById = conn.createStatement();){
                removeUserById.executeUpdate ("delete from sys.user where id =" + id);
                conn.commit();
            } catch(SQLException e){
                conn.rollback();
            }
            conn.setAutoCommit(true);
        }
    }


    public List<User> getAllUsers() throws SQLException {
        try (Connection conn =  Util.getConnection()) {
            List<User> list = new ArrayList<>();
            Statement createTable = conn.createStatement ();
            ResultSet rs = createTable.executeQuery ("select * from sys.user");
            while(rs.next()) {
                String name = rs.getString(2);
                String lastName = rs.getString(3);
                byte age = rs.getByte(4);
                User user = new User(name, lastName, age);
                list.add(user);
            }
            return list;
        }

    }


    public void cleanUsersTable() throws SQLException {
        try (Connection conn =  Util.getConnection()){
            conn.setAutoCommit(false);
            try (Statement createTable = conn.createStatement();){
                createTable.executeUpdate ("delete from sys.user");
                conn.commit();
            } catch(SQLException e){
                conn.rollback();
            }
            conn.setAutoCommit(true);
        }
    }
}
