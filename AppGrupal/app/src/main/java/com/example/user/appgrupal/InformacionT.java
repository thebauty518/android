package com.example.user.appgrupal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class InformacionT extends AppCompatActivity {
    TextView NDocumento;
    TextView NombreE;
    TextView ApellidoE;
    ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_t);
        NDocumento=(TextView)findViewById(R.id.Numero);
        NombreE=(TextView)findViewById(R.id.NombreE);
        ApellidoE=(TextView)findViewById(R.id.ApellidoE);


        foto=(ImageView)findViewById(R.id.foto);
        Bundle Objeto= getIntent().getExtras();
        Entidad user= null;
        if (Objeto!=null){
            user = (Entidad) Objeto.getSerializable("entidad");
            NDocumento.setText(user.getNdocumento().toString());
            NombreE.setText(user.getNombre().toString());
            ApellidoE.setText(user.getApellido().toString());
            String Fotos= user.getNfoto().toString();
            // int resId= getResources().getIdentifier("R.drawable."+Fotos,null,null);

            foto.setImageResource(R.drawable.uno);
        }
    }
}
