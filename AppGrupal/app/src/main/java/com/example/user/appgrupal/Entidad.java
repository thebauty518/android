package com.example.user.appgrupal;

import java.io.Serializable;

/**
 * Created by USER on 10/07/2018.
 */

public class Entidad implements Serializable {
    private String Ndocumento;
    private String Nombre;
    private String Apellido;
    private String Categoria;
    private String Profesion;
    private String Nfecha;
    private String Direccion;
    private String Email;
    private String Telefono;
    private String Nfoto;

    public Entidad(String ndocumento, String nombre, String apellido, String categoria, String profesion, String nfecha, String direccion, String email, String telefono, String nfoto) {
        Ndocumento = ndocumento;
        Nombre = nombre;
        Apellido = apellido;
        Categoria = categoria;
        Profesion = profesion;
        Nfecha = nfecha;
        Direccion = direccion;
        Email = email;
        Telefono = telefono;
        Nfoto = nfoto;
    }

    public Entidad() {

    }

    public String getNdocumento() {
        return Ndocumento;
    }

    public void setNdocumento(String ndocumento) {
        Ndocumento = ndocumento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String profesion) {
        Profesion = profesion;
    }

    public String getNfecha() {
        return Nfecha;
    }

    public void setNfecha(String nfecha) {
        Nfecha = nfecha;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getNfoto() {
        return Nfoto;
    }

    public void setNfoto(String nfoto) {
        Nfoto = nfoto;
    }
}
