package com.example.apinueva;

import android.app.VoiceInteractor;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Main2Activity extends AppCompatActivity {
    TextView velocidad1;
    Button Inicia;
    TextView ver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main2 );


        // intenté descargar los datos onbtenidos en el singletonpokemon1 pero me salior erroe en el uso del toMap (solo en el parametro)lo demas salio bien
     // JSONObject obje =new JSONObject ( (Map) MySingletonPok1.getIntance ( this ) ); //objeto de tipo jSon de la clase MySingletonPok1
      //  Map<String,Object> obje1 = toMap();

        velocidad1 =(TextView)findViewById ( R.id.textView2);

  final int fuerza1 =  MySingletonPok1.getIntance (this ).fuerza ();
        int velocidad =MySingletonPok1.getIntance (this ).velocidad ();
        final int poderEspecial=MySingletonPok1.getIntance (this ).poderEspecial ();
        final int velocidad2=MySingletonPok2.getIntance (this ).poderEspecial ();
        final int fuerza2=MySingletonPok2.getIntance (this ).poderEspecial ();
        final int poderEspecial2=MySingletonPok2.getIntance (this ).poderEspecial ();
        velocidad1.setText ( velocidad );


    Inicia=(Button)findViewById ( R.id.ButIniciar );
        Inicia.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                int sumahablidad1=fuerza1+velocidad2+poderEspecial;
                int sumahablidad2=fuerza2+velocidad2+poderEspecial2;

                 if(sumahablidad1 > sumahablidad2){

                 }else
                     if ((sumahablidad1<sumahablidad2)){

                     }

                ver =(TextView)findViewById ( R.id.VerInf );
                ver.setText ( fuerza1 );
                System.out.print ( "fuerza "+  fuerza1 );
            }
        } );





    }




}
