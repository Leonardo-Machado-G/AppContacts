//Asociamos el paquete a la clase
package com.leonardoestudiante.appcontactos;

//Importamos las librerias necesarias
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Declaramos la clase
public class Contact {

    //Declaramos los atributos de contactos
    private String phoneContact;
    private String emailContact;
    private long imageContact;
    private String nameContact;

    //Usado para acceder a los recursos de la clase
    public static Context context = null;

    //Declaramos el array que contendra toda la informacion
    @SuppressLint({"UseCompatLoadingForDrawables", "ResourceType"})
    public static Contact[]contacts = {

            new Contact(

                    "123456789",
                    "contacto1@gmail.com",
                    R.drawable.fernando_simon,
                    "Fernardo Simón"),

            new Contact(

                    "9876543212",
                    "contacto2@gmail.com",
                    R.drawable.pablo_casado,
                    "Pablo Casado"),

            new Contact(

                    "112233445",
                    "contacto3@gmail.com",
                    R.drawable.pablo_iglesias,
                    "Pablo Iglesias"),

            new Contact(

                    "566778890",
                    "contacto5@gmail.com",
                    R.drawable.pedro_sanchez,
                    "Pedro Sanchez"),

            new Contact(

                    "321654987",
                    "contacto6@gmail.com",
                    R.drawable.salvador_illa,
                    "Salvador Illa"),

            new Contact(

                    "525522523",
                    "contacto7@gmail.com",
                    R.drawable.santiago_abascal,
                    "Santiago Abascal")

    };

    //Declaro una lista con toda la informacion
    public static List<Contact> listContacts = new LinkedList<Contact>(Arrays.asList(contacts));

    //Declaro el constructor
    Contact(String phone, String email, long image, String name){
        this.phoneContact = phone;
        this.emailContact = email;
        this.imageContact = image;
        this.nameContact = name;
    }

    //Declaro todos los get para cada atributo
    public String getPhoneContact() {
        return phoneContact;
    }
    public String getEmailContact() {
        return emailContact;
    }
    public long getImageContact() {
        return imageContact;
    }
    public String getNameContact() {
        return nameContact;
    }

    //Devolvemos el string a traves del contexto de esta clase
    @Override
    public String toString(){
        return this.nameContact;
    }

}
