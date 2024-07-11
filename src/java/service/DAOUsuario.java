/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.Conexion;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.CRUD;
import model.Usuario;
        
/**
 *
 * @author Ethan
 */
public class DAOUsuario implements CRUD<Usuario>{
    private Conexion oConexion;
    
    public DAOUsuario (Conexion oConexion){
        this.oConexion= oConexion;
    }
    
    @Override
    public void insert (Usuario obj) {
        String sql = "INSERT INTO usuarios VALUES(NULL,'"+ obj.getNombreUs() + "','" + obj.getRutUs() + "','" + obj.getCorreoUs()+ "','" + obj.getPassUs() + "')";
        try {
            oConexion.getConnection().createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Usuario obj) {
        String sql = "DELETE FROM usuarios WHERE id = '" + obj.getId() + "'";
        try {
            oConexion.getConnection().createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Usuario> get(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = '" + id + "'";
        try {
            ResultSet oResultSet = oConexion.getConnection().createStatement().executeQuery(sql);
            if (oResultSet.next()) {
                return Optional.of(new Usuario(oResultSet.getInt("id"), oResultSet.getString("nombre"), oResultSet.getString("rut"), oResultSet.getString("correo"), oResultSet.getString("contraseña")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Usuario obj) {
        String sql = "UPDATE usuarios set nombre='" + obj.getNombreUs() + "', rut='" + obj.getRutUs() + "',correo='" + obj.getCorreoUs()+ "', contraseña='" + obj.getPassUs() + "' WHERE id='"+ obj.getId() + "'";
        try {
           oConexion.getConnection().createStatement().execute(sql); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<List<Usuario>> getAll() {
        String sql= "SELECT * FROM usuarios";
        List<Usuario> list =new ArrayList<>();
        try {
            ResultSet oResultSet = oConexion.getConnection().createStatement().executeQuery(sql);
            while (oResultSet.next()) {
                list.add(new Usuario(oResultSet.getInt("id"), oResultSet.getString("nombre"), oResultSet.getString("rut"), oResultSet.getString("correo"), oResultSet.getString("contraseña")));
                
            }
            return Optional.of(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
    public Usuario isExist(Usuario oUsuario){
        String sql=  "SELECT * FROM usuarios WHERE rut = '" + oUsuario.getRutUs() + "' AND contraseña= '" + oUsuario.getPassUs()+"'";
        try {
            ResultSet oResultSet= oConexion.getConnection().createStatement().executeQuery(sql);
            if (oResultSet.next()) {
                return new Usuario(oResultSet.getInt("id"), oResultSet.getString("nombre"), oResultSet.getString("rut"), oResultSet.getString("correo"), oResultSet.getString("contraseña"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
