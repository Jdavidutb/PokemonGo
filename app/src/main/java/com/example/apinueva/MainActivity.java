package com.example.apinueva;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

import static android.view.View.X;
import static android.view.View.Y;

public class MainActivity extends AppCompatActivity {

    Button verP, batalla;
    ImageView imagen1,imagen2;
    TextView texTname, texid,textexpe;
    TextView texTname2, texid2,textexpe2;
    String id, name, base_experience;

    Random num=new Random();
    int numero=num.nextInt(50)+1;
    Random num2=new Random();
    int numero2=num2.nextInt(50)+1;
    String JsonUrl= "https://pokeapi.co/api/v2/pokemon/"+numero;
    String JsonUrl2= "https://pokeapi.co/api/v2/pokemon/"+numero2;
    public void imga1(){
        Glide.with ( this ).load ( "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + numero + ".png" ).into ( imagen1 );
    }
    public void imga2(){
        Glide.with ( this ).load ( "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + numero2 + ".png" ).into ( imagen2 );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        verP=(Button)findViewById(R.id.button4);
        texTname=(TextView)findViewById(R.id.textView18);
        texid=(TextView)findViewById(R.id.textView16);
        textexpe=(TextView)findViewById(R.id.textView19);
        texTname2=(TextView)findViewById(R.id.textView11);
        texid2=(TextView)findViewById(R.id.textView13);
        textexpe2=(TextView)findViewById(R.id.textView14);
        imagen1=(ImageView)findViewById(R.id.image1);
        imagen2=(ImageView)findViewById(R.id.image2);
        batalla = (Button) findViewById ( R.id.buttonBatallar );
        batalla.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent siquiente = new Intent(MainActivity.this, Main2Activity.class);
                startActivity ( siquiente );
            }
        } );


      verP.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View view) {

Toast.makeText ( getApplicationContext (),"Se ha Cargado", Toast.LENGTH_SHORT ).show ();
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, JsonUrl, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {



                            try {
                                imga1 ();
                                id=response.getString("id");
                                name= response.getString("name");
                                base_experience =response.getString("base_experience");
                                texid.setText(id);
                                texTname.setText(name);
                                textexpe.setText(base_experience);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
                //agregando la respuesta Obtenida al Singleton del pokemon uno
                MySingletonPok1.getIntance(MainActivity.this).addRequest(jsonObjectRequest);

                JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.GET, JsonUrl2, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                             imga2 ();
                            id=response.getString("id");
                            name= response.getString("name");
                            base_experience =response.getString("base_experience");
                            texid2.setText(id);
                            texTname2.setText(name);
                            textexpe2.setText(base_experience);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                //agregando la respuesta Obtenida al Singleton del pokemon dos
                MySingletonPok2.getIntance(MainActivity.this).addRequest(jsonObjectRequest2);
            }



        });
    }





}
