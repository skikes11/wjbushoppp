package net.java.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.Escape;


import net.java.model.user;
public class UserDAO {
	private static String jdbcURL = "jdbc:mysql://bb87l6buyp7e3a14aglf-mysql.services.clever-cloud.com:3306/bb87l6buyp7e3a14aglf?useUnicode=true&characterEncoding=UTF-8";
    private static String jdbcUsername = "ua27cafaz3nak5fh";
    private static String jdbcPassword = "WRVROVrHevanu7kJrz67";

    private static final String INSERT_USERS_SQL = "INSERT INTO account" + "  ( taikhoan, matkhau) VALUES " +
        " ( ?, ?);";
    private static final String LOGIN_USERS_SQL = "select * from account where taikhoan = ? and matkhau = ?";
     
    private static final String GET_USER_BY_ID_SQL = "select * from account where id = ?";
    
    private static final String SELECT_ALL_ACCOUNT = "select * from account";
    
    private static final String DELETE_USERS_SQL = "delete from account where id = ?;";
    
    private static final String UPDATE_USERS_SQL = "update account set taikhoan = ?,matkhau= ? where id = ?;";
     
    
    
    public UserDAO() {}

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    public void insertUser(user user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getTaikhoan());
            preparedStatement.setString(2, user.getMatkhau());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	printSQLException(e);
        }
    }
    
    public user loginUser(String taikhoan, String matkhau) throws SQLException {
    	System.out.println(LOGIN_USERS_SQL);
    	ResultSet rs = null;
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USERS_SQL)) {
            preparedStatement.setString(1, taikhoan);
            preparedStatement.setString(2, matkhau);
            System.out.println(preparedStatement);
            rs = preparedStatement.executeQuery();
           while(rs.next()) {
        	   user User = new user(rs.getString(1),rs.getString(2));
        	   return User;
           }
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
       
    }
    
    public user Get_Account_By_ID(int id) throws SQLException{
    	
    	try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()) {
        	   user User = new user(rs.getInt(1),rs.getString(2),rs.getString(3));
        	   return User;
           }
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }
    
 public user Update_Account_By_ID(user User) throws SQLException{
    	
    	try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, User.getTaikhoan());
            preparedStatement.setString(2, User.getMatkhau());
    		preparedStatement.setInt(3, User.getId());
            System.out.println(preparedStatement);
             preparedStatement.executeUpdate();
           
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }
    
    public static void deleteUser(int id) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
        	statement.setInt(1, id);
            statement.executeUpdate();
        }catch (Exception e) {
			// TODO: handle exception
		}
      
    }

    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    public List<user> getAllAccount(){
    	List<user> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new user(rs.getInt("id"), rs.getString("taikhoan"),rs.getString("matkhau")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	
    	return list;
    }
	
}
