package net.ivanvega.manejodefragmentos;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by alcohonsilver on 23/10/17.
 */

public class Fragmento2 extends Fragment {

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:

                Toast toast1 =
                        Toast.makeText(null,
                                "Toast por defecto", Toast.LENGTH_SHORT);

                toast1.show();
                return true;




            case R.id.item2:

                Toast toast2 =
                        Toast.makeText(null,
                                "Toast por defecto", Toast.LENGTH_SHORT);

                toast2.show();
                return true;



            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void changetxt(String texto){
        edittext.setText(texto);
    }


}
