//Declaro el paquete
package com.leonardoestudiante.appcontactos;

//Importo las librerias necesarias
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

//Declaro la clase y heredo
public class AddContactActivity extends AppCompatActivity {

    //Metdo que se ejecuta en funcion del ciclo de la activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        //Establezco un boton para crear el nuevo contacto
        Button sendData = (Button)findViewById(R.id.button_send_data);

        //Le asocio un listener
        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Declaro un edittext y le asocio un id
                EditText newName = (EditText)findViewById(R.id.name_contact_text);
                //Declaro la variable para insertar en el contacto
                String name = newName.getText().toString();

                //Declaro un edittext y le asocio un id
                EditText newPhone = (EditText)findViewById(R.id.phone_contact_text);
                //Declaro la variable para insertar en el contacto
                String phone = newPhone.getText().toString();

                //Declaro un edittext y le asocio un id
                EditText newEmail = (EditText)findViewById(R.id.email_contact_text);
                //Declaro la variable para insertar en el contacto
                String email = newEmail.getText().toString();

                //Declaro un nuevo contacto y le establezco una imagen predeterminada
                Contact newContact = new Contact(

                        phone,
                        email,
                        R.drawable.ic_launcher_background,
                        name);

                //Asocio el contexto
                Contact.context = AddContactActivity.this;

                //Añado el contacto
                Contact.listContacts.add(newContact);

                //Destruyo la activity
                finish();

            }

        });

    }

}