package net.ivanvega.manejodefragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * Created by alcohonsilver on 23/10/17.
 */

public class FragemntoDos extends Fragment {

    EditText edittext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_fragmeno_dos,null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        edittext = (EditText) getActivity().findViewById(R.id.editText);
    }


    public void changetxt(String texto){
        edittext.setText(texto);
    }

}
