/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Ethan
 */
public class Conexion {
    private static Conexion instance;
    private Connection oConexion;
    
    private Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            oConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/examenf", "root", "");
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Conexion fallida");
            
        }
    }
    
    public static Conexion getInstance(){
        if (instance == null) {
            instance=new Conexion();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return oConexion;
    }
}
