//Asocio el paquete con el fragment
package com.leonardoestudiante.appcontactos;

//Importo las librerias necesarias
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//Declaro la clase y heredo
public class DetailContactFragment extends Fragment {

    //Le asociamos al fragment su ID
    private long contactId;

    //Declaro el constructor
    public DetailContactFragment() {  }
    public static DetailContactFragment newInstance() {
        return new DetailContactFragment();
    }

    //Metodo que se ejecuta en funcion del ciclo de vida de un fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //Inserto estos elementos en el onstart para que de tiempo a insertar el ID
    @Override
    public void onStart() {
        super.onStart();

        //Creo la view para poder acceder a los metodo y serializo los elementos
        View view = getView();

        //Declaro los elementos y obtengo su id
        TextView textName = view.findViewById(R.id.text_detail_name);
        TextView textPhone = view.findViewById(R.id.text_detail_phone);
        TextView textEmail = view.findViewById(R.id.text_detail_email);
        ImageView imageView = view.findViewById(R.id.image_contact);

        //Establecemos los en funcion del contacto
        textName.setText(Contact.listContacts.get((int)contactId).getNameContact());
        textPhone.setText( Contact.listContacts.get((int)contactId).getPhoneContact());
        textEmail.setText(Contact.listContacts.get((int)contactId).getEmailContact());
        imageView.setImageResource((int) Contact.listContacts.get((int)contactId).getImageContact());

        //Establezco un comportamiento al hacer click en email
        textEmail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Declaro un intent para enviar informacion a las posibles aplicaciones que contengan esta funcion
                Intent intent = new Intent(Intent.ACTION_SEND);

                //Inserto el email del contacto en el intent
                intent.putExtra(Intent.ACTION_SEND,Contact.listContacts.get((int)contactId).getEmailContact());

                //Establezco el tipo de dato
                intent.setType("text/plain");

                //Inicio el intent
                startActivity(intent);
            }

        });

        //Establezco un comportamiento al hacer click en el telefono
        textPhone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Declaro un intent para enviar informacion a las posibles aplicaciones que contengan esta funcion
                Intent intent = new Intent(Intent.ACTION_DIAL);

                //Inserto el telefono del contacto en el intent
                intent.putExtra(Intent.ACTION_DIAL,""+Contact.listContacts.get((int)contactId).getPhoneContact());

                //Inicio el intent
                startActivity(intent);

            }

        });


    }

    //Metodo que se ejecuta en funcion del ciclo de vida de un fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_contact, container, false);

    }

    //Metodo que devuelve el ID del contacto
    public void setContactId(long id) {
        this.contactId = id;
    }

}