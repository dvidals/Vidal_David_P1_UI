package com.example.vidal_david_p1_eventos;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import static java.lang.Math.round;


public class Ej3Activity extends AppCompatActivity implements View.OnClickListener {

    TextView valor;
    TextView mensaje;
    RadioButton aEuros;
    RadioButton aPts;
    TextView botonEj3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej3);
        valor=findViewById(R.id.valor);
        mensaje=findViewById(R.id.textView13);
        aEuros=findViewById(R.id.radioButton69);
        aPts=findViewById(R.id.radioButton68);
        botonEj3= findViewById(R.id.button4);


        botonEj3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String texto = mensaje.getText().toString();
        String texto2= valor.getText().toString();

        if (!aPts.isChecked() && !aEuros.isChecked()) {
            Toast.makeText(this, R.string.errorNoConversion, Toast.LENGTH_SHORT).show();



        }else if (v.getId()==R.id.button4 && valor.length()==0){
            mensaje.setText(R.string.errorValor);
        }else if (v.getId()==R.id.button4 && !isNumeric(texto2)){
            mensaje.setText(R.string.errorValorNoNumero);
            valor.setText("");

        } else {

            double numero = Double.parseDouble(texto2);
            final double cambio = 166.368;
            double conversionEuros = round(numero / cambio, 2);
            double conversionPts = round(numero * cambio,2);
            String resultadoEuros = String.valueOf(conversionEuros);
            String resultadoPts = String.valueOf(conversionPts);


            if (v.getId() == R.id.button4 && valor.length() > 0 && aEuros.isChecked()) {
                mensaje.setText(texto2+ " "+getString(R.string.equivalenciaPts)+" "+resultadoEuros+" "+getString(R.string.euros));
                valor.setText("");
            } else if (v.getId() == R.id.button4 && valor.length() > 0 && aPts.isChecked()) {
                mensaje.setText(texto2 + " "+getString(R.string.equivalenciaEuros)+ " "+resultadoPts+ " "+getString(R.string.pesetas));
                valor.setText("");
            }
        }


    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


}