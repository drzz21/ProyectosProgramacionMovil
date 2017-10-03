package com.dios.permisos_peligrosos;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.dios.permisos_peligrosos.R.id.lblPeligro;


public class MainActivity extends AppCompatActivity {

    private static final int SOLICITUD_PERMISO_CALL_PHONE = 1;
    private Intent intentLLamada;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentLLamada = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "*333"));
        Button btnLlamada = (Button)findViewById(R.id.btnLlamar);



        btnLlamada.setOnClickListener(new View.OnClickListener() { // hago clic en el botón
            @Override
            public void onClick(View v) {
                //solicitarPermisoHacerLlamada();
                pedirHacerllamada();

            }
        });







    }

    public void pedirHacerllamada(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

            TextView lblPeligro = (TextView)findViewById(R.id.lblPeligro);
            lblPeligro.setVisibility(View.INVISIBLE);
            startActivity(intentLLamada);

        } else {
            explicarUsoPermiso();
            solicitarPermisoHacerLlamada();

        }

    }

    private void explicarUsoPermiso() {

        //Para ver si se marco no volver a preguntar
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
            alertDialogBasico();
        }
    }

    private void solicitarPermisoHacerLlamada() {

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE},
                SOLICITUD_PERMISO_CALL_PHONE);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == SOLICITUD_PERMISO_CALL_PHONE) {

            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                startActivity(intentLLamada);






            } else {



            }
        }
    }

    public void alertDialogBasico() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_message);


        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });


        builder.show();

    }

}
