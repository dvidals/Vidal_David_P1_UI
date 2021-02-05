package com.example.vidal_david_p1_eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/*
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
 */

public class Ej4Activity extends AppCompatActivity implements View.OnClickListener{
	RadioGroup radio;
	RadioButton sr;
	RadioButton sra;
	EditText nombre;
	TextView boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej4);
		radio= findViewById(R.id.radioGroup3);
		nombre=findViewById(R.id.valor2);
		boton=findViewById(R.id.button41);
		sr=findViewById(R.id.radioButton);
		sra=findViewById(R.id.radioButton2);

		boton.setOnClickListener(this);
    }
	
	
	@Override
    public void onClick(View v) {
		
		final String textoNombre=nombre.getText().toString();
		final String textoSr=sr.getText().toString();
		final String textoSra=sra.getText().toString();

        if (v.getId()==R.id.button41 && textoNombre.length()==0){
            Toast.makeText(this, R.string.errorNombre, Toast.LENGTH_LONG).show();

		 }else if (!sr.isChecked() && !sra.isChecked()) {
            Toast.makeText(this, R.string.errorTratamiento, Toast.LENGTH_LONG).show();


        } else if(v.getId()==R.id.button41 && textoNombre.length()>0 && sr.isChecked()){


            Intent intent = new Intent(this, Ej4_2Activity.class);

            //intent.putExtra("nombre",  textoSr +" " + separaPalabrasPrimeraMayus(textoNombre));
            intent.putExtra("tratamiento",  textoSr );
            intent.putExtra("nombre",  separaPalabrasPrimeraMayus(textoNombre));
            startActivity(intent);

        } else if(v.getId()==R.id.button41 && textoNombre.length()>0 && sra.isChecked()){


            Intent intent = new Intent(this, Ej4_2Activity.class);
            //intent.putExtra("nombre",  textoSra +" " + separaPalabrasPrimeraMayus(textoNombre));
            intent.putExtra("tratamiento",  textoSra );
            intent.putExtra("nombre",  separaPalabrasPrimeraMayus(textoNombre));
            startActivity(intent);

        }


    }
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