package com.dios.sqliteagenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    TextView txtbuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       lista =(ListView)findViewById(R.id.listaContactos);

        //DaoContactos dao = new DaoContactos(MainActivity.this);
        //dao.insert(new Contacto(0,"El perro negro","perronegro@","@perronegro","",""));
        cargardatos();
        busqueda();



    }

    public void busqueda(){
        txtbuscar=(TextView)findViewById(R.id.txtbuscar);

        txtbuscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(txtbuscar.getText().length()==0){
                    cargardatos();
                }else{
                    buscar(txtbuscar.getText().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    ArrayAdapter<Contacto> adp;
    public void cargardatos(){
        DaoContactos dao = new DaoContactos(MainActivity.this);
        adp = new ArrayAdapter<Contacto>(MainActivity.this,
                android.R.layout.simple_list_item_1,dao.getAllStudentsList());
        lista.setAdapter(adp);
    }

    public void buscar(String cad){
        DaoContactos dao = new DaoContactos(MainActivity.this);
        ArrayAdapter<Contacto> adp = new ArrayAdapter<Contacto>(MainActivity.this,
                android.R.layout.simple_list_item_1,dao.buscarcontacto(cad));

        lista.setAdapter(adp);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK)
        {

            try {

                Contacto objcontacto = (Contacto) data.getSerializableExtra("micontacto");

                DaoContactos dao = new DaoContactos(MainActivity.this);
                if(dao.insert(new Contacto(0,objcontacto.getNombre(),objcontacto.getEmail(),objcontacto.getTwitter(),objcontacto.getTelefono(),objcontacto.getBirthday()))>0) {

                    cargardatos();
                }else{

                }
                cargardatos();



            }catch (Exception err){
                cargardatos();
            }

        }
        cargardatos();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.insertar) {

            Intent siguiente = new Intent(getApplication(),activity_datos.class);
            startActivityForResult(siguiente,1000);
            cargardatos();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
