package net.ivanvega.manejodefragmentos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActividadConFragmentHardcoded extends AppCompatActivity implements Com{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_con_fragment_hardcoded);
    }


    @Override
    public void responder(String datos){
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragemntoDos fragmentoDos = (FragemntoDos) fragmentManager.findFragmentById(R.id.fragDos);
        fragmentoDos.changetxt(datos);

    }

}
