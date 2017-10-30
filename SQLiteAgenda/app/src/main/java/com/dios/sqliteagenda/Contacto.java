package com.dios.sqliteagenda;

import java.io.Serializable;

/**
 * Created by Gerardo on 07/10/2017.
 */

public class Contacto  implements Serializable{
    int id;
    String nombre;
    String email;
    String twitter;
    String telefono;
    String birthday;

    public Contacto() {}

    public Contacto(int id, String nombre, String email, String twitter, String telefono, String birthday) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.twitter = twitter;
        this.telefono = telefono;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nID:"+this.id + "\nNombre: " + this.nombre + "\nCorreo: " + this.email+ "\nTwitter: " + this.twitter+ "\nTelefono: " + this.telefono+ "\nFecha_nacimiento: " + this.birthday+"\n";
    }
}
