//Asocio el fragment con el paquete
package com.leonardoestudiante.appcontactos;

//Importo las librerias que voy a utilizar
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

//Declaro la clase y heredo
public class ListContactFragment extends ListFragment {

    //Defino una interfaz
    interface Listener{

        void itemClicked(long id);
    }

    //Declaro el listener que utilizare para comunicarme con el fragment
    private Listener listener;

    //Utilizo el listener para obtener el contexto
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        this.listener = (Listener) context;

    }

    //Metodo que sirve para enviar el ID a traves del metodo que tendran que heredar las clases
    @Override
    public void onListItemClick(@NonNull ListView L, @NonNull View v, int position, long id){

        if(listener != null){

            listener.itemClicked(id);

        }

    }

    //Declaro el constructor
    public ListContactFragment() {}
    public static ListContactFragment newInstance() {
        return new ListContactFragment();
    }

    //Metodo que se ejecuta segun el ciclo de vida del fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //Metodo que se ejecuta segun el ciclo de vida del fragment
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Obtenemos el contexto
        Contact.context = getActivity();

        //Declaramos un vector vacio
        String[] names = new String[Contact.listContacts.size()];

        //Introducimos nombres en la lista
        for(int i = 0; i< names.length ; i++){

            //Introducimos el nombre
            names[i] = Contact.listContacts.get(i).getNameContact();
        }

        //Declaramos un adapter y le asociamos el vector y un tipo de lista
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, names);

        //Asociamos el adapter
        setListAdapter(adapter);

        //Devolvemos el layout, context, y bundle
        return super.onCreateView(inflater,container,savedInstanceState);
    }

}