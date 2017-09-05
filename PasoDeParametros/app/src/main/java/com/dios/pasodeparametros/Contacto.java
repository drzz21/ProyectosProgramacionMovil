package com.dios.pasodeparametros;

import java.io.Serializable;
/**
 * Created by Dios on 05/09/2017.
 */

public class Contacto implements Serializable{

    private String usuario, mail, twitter, telefono, birthday;

    public Contacto(String usuario, String mail, String twitter, String telefono, String birthday) {
        this.usuario = usuario;
        this.mail = mail;
        this.twitter = twitter;
        this.telefono = telefono;
        this.birthday = birthday;
    }

    @Override
    public String toString(){
        return usuario +"\n"+mail;
    }
}
