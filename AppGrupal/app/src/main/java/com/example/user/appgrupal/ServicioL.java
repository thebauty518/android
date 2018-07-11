package com.example.user.appgrupal;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ServicioL extends AppCompatActivity {
    private EditText NDocumento, Nombre, Profesion;


    ListView Lista;
    ArrayList<String> Informacion;
    ArrayList<Entidad> ListaUsuario;
    adminSQLopenHelper Admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_l);

        Lista =(ListView)findViewById(R.id.Listar);
        Admin = new adminSQLopenHelper(getApplicationContext(),"BaseDeDatos",null,1);
        consultalista();
        ArrayAdapter Adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Informacion);
        Lista.setAdapter(Adaptador);
        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String Informacion = "Numero de Documento = "+ListaUsuario.get(position).getNdocumento()+"\n";
                Informacion="Nombre = "+ListaUsuario.get(position).getNombre()+"\n";
                Informacion="Apellido = "+ListaUsuario.get(position).getApellido()+"\n";

                Entidad Usuario = ListaUsuario.get(position);
                Intent Intento = new Intent(ServicioL.this,InformacionT.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("entidad", (Serializable) Usuario);
                Intento.putExtras(bundle);
                startActivity(Intento);
            }
        });


    }

    private void consultalista() {
        SQLiteDatabase db= Admin.getReadableDatabase();
        Entidad Entidades= null;
        ListaUsuario = new ArrayList<Entidad>();
        Cursor cursor= db.rawQuery("select * from Empleado where  Profesion = 'servicio de limpieza'",null);
        while(cursor.moveToNext()){
            Entidades = new Entidad();
            Entidades.setNdocumento(cursor.getString(0));
            Entidades.setNombre(cursor.getString(1));
            Entidades.setApellido(cursor.getString(2));
            Entidades.setCategoria(cursor.getString(3));
            Entidades.setProfesion(cursor.getString(4));
            Entidades.setDireccion(cursor.getString(5));
            Entidades.setTelefono(cursor.getString(6));
            Entidades.setEmail(cursor.getString(7));
            Entidades.setNfecha(cursor.getString(8));
            Entidades.setNfoto(cursor.getString(9));
            ListaUsuario.add(Entidades);
            obtenerLista();
        }

    }


    //OBTIENE LA LISTA

    private void obtenerLista() {
        Informacion = new ArrayList<String>();
        for (int i= 0; i<ListaUsuario.size();i++){
            Informacion.add("\n"+"Nombre: "+ListaUsuario.get(i).getNombre()+"\n"+"Apellido: "+ListaUsuario.get(i).getApellido()+"\n"+"Email  : "+ListaUsuario.get(i).getEmail()+"\n");
        }
    }



    //metodo registrar
    public void Registrar(View view){
        adminSQLopenHelper admin = new adminSQLopenHelper(this, "BaseDeDatos", null, 1 );
        SQLiteDatabase BaseDeDatos =admin.getReadableDatabase();

        String Ndocumento= NDocumento.getText().toString();
        String Nombres = Nombre.getText().toString();
        String Profesiones= Profesion.getText().toString();
        if (!Ndocumento.isEmpty() && !Nombres.isEmpty() && !Profesiones.isEmpty()){
            ContentValues Registro = new ContentValues();
            Registro.put("NDocumento", Ndocumento);
            Registro.put("Nombre", Nombres);
            Registro.put("Profesion", Profesiones);
            BaseDeDatos.insert("Empleado",null, Registro);
            BaseDeDatos.close();
            NDocumento.setText("");
            Nombre.setText("");
            Profesion.setText("");
            Toast.makeText(this,"Registro Realizado con exito :v", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

    }
    //buscar
    public void Buscar(View view){
        adminSQLopenHelper admin = new adminSQLopenHelper(this, "BaseDeDatos", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        String NDocumentos = NDocumento.getText().toString();

        if (!NDocumentos.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery
                    ("select Nombre,Profesion from Empleado where NDocumento="+NDocumentos, null);
            if (fila.moveToFirst()){
                Nombre.setText(fila.getString(0));
                Profesion.setText(fila.getString(1));
                BaseDeDatos.close();
            }else{
                Toast.makeText(this,"Noexiste un empleado con este Numero", Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }
        }else{
            Toast.makeText(this,"Debes especificar el numero de documento", Toast.LENGTH_SHORT).show();
        }
    }

    //Eliminar
    public void eliminar (View view){
        adminSQLopenHelper Admin = new adminSQLopenHelper(this,"BaseDeDatos",null,1);
        SQLiteDatabase base = Admin.getWritableDatabase();
        String NDocumentos= NDocumento.getText().toString();
        if (!NDocumentos.isEmpty()){
            int cantidad = base.delete("Empleado","NDocumento="+NDocumentos,null);
            base.close();
            NDocumento.setText("");
            Nombre.setText("");
            Profesion.setText("");
            if (cantidad>0){
                Toast.makeText(this,"El Empleado ha sido eliminado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Este men no existe :'v", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Debes especificar el numero de documento", Toast.LENGTH_SHORT).show();
        }
    }
    //modificar
    public void Modificar (View view){
       adminSQLopenHelper Admin = new adminSQLopenHelper(this,"BaseDeDatos",null,1);
        SQLiteDatabase Base = Admin.getWritableDatabase();
        String Ndocumento= NDocumento.getText().toString();
        String Nombres = Nombre.getText().toString();
        String Profesiones= Profesion.getText().toString();

        if (!Ndocumento.isEmpty() && !Nombres.isEmpty() && !Profesiones.isEmpty()){
            ContentValues Registro = new ContentValues();
            Registro.put("NDocumento",Ndocumento);
            Registro.put("Nombre",Nombres);
            Registro.put("Profesion",Profesiones);
            int cantidad = Base.update("Empleado", Registro, "NDocumento="+Ndocumento, null);
            Base.close();
            if (cantidad>0){
                Toast.makeText(this,"Se ha actualizado el empleado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Este men no existe :'v", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Debes especificar el numero de documento", Toast.LENGTH_SHORT).show();
        }

    }

}
