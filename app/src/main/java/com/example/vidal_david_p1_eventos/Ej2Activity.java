package com.example.vidal_david_p1_eventos;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class Ej2Activity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup radio;
    TextView despedida;
    CheckBox check;
    RadioButton sr;
    RadioButton sra;
    RadioButton adios;
    RadioButton hastaLuego;
    EditText nombre;
    TextView linea1;
    TextView linea2;
    TextView boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej2);
        radio = findViewById(R.id.radioGroup2);
        despedida = findViewById(R.id.textView14);
        check = findViewById(R.id.checkBox);
        nombre=findViewById(R.id.valor);
        linea1=findViewById(R.id.textView12);
        linea2=findViewById(R.id.textView13);
        boton=findViewById(R.id.button4);
        sr=findViewById(R.id.radioButton);
        sra=findViewById(R.id.radioButton2);
        adios=findViewById(R.id.radioButton3);
        hastaLuego=findViewById(R.id.radioButton4);


        check.setOnClickListener(this);
        boton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        final String textoNombre = nombre.getText().toString();
        final String textoBoton = boton.getText().toString();
        final String textoSr = sr.getText().toString();
        final String textoSra = sra.getText().toString();
        final String textoAdios = adios.getText().toString();
        final String textoHastaLuego = hastaLuego.getText().toString();

        //Primera línea:

        // Toast tratamiento:

        if (!sr.isChecked() && !sra.isChecked()) {
            Toast.makeText(this, R.string.errorTratamiento, Toast.LENGTH_SHORT).show();

            // texto primera línea:

        }else if (v.getId()==R.id.button4 && textoNombre.length()==0){
            linea1.setVisibility(View.VISIBLE);
            linea1.setText(R.string.errorNombre);

        } else if (v.getId()==R.id.button4 && textoNombre.length()>0 && sr.isChecked()){
            linea1.setText(textoBoton+ ", "+ textoSr +" " + separaPalabrasPrimeraMayus(textoNombre));
            nombre.setText("");
        } else if (v.getId()==R.id.button4 && textoNombre.length()>0 && sra.isChecked()) {
            linea1.setText(textoBoton+ ", "+ textoSra +" " + separaPalabrasPrimeraMayus(textoNombre));
            nombre.setText("");
        }

        // segunda línea:

        //visibilidad:

        if (check.isChecked()) {
            radio.setVisibility(View.VISIBLE);
            despedida.setVisibility(View.VISIBLE);

        } else {
            radio.setVisibility(View.INVISIBLE);
            despedida.setVisibility(View.INVISIBLE);
        }

        // texto segunda lúnea:

        if (adios.isChecked() && textoNombre.length()>0) linea2.setText(textoAdios);
        else if(hastaLuego.isChecked() && textoNombre.length()>0)linea2.setText(textoHastaLuego);

    }
    //explode
    public static String primeraM(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        } else {
            return  Character.toUpperCase(str.charAt(0)) + str.substring(1, str.length()).toLowerCase();
        }
    }
    public static String separaPalabrasPrimeraMayus(String foo) {
        String[] split = foo.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(primeraM(split[i]));
            if (i != split.length - 1) {
                sb.append(" ");
            }

        }
       return  sb.toString();
    }

}