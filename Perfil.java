package alguello.com.example.estudiante.tallercarlosalguello;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import alguello.com.example.estudiante.tallercarlosalguello.Data.Compra;
import alguello.com.example.estudiante.tallercarlosalguello.Data.ComprasCategoria;
import alguello.com.example.estudiante.tallercarlosalguello.Data.Data;


public class Perfil extends AppCompatActivity {



    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_perfil);


        final ListView Categorias = (ListView) findViewById(R.id.PerfilCategorias);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        Categorias.setAdapter(adapter);



        for(String key:Data.CxC.keySet()){
            adapter.add(Data.CxC.get(key).toString());
        }
    //Manejando ListView Categoria
        Categorias.setClickable(true);
        Categorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Perfil.this, DetalleCategorias.class);
                String tipoCategoria = (String) Categorias.getItemAtPosition(position).toString();
                intent.putExtra("item-seleccionado", tipoCategoria);

                startActivity(intent);
            }
        });


        //POPUP CATEGORIA
        Button mButton;
        //final Context c = this;
        mButton = (Button) findViewById(R.id.añadirCategoriaPerfil);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder ab=new AlertDialog.Builder(Perfil.this);
                View abView = getLayoutInflater().inflate(R.layout.user_input_dialog_box2,null);
                final EditText nombre= (EditText) abView.findViewById(R.id.NuevoItemPerfil);
                Button con=(Button) abView.findViewById(R.id.aceptarPopupPerfil);
                Button can=(Button) abView.findViewById(R.id.cancelarPopupPerfil);
                ab.setView(abView);
                final AlertDialog a = ab.create();
                a.show();
                con.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(!nombre.getText().toString().isEmpty() ){
                            Data.AddCategoria(nombre.getText().toString());
                            Toast.makeText(Perfil.this,"Nueva categoria añadida",Toast.LENGTH_SHORT).show();

                            adapter.add(Data.CxC.get(nombre.getText().toString()).toString());
                            adapter.notifyDataSetChanged();
                            a.dismiss();
                        }else{
                            Toast.makeText(Perfil.this,"Debes ingresar todos los datos",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                can.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        a.dismiss();
                    }
                });

            }
        });

        //POPUPCATEGORIA

    //Manejando ListView Prestamo
        final ListView Prestamos = (ListView) findViewById(R.id.PerfilPrestamo);
        final ArrayAdapter<String> adapterP = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        Prestamos.setAdapter(adapterP);

        //
        for(String key:Data.PxC.keySet()){
            adapterP.add(Data.PxC.get(key).toString());
        }
        //Manejando ListView
        Prestamos.setClickable(true);
        Prestamos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Perfil.this, DetallePrestamos.class);
                String tipoPrestamo = (String) Prestamos.getItemAtPosition(position).toString();
                intent.putExtra("item-seleccionado", tipoPrestamo);

                startActivity(intent);
            }
        });
        //
        //POPUP Prestamo
        Button mButton2;
        mButton2 = (Button) findViewById(R.id.añadirPrestamoPerfil);
        mButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder ab2=new AlertDialog.Builder(Perfil.this);
                View abView = getLayoutInflater().inflate(R.layout.user_input_dialog_box2,null);
                final EditText nombre= (EditText) abView.findViewById(R.id.NuevoItemPerfil);
                Button con=(Button) abView.findViewById(R.id.aceptarPopupPerfil);
                Button can=(Button) abView.findViewById(R.id.cancelarPopupPerfil);
                ab2.setView(abView);
                final AlertDialog a2 = ab2.create();
                a2.show();
                con.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(!nombre.getText().toString().isEmpty() ){
                            Data.AddPrestamo(nombre.getText().toString());
                            Toast.makeText(Perfil.this,"Nuevo Prestamo añadido",Toast.LENGTH_SHORT).show();

                            adapterP.add(Data.PxC.get(nombre.getText().toString()).toString());
                            adapterP.notifyDataSetChanged();
                            a2.dismiss();
                        }else{
                            Toast.makeText(Perfil.this,"Debes ingresar todos los datos",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                can.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        a2.dismiss();
                    }
                });

            }
        });

        //POPUPCATEGORIA




    }
}
