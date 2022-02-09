//Asocio la actividad al paquete
package com.leonardoestudiante.appcontactos;

//Importo las librerias necesarias
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

//Declaro la activity y heredo
public class ListContactActivity extends AppCompatActivity implements ListContactFragment.Listener {

    //Variable que conserva el ID del fragmento detalle
    //Es necesario que sea static debido a que si se dos veces el giro se resetea su valor
    private static long detailFragmentID;

    //Variable para recuperar la informacion de detail fragment
    private final static String FRAGMENT_VALUE = "fragmentVALUE";

    //Metodo que se ejecuta segun el ciclo de vida de una activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Asocio la activity a su layout
        setContentView(R.layout.activity_list_contact);

        //Llamamos al metodo para insertar un fragmentlist
        addListFragment();

        //Observo si el layout large esta vacio
        View fragmentContainer = findViewById(R.id.detail_fragment);

        //Si existen datos en el bundle los recuperamos
        if(savedInstanceState != null && fragmentContainer != null){

            //Declaramos un fragmentmanager para administrar fragments
            FragmentManager fragmentManager = getSupportFragmentManager();

            //Declaramos un detailfragment
            DetailContactFragment detailBundleFragment = new DetailContactFragment();

            //Insertamos en el fragment el valor recuperado del bundle
             detailBundleFragment.setContactId(savedInstanceState.getLong(FRAGMENT_VALUE));

            //Declaramos un fragmenttransaction para realizar transacciones
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //Introducimos el fragment
            fragmentTransaction.replace(R.id.detail_fragment,detailBundleFragment);

            //Cerramos la transaccion
            fragmentTransaction.commit();

        }

    }

    //Metodo para guardar informacion
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        //Insertamos nuestra ID en el bundle
        outState.putLong(FRAGMENT_VALUE,this.detailFragmentID);
        super.onSaveInstanceState(outState);

    }

    //Metodo para crear menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Obtengo el menu
        getMenuInflater().inflate(R.menu.menu_main,menu);

        //Declaramos un menu y le asociamos un ID
        MenuItem menuItem = menu.findItem(R.id.add_contact);

        //Asociamos un listener el item
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                //Declaramos un intent para crear contactos
                Intent Intent = new Intent(ListContactActivity.this, AddContactActivity.class);

                //Iniciamos el intent
                startActivity(Intent);

                return false;
            }

        });

        return super.onCreateOptionsMenu(menu);

    }

    //Metodo sobrescrito de la interfaz
    @Override
    public void itemClicked(long id) {

        //Observo si el layout large esta vacio
        View fragmentContainer = findViewById(R.id.detail_fragment);

        //Si no lo esta entro en el if
        if(fragmentContainer != null){

            //Declaramos un fragmentmanager para administrar fragments
            FragmentManager fragmentManager = getSupportFragmentManager();

            //Declaro un fragment
            DetailContactFragment detailFragment = new DetailContactFragment();

            //Asocio un ID al fragment
            detailFragment.setContactId(id);

            //Inserto en el ID para recuperar informacion su ID
            this.detailFragmentID = id;

            //Declaramos un fragmenttransaction para realizar transacciones
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //Introducimos en el ID el nuevo fragment
            fragmentTransaction.replace(R.id.detail_fragment,detailFragment);

            //Cerramos la transaccion
            fragmentTransaction.commit();

        } else {

            //Declaro un intent para la otra activity
            Intent intent = new Intent(this, DetailContactActivity.class);

            //Le inserto el ID del item pulsado que hemos obtenido mediante el listener
            intent.putExtra(DetailContactActivity.EXTRA_ID,id);

            //Iniciamos la activity
            startActivity(intent);

        }

    }

    //Metodo necesario para actualizar la lista o iniciar el primer fragment
    @Override
    protected void onResume() {
        super.onResume();

        //Llamamos al metodo para actualizar el fragment
        addListFragment();

    }

    //Metodo que se usara para actualizar la lista fragment o instanciarla
    private void addListFragment(){

        //Declaramos un fragmentmanager para administrar fragments
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Declaramos el listfragment
        ListContactFragment listFragment = new ListContactFragment();

        //Declaramos un fragmenttransaction para realizar transacciones
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Introducimos el fragment
        fragmentTransaction.replace(R.id.list_fragment,listFragment);

        //Cerramos la transaccion
        fragmentTransaction.commit();

        //Creamos una tool bar y la asociamos al layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}