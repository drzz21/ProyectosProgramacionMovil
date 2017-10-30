package com.dios.sqliteagenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class activity_datos extends AppCompatActivity {

    Button guardar;
    Button actualizar;
    Button eliminar;
    Button cleaner;
    EditText id;
    EditText nombre;
    EditText email;
    EditText twittter;
    EditText tel;
    EditText fec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        actualizar = (Button)findViewById(R.id.btnactualizar);
        eliminar = (Button)findViewById(R.id.btneliminar);
        id = (EditText) findViewById(R.id.txtid);
        nombre = (EditText) findViewById(R.id.txtnombre);
        email = (EditText) findViewById(R.id.txtemail);
        twittter = (EditText) findViewById(R.id.txttwiter);
        tel = (EditText) findViewById(R.id.txttel);
        fec = (EditText) findViewById(R.id.txtfecha);
        cleaner = (Button) findViewById(R.id.btnClean);


            insertar();
            buscarcontacto();
            actualizar();
            EliminarContacto();

        cleaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id.setText("");
                nombre.setText("");
                email.setText("");
                twittter.setText("");
                tel.setText("");
                fec.setText("");

            }
        });

    }

    public void buscarcontacto(){

        id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                DaoContactos dao = new DaoContactos(activity_datos.this);
                ArrayList<Contacto> contacto;

                contacto = (ArrayList<Contacto>) dao.obtenercontacto(id.getText().toString());
                if(id.getText().length()>0  && contacto.size()>0) {
                    nombre.setText(contacto.get(0).getNombre());
                    email.setText(contacto.get(0).getEmail());
                    twittter.setText(contacto.get(0).getTwitter());
                    tel.setText(contacto.get(0).getTelefono());
                    fec.setText(contacto.get(0).getBirthday());
                }else{
                    nombre.setText("");
                    email.setText("");
                    twittter.setText("");
                    tel.setText("");
                    fec.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }

    public void actualizar(){
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DaoContactos objdao = new DaoContactos(activity_datos.this);
                    Contacto contactoo = new Contacto(Integer.parseInt(id.getText().toString()),nombre.getText().toString(),email.getText().toString(),twittter.getText().toString(),tel.getText().toString(),fec.getText().toString());
                    objdao.update(contactoo);
                }catch (Exception err){

                }

            }
        });
    }


    public void insertar(){
        guardar=(Button)findViewById(R.id.btnguardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent atras = new Intent();

                    Contacto alum = new Contacto();
                    alum.setNombre(nombre.getText().toString());
                    alum.setEmail(email.getText().toString());
                    alum.setTwitter(twittter.getText().toString());
                    alum.setTelefono(tel.getText().toString());
                    alum.setBirthday(fec.getText().toString());

                    atras.putExtra("micontacto", alum);

                    setResult(RESULT_OK, atras);
                    finish();


            }
        });
    }

    public void EliminarContacto(){

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DaoContactos dao = new DaoContactos(activity_datos.this);
                    dao.delete(id.getText().toString());
                }catch (Exception err){

                }
            }
        });

    }



}
