/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ethan
 */
public class Producto {
    private int id;
    private String nombrePr,categoriaPr;
    private int precioPr,stockPr;

    public Producto() {
    }

    public Producto(int id, String nombrePr, String categoriaPr, int precioPr, int stockPr) {
        this.id = id;
        this.nombrePr = nombrePr;
        this.categoriaPr = categoriaPr;
        this.precioPr = precioPr;
        this.stockPr = stockPr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePr() {
        return nombrePr;
    }

    public void setNombrePr(String nombrePr) {
        this.nombrePr = nombrePr;
    }

    public String getCategoriaPr() {
        return categoriaPr;
    }

    public void setCategoriaPr(String categoriaPr) {
        this.categoriaPr = categoriaPr;
    }

    public int getPrecioPr() {
        return precioPr;
    }

    public void setPrecioPr(int precioPr) {
        this.precioPr = precioPr;
    }

    public int getStockPr() {
        return stockPr;
    }

    public void setStockPr(int stockPr) {
        this.stockPr = stockPr;
    }

    
   

    
    
}
