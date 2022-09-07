package jm.task.core.jdbc.dao;

import com.google.protobuf.Message;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {}

    public void createUsersTable() {
        try (Connection conn = Util.getConnection()) {
            conn.setAutoCommit(false);
            Statement createTable = conn.createStatement();
            createTable.executeUpdate ("CREATE TABLE sys.user"
            + " (ID Long, name VARCHAR(20), lastname VARCHAR(20), "
            + " age DOUBLE)");
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {}
    }

    
    public void dropUsersTable() {
        try (Connection conn =  Util.getConnection()){
            conn.setAutoCommit(false);
            Statement dropTable = conn.createStatement();
            dropTable.executeUpdate ("DROP TABLE sys.user");
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e){
        }
    }

    
    public void saveUser( String name, String lastName, byte age) {
        try (Connection conn =  Util.getConnection()) {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO sys.user VALUES (?, ?, ?, ?)");
            ps.setLong(1, age + 2);
            ps.setString(2, name);
            ps.setString(3, lastName);
            ps.setInt(4, age);
            ps.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e){
        }
    }
    public void removeUserById(long id) {
        try (Connection conn =  Util.getConnection()) {
            conn.setAutoCommit(false);
            Statement removeUserById = conn.createStatement();
            removeUserById.executeUpdate ("delete from sys.user where id =" + id);
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
        }
    }

    
    public List<User> getAllUsers() {
        try (Connection conn =  Util.getConnection()) {
            conn.setAutoCommit(false);
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
            conn.commit();
            conn.setAutoCommit(true);
            return list;
        } catch (SQLException e) {}
        return null;
    }

    
    public void cleanUsersTable() {
        try (Connection conn =  Util.getConnection()){
            conn.setAutoCommit(false);
            Statement createTable = conn.createStatement();
            createTable.executeUpdate ("delete from sys.user");
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e){
        }
    } 
}
