package net.ivanvega.notificacionesydialogos;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int ID_NOTIFICACION=1;

    String colores[] =
            new String[]
                    {"verde", "blanco", "rojo"};

    String generos_musicales[] =
            new String[]
                    {"rock", "clasica", "jazz", "pop", };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnInfo_click(View v){

        AlertDialog dialog =
                new AlertDialog.Builder(this)
                        .setTitle("Cuadro de dialogo")
                        .setIcon(android.R.drawable.ic_btn_speak_now)
                        .setMessage("Hola Mubndo desde Android")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Toast.makeText(MainActivity.this,
                                        "Presiono OK", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,
                                        "Presiono OK", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .create();

        dialog.show();


    }

    public void  btnList_click(View v){
        AlertDialog dialog =
                new AlertDialog.Builder(this)
                        .setTitle("Cuadro de dialogo")
                        .setIcon(R.mipmap.ic_launcher)
                        .setItems(colores, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,
                                        colores[which], Toast.LENGTH_SHORT)
                                        .show();
                                dialog.dismiss();
                            }
                        })
                        .create();

        dialog.show();
    }


    public void  btnCheckList_click(View v){
        AlertDialog dialog =
                new AlertDialog.Builder(this)
                        .setTitle("Cuadro de dialogo")
                        .setIcon(R.mipmap.ic_launcher)
                        
                        .setMultiChoiceItems(generos_musicales,
                                new boolean[]{true, false, true, false}
                                , new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        Toast.makeText(MainActivity.this,
                                                generos_musicales[which] + (isChecked? " Verificado": " No Verificado"),
                                                Toast.LENGTH_SHORT)
                                                .show();
                                    }
                                })
                        .create();

        dialog.show();
    }

    public void btnNotificacion_click(View v){
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("jeje"));
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);

        NotificationCompat.Builder builder= new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        builder.setContentTitle("Notificacion >:v");
        builder.setContentText("Notificacion simple");
        builder.setSubText("Subtitulo");

        //Enviar la notificacion
        NotificationManager notificationManager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(ID_NOTIFICACION,builder.build());
    }



}
