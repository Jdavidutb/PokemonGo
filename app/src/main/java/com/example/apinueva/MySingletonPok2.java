package com.example.apinueva;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Random;

/**
 * Created by JOSELIN GASTELBONDO on 24/09/2017.
 */

public class MySingletonPok2 implements Hablidades {
private static MySingletonPok2 myIntancePok2;
    private RequestQueue requestQueue;
    private static Context conPok1;

    public MySingletonPok2(Context context) {

        conPok1=context;
        requestQueue=getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
if (requestQueue==null){

    requestQueue = Volley.newRequestQueue(conPok1.getApplicationContext());
}
return requestQueue;
    }

    public static synchronized MySingletonPok2 getIntance(Context context){
        if (myIntancePok2==null){
           myIntancePok2=new MySingletonPok2(context);
        }
        return myIntancePok2;
    }

    public<T>  void addRequest(Request request){
   requestQueue.add(request);

// implementando decorador clase Hablidades
    }

    @Override
    public int velocidad() {
        Random vel=new Random (  );
        int  Velocidad=vel.nextInt (300)+1;
        return Velocidad;
    }

    @Override
    public int fuerza() {
        Random fuer=new Random (  );
        int  fuerza=fuer.nextInt (300)+1;
        return fuerza;
    }

    @Override
    public int poderEspecial() {
        Random poder=new Random (  );
        int  PoderEs=poder.nextInt (300)+1;
        return PoderEs;
    }
}
