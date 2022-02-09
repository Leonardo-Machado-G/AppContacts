//Asocio el paquete a la activity
package com.leonardoestudiante.appcontactos;

//Importo las librerias necesarias
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

//Declaro la clase y heredo
public class DetailContactActivity extends AppCompatActivity {

    //Variable que se usara para el intercambio de informacion
    public static String EXTRA_ID = "idVALUE";

    //Metodo que se ejecuta segun el ciclo de vida de una activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Asocio la activity al layout
        setContentView(R.layout.activity_detail_contact);

        //Obtengo el ID del intent
        long detailID = getIntent().getLongExtra(EXTRA_ID,1);

        //Declaramos un fragment manager para asociar el fragment
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Declaramos el listfragment
        DetailContactFragment detailFragment = new DetailContactFragment();
        detailFragment.setContactId(detailID);

        //Declaramos un fragmenttransaction para realizar transacciones
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Introducimos en el ID el nuevo fragment
        fragmentTransaction.replace(R.id.detail_fragment,detailFragment);

        //Cerramos la transaccion
        fragmentTransaction.commit();

        //Declaro una toolbar y la asocio al layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Establezco el boton para retroceder
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

}