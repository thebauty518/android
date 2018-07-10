package com.example.user.appgrupal;

import android.content.AsyncTaskLoader;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText txtV1,txtV2,txtV3;
    Button btnCalcular;
    private RadioButton opcion;
    private RadioButton opcion2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        opcion= (RadioButton) findViewById(R.id.Suma);
        opcion2= (RadioButton) findViewById(R.id.Resta);
        txtV1=(EditText) findViewById(R.id.txtValor1);
        txtV2=(EditText) findViewById(R.id.txtValor2);
        txtV3=(EditText) findViewById(R.id.txtValor3);



    }
    public void ComprobarOperacion (View v){
        int uno =Integer.parseInt(txtV1.getText().toString());
        int dos =Integer.parseInt(txtV2.getText().toString());
        int tres =Integer.parseInt(txtV3.getText().toString());
        int suma= uno + dos + tres ;
        int resta= (uno-dos)-tres;
        if (opcion.isChecked()){
            final String text = "El Resultado es = "+suma;
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }else if (opcion2.isChecked()){
            final String text = "El Resultado es = "+resta;
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
    }
}
