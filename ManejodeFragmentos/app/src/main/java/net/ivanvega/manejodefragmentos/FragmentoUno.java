package net.ivanvega.manejodefragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by alcohonsilver on 23/10/17.
 */

public class FragmentoUno extends Fragment {

    Button btn1;
    Button btn2;
    Button btn3;

    Com comunicacion;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragmento_uno, container);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState){

        super.onActivityCreated(savedInstanceState);

        comunicacion = (Com) getActivity();

        btn1 = (Button) getActivity().findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                comunicacion.responder("primer");
            }

        });

        btn2 = (Button) getActivity().findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                comunicacion.responder("segundo");
            }

        });

        btn3 = (Button) getActivity().findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                comunicacion.responder("tercero");

            }

        });



    }
}
