package com.example.vidal_david_p1_eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void toEj1(android.view.View view) {
        startActivity(new Intent(getApplicationContext(),Ej1Activity.class));
    }
    public void toEj2(android.view.View view) {
        startActivity(new Intent(getApplicationContext(),
                Ej2Activity.class));
    }
    public void toEj3(android.view.View view) {
        startActivity(new Intent(getApplicationContext(),Ej3Activity.class));
    }

    public void toEj4(android.view.View view) {
        startActivity(new Intent(getApplicationContext(),Ej4Activity.class));
    }


}