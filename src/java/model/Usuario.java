/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ethan
 */
public class Usuario {
    private int id;
    private String nombreUs,rutUs,correoUs,passUs;
    
    public Usuario() {
    }
    
    public Usuario(int id, String nombreUs, String rutUs, String correoUs, String passUs) {
        this.id = id;
        this.nombreUs = nombreUs;
        this.rutUs = rutUs;
        this.correoUs = correoUs;
        this.passUs = passUs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUs() {
        return nombreUs;
    }

    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    public String getRutUs() {
        return rutUs;
    }

    public void setRutUs(String rutUs) {
        this.rutUs = rutUs;
    }

    public String getCorreoUs() {
        return correoUs;
    }

    public void setCorreoUs(String correoUs) {
        this.correoUs = correoUs;
    }

    public String getPassUs() {
        return passUs;
    }

    public void setPassUs(String passUs) {
        this.passUs = passUs;
    }
    
    
}


    
    