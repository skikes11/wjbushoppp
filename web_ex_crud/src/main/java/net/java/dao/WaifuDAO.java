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
import net.java.model.waifu;
public class WaifuDAO {
	private static String jdbcURL = "jdbc:mysql://bb87l6buyp7e3a14aglf-mysql.services.clever-cloud.com:3306/bb87l6buyp7e3a14aglf?useUnicode=true&characterEncoding=UTF-8";
    private static String jdbcUsername = "ua27cafaz3nak5fh";
    private static String jdbcPassword = "WRVROVrHevanu7kJrz67";

    private static final String INSERT_WAIFU_SQL = "INSERT INTO waifu" + "  (name,age,type,price,image) VALUES " +
        " ( ?, ?,?,?,?);";
     
    private static final String GET_WAIFU_BY_ID_SQL = "select * from waifu where id = ?";
    
    private static final String SELECT_ALL_WAIFU = "select * from waifu";
    
    private static final String SELECT_ALL_WAIFU_TYPE_LOLI = "select * from waifu where type='loli' ";
    
    private static final String SELECT_ALL_WAIFU_TYPE_BB = "select * from waifu where type='BB' ";
    
    private static final String SELECT_ALL_WAIFU_AGE_GOING_UP = "select * from waifu order by age ASC";
    
    private static final String SELECT_ALL_WAIFU_AGE_GOING_DOWN = "select * from waifu order by age DESC";
    
    private static final String SELECT_ALL_WAIFU_AGE_GOING_UP_TYPE_LOLI = "select * from waifu where type='loli' order by age ASC";
    
    private static final String SELECT_ALL_WAIFU_AGE_GOING_DOWN_TYPE_LOLI = "select * from waifu where type='loli' order by age desc";
    
    private static final String SELECT_ALL_WAIFU_AGE_GOING_DOWN_TYPE_BB = "select * from waifu where type='BB' order by age desc";
    
    private static final String SELECT_ALL_WAIFU_AGE_GOING_UP_TYPE_BB = "select * from waifu where type='BB' order by age ASC";
    
    private static final String SELECT_ALL_WAIFU_NAME_A_Z = "select * from waifu order by name ASC";
    
    private static final String SELECT_ALL_WAIFU_NAME_A_Z_TYPE_BB = "select * from waifu where type='BB' order by name ASC";
    
    private static final String SELECT_ALL_WAIFU_NAME_A_Z_TYPE_LOLI = "select * from waifu where type='loli' order by name ASC";
    
    private static final String SELECT_ALL_WAIFU_PRICE_GOING_UP = "select * from waifu order by price ASC";
    
    private static final String SELECT_ALL_WAIFU_PRICE_GOING_UP_TYPE_LOLI = "select * from waifu where type='loli' order by price asc ";
    
    private static final String SELECT_ALL_WAIFU_PRICE_GOING_DOWN_TYPE_LOLI = "select * from waifu where type='loli' order by price desc ";
    
    private static final String SELECT_ALL_WAIFU_PRICE_GOING_UP_TYPE_BB = "select * from waifu where type='BB' order by price asc ";
    
    private static final String SELECT_ALL_WAIFU_PRICE_GOING_DOWN_TYPE_BB = "select * from waifu where type='BB' order by price desc ";
    
    private static final String SELECT_ALL_WAIFU_PRICE_GOING_DOWN = "select * from waifu  order by price desc";
    
    private static final String DELETE_WAIFU_SQL = "delete from waifu where id = ?;";
    
    private static final String UPDATE_WAIFU_SQL = "update waifu set name = ?,age= ?,type = ?,price= ?,image=?	 where id = ?;";
     
    
    
    public WaifuDAO() {}

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

    
   
    
    public waifu Get_Waifu_By_ID(int id) throws SQLException{
    	
    	try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_WAIFU_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
           while(rs.next()) {
        	   waifu waifu = new waifu(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6));
        	   return waifu;
           }
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }
    

 public void Update_Waifu_By_ID(waifu waifu) throws SQLException{
 	try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_WAIFU_SQL)) {
         preparedStatement.setString(1, waifu.getName());
         preparedStatement.setInt(2, waifu.getAge());
 		 preparedStatement.setString(3, waifu.getType());
 		 preparedStatement.setInt(4, waifu.getPrice());
 		 preparedStatement.setString(5, waifu.getImage());
 		 preparedStatement.setInt(6, waifu.getId());
         System.out.println(preparedStatement);
          preparedStatement.executeUpdate();
     } catch (SQLException e) {
         printSQLException(e);
     }
 }
 
 
 public void insertWaifu(waifu waifu) throws SQLException {
     System.out.println(INSERT_WAIFU_SQL);
     // try-with-resource statement will auto close the connection.
     try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WAIFU_SQL)) {
         preparedStatement.setString(1, waifu.getName());
         preparedStatement.setInt(2, waifu.getAge());
         preparedStatement.setString(3, waifu.getType());
         preparedStatement.setInt(4, waifu.getPrice());
         preparedStatement.setString(5, waifu.getImage());
         System.out.println(preparedStatement);
         preparedStatement.executeUpdate();
     } catch (SQLException e) {
     	printSQLException(e);
     }
 }
    public static void deleteWaifu(int id) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_WAIFU_SQL);) {
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
    
    public List<waifu> getAllWaifu(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
	
    public List<waifu> getAllWaifu_Type_Loli(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_TYPE_LOLI)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifu_Type_BB(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_TYPE_BB)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Price_Going_Up(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_PRICE_GOING_UP)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Price_Going_Down(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_PRICE_GOING_DOWN)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Price_Going_Down_Type_Loli(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_PRICE_GOING_DOWN_TYPE_LOLI)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Price_Going_Up_Type_Loli(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_PRICE_GOING_UP_TYPE_LOLI)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Price_Going_Up_Type_BB(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_PRICE_GOING_UP_TYPE_BB)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Price_Going_Down_Type_BB(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_PRICE_GOING_DOWN_TYPE_BB)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Age_Going_Down(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_AGE_GOING_DOWN)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Age_Going_Up(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_AGE_GOING_UP)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Age_Going_Up_Type_Loli(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_AGE_GOING_UP_TYPE_LOLI)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Age_Going_Down_Type_Loli(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_AGE_GOING_DOWN_TYPE_LOLI)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Age_Going_Up_Type_BB(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_AGE_GOING_UP_TYPE_BB)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Age_Going_Down_Type_BB(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_AGE_GOING_DOWN_TYPE_BB)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Name_A_Z_Type_BB(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_NAME_A_Z_TYPE_BB)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    public List<waifu> getAllWaifuWith_Name_A_Z(){
    	List<waifu> list = new ArrayList<>();
    	
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_NAME_A_Z)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
    
    
    public List<waifu> getAllWaifuWith_Name_A_Z_Type_Loli(){
    	List<waifu> list = new ArrayList<>(); 
    	 try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WAIFU_NAME_A_Z_TYPE_LOLI)) {
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
                 list.add(new waifu(rs.getInt("id"), rs.getString("name"),rs.getInt("age"),rs.getString("type"),
                		 rs.getInt("price"),rs.getString("image")));
             }
    	 } catch (SQLException e) {
             printSQLException(e);
         }
    	return list;
    }
}
