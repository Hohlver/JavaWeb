/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.CRUD;
import model.Producto;

/**
 *
 * @author Ethan
 */
public class DAOProducto implements CRUD<Producto>{
    private Conexion oConexion;
    
    public DAOProducto(Conexion oConexion){
    this.oConexion=oConexion;
    }


    @Override
    public void insert (Producto obj){
        String sql= "INSERT INTO productos VALUES (NULL, '"+obj.getNombrePr()+"','"+obj.getCategoriaPr()+"','"+obj.getPrecioPr()+"','"+obj.getStockPr()+"')";
        try {
            oConexion.getConnection().createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Producto obj) {
        String sql= "DELETE FROM productos WHERE id= '"+obj.getId()+"'";
        try {
            oConexion.getConnection().createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Producto> get(int id) {
        String sql= "SELECT * FROM productos WHERE id= '"+ id +"'";
        try {
            ResultSet oResultSet= oConexion.getConnection().createStatement().executeQuery(sql);
            if (oResultSet.next()) {
                return Optional.of(new Producto(oResultSet.getInt("id"), oResultSet.getString("nombre"), oResultSet.getString("categoria"), oResultSet.getInt("precio"), oResultSet.getInt("stock")));            
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Producto obj) {
            String sql= "UPDATE productos set nombre= '"+ obj.getNombrePr()+"', categoria= ´"+obj.getCategoriaPr()+"', precio= '"+obj.getPrecioPr()+"', stock= '"+obj.getStockPr()+" WHERE id= '"+obj.getId()+"'";
        try {
            oConexion.getConnection().createStatement().execute(sql);
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    @Override
    public Optional<List<Producto>> getAll() {
            String sql= "SELECT * FROM productos";
            List<Producto> List = new ArrayList<>();
        try {
            ResultSet oResultSet= oConexion.getConnection().createStatement().executeQuery(sql);
            while (oResultSet.next()) {                
                List.add(new Producto(oResultSet.getInt("id"), oResultSet.getString("nombre"), oResultSet.getString("categoria"), oResultSet.getInt("precio"), oResultSet.getInt("stock")));
            }
            return Optional.of(List);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}