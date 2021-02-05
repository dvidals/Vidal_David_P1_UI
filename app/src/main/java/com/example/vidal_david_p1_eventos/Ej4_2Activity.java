package com.example.vidal_david_p1_eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Ej4_2Activity extends AppCompatActivity implements  View.OnClickListener{

    TextView nombreRecibido;
    TextView botonRetorno;
    CheckBox check;
    RadioButton adios;
    RadioButton hastaLuego;
    RadioGroup radio;
    String nombre;
    String nombreSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej4_2);

        nombreRecibido=findViewById(R.id.textView11);
        botonRetorno=findViewById(R.id.button4);
        check=findViewById(R.id.checkBox);
        adios=findViewById(R.id.radioButton4);
        hastaLuego=findViewById(R.id.radioButton3);
        radio = findViewById(R.id.radioGroup2);

        check.setOnClickListener(this);
        botonRetorno.setOnClickListener(this);



        Bundle datosDelIntent = getIntent().getExtras();


         nombre = datosDelIntent.getString("tratamiento")+" "+datosDelIntent.getString("nombre");
         nombreSimple= datosDelIntent.getString("nombre");

        nombreRecibido.setText(nombre);
        //Toast.makeText(this, "Nombre: "+nombre, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        final String textoAdios = adios.getText().toString();
        final String textoHastaLuego = hastaLuego.getText().toString();

        if (check.isChecked()){
            radio.setVisibility(View.VISIBLE);
        }

        if (v.getId()==R.id.button4 &&!check.isChecked()) {
            startActivity(new Intent(this, Ej4Activity.class));

        } else if (v.getId()==R.id.button4 && check.isChecked() && (!adios.isChecked() && !hastaLuego.isChecked())){
            Toast.makeText(this, R.string.errorDespedida, Toast.LENGTH_LONG).show();

        } else if (v.getId()==R.id.button4  && adios.isChecked()) {

            String mensaje = textoAdios+", "+ nombreSimple;

            startActivity(new Intent(this, Ej4Activity.class));
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();


        } else if (v.getId()==R.id.button4  && hastaLuego.isChecked()) {

            String mensaje = textoHastaLuego+", "+ nombreSimple;

            startActivity(new Intent(this, Ej4Activity.class));
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();


        }

//Prueba para GitHUb
    }
}