package com.example.user.appgrupal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private EditText Nusuario;
   private EditText Correo;
   private EditText Contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nusuario = (EditText)findViewById(R.id.Nusuario);
        Correo =(EditText)findViewById(R.id.Correo);
        Contraseña= (EditText)findViewById(R.id.Contraseña);
        SharedPreferences Preferencias = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        String Nombre = Preferencias.getString("Nombre","");
        String Correo=Preferencias.getString("Correo","");
        String Contraseña=Preferencias.getString("Contraseña","");
        if (!Nombre.isEmpty() && !Correo.isEmpty() && !Contraseña.isEmpty()){
            Intent uno = new Intent(this,Main3Activity.class);
            startActivity(uno);

        }else{
          //que suga su curso
        }
        //guardar

}
    public void guardar(View view){
            SharedPreferences Preferencias = getSharedPreferences("Datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor Editos = Preferencias.edit();
            Editos.putString("Nombre",Nusuario.getText().toString());
            Editos.putString("Correo",Correo.getText().toString());
            Editos.putString("Contraseña",Contraseña.getText().toString());
            Editos.commit();
        Intent uno = new Intent(this,Main3Activity.class);
        startActivity(uno);
    }

    }