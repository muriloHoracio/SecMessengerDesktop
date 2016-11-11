/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import core.entity.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author murilo
 */
public class UserDao {
    private static Connection con;
    private static PreparedStatement ppst;
    
    public static boolean insertUser(User u){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/secmessenger", "murilo", "murilo");
            String sql = "INSERT INTO usertable VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, u.getEmail());
            ppst.setString(2, u.getUsername());
            ppst.setString(3, u.getPassword());
            ppst.setString(4, u.getPasswordSalt());
            ppst.setString(5, u.getName());
            ppst.setString(6, u.getCpf());
            ppst.setString(7, u.getTelefone());
            ppst.setString(8, u.getEstado()+"");
            ppst.setString(9, u.getCidade());
            ppst.setString(10, u.getBairro());
            ppst.setString(11, u.getRua());
            ppst.setString(12, u.getNumero());
            ppst.setString(13, u.getCep());
            ppst.executeUpdate();
            con.close();
            return true;
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace(System.err);
        }
        return false;
    }
    
    public static boolean addContact(String username, String contact){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/secmessenger", "murilo", "murilo");
            String sql = "INSERT INTO contacts VALUES (?,?);";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, username);
            ppst.setString(2, contact);
            ppst.executeUpdate();
            con.close();
            return true;
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace(System.err);
        }
        return false;
    }
    
    public static String getSalt(String username){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/secmessenger", "murilo", "murilo");
            String sql = "SELECT passwordsalt FROM usertable WHERE username LIKE ?;";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, username);
            ResultSet rs = ppst.executeQuery();
            while(rs.next()){
                con.close();
                return rs.getString("passwordsalt");
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    public static String getHash(String username){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/secmessenger", "murilo", "murilo");
            String sql = "SELECT password FROM usertable WHERE username LIKE ?;";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, username);
            ResultSet rs = ppst.executeQuery();
            while(rs.next()){
                con.close();
                return rs.getString("password");
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    public static boolean doUserExists(String username){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/secmessenger", "murilo", "murilo");
            String sql = "SELECT username FROM usertable WHERE username LIKE ?;";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, username);
            ResultSet rs = ppst.executeQuery();
            while(rs.next()){
                con.close();
                return true;
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace(System.err);
        }
        return false;
    }
    
    public static boolean doEmailExists(String email){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/secmessenger", "murilo", "murilo");
            String sql = "SELECT email FROM usertable WHERE email LIKE ?;";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, email);
            ResultSet rs = ppst.executeQuery();
            while(rs.next()){
                con.close();
                return true;
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace(System.err);
        }
        return false;
    }
    
    public static boolean doUserHasThisContact(String username, String contact){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/secmessenger", "murilo", "murilo");
            String sql = "SELECT contact FROM contacts WHERE username LIKE ? AND contact LIKE ?;";
            ppst = con.prepareStatement(sql);
            ppst.setString(1, username);
            ppst.setString(2, contact);
            ResultSet rs = ppst.executeQuery();
            while(rs.next()){
                con.close();
                return true;
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace(System.err);
        }
        return false;
    }
}
