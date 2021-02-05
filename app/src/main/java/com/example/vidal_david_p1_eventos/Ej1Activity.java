package com.example.vidal_david_p1_eventos;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ej1Activity extends AppCompatActivity implements View.OnClickListener {
    TextView contador;
    TextView limpiador;
    TextView mensaje;
    public int cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej1);
        contador = findViewById(R.id.button59);
        contador.setOnClickListener(this);
        limpiador = findViewById(R.id.button58);
        limpiador.setOnClickListener(this);
        mensaje = findViewById(R.id.textView10);
        mensaje.setOnClickListener(this);
        cont=0;


    }

    @Override
    public void onClick(View v) {


        if (v.getId()==R.id.button59 && cont==0)
        {
           cont++;
           mensaje.setText("Has pulsado "+cont+" vez");
           limpiador.setVisibility(View.VISIBLE);

        } else{
            cont++;
            mensaje.setText("Has pulsado "+cont+" veces");
        }

        if (v.getId()==R.id.button58){
            cont=0;
            mensaje.setText("");
            limpiador.setVisibility(View.INVISIBLE);
        }

    }
}
