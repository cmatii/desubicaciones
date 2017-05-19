package estudiante.example.com.herrera.tallerhernanherrera;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import estudiante.example.com.herrera.tallerhernanherrera.Data.Compra;
import estudiante.example.com.herrera.tallerhernanherrera.Data.Data;

import static android.R.layout.simple_list_item_1;

public class DetalleCategoria extends AppCompatActivity {

    String newString;
    String[] separated;
    @Override
    public void onResume(){
    //protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        super.onResume();
        setContentView(R.layout.activity_detalle_categoria);
        //if (savedInstanceState == null) {
        Bundle extras = getIntent().getExtras();
            //if(extras == null) {
            //    newString= null;
            //} else {
        newString= extras.getString("position");
        //    }
        //} else {
        //    newString= (String) savedInstanceState.getSerializable("position");
        //}
        separated=newString.split(":");
        newString=separated[0];
        TextView tv = (TextView)findViewById(R.id.categ);
        tv.setText("Detalle de "+newString);
        ListView detalle = (ListView) findViewById(R.id.tosti);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, simple_list_item_1);
        detalle.setAdapter(adapter);
        for(int x = 0; x< Data.CxC.get(newString).compras.size(); x++) {
            adapter.add(Data.CxC.get(newString).compras.get(x).getNombre()+": "+String.valueOf(Data.CxC.get(newString).compras.get(x).getPrecio()));
        }
        /*
        Button bt=(Button) findViewById(R.id.adddet);
        bt.setText("Añadir: "+newString);
        TextView total=(TextView) findViewById(R.id.total);
        total.setText(Integer.toString(Data.CxC.get(newString).Total));
        final EditText nom= (EditText) findViewById(R.id.NomDeta);
        final EditText pre= (EditText) findViewById(R.id.PrecioDeta);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String Result1= nom.getText().toString();
                String Result2= pre.getText().toString();
                Data.CxC.get(newString).AddCompra(new Compra( Result1, Integer.parseInt(Result2)));
                adapter.notifyDataSetChanged();
                Intent intent = new Intent(DetalleCategoria.this, Perfil.class);
                startActivity(intent);

            }
        });*/

        Button bt=(Button) findViewById(R.id.adddet);
        bt.setText("Añadir: "+newString);
        //TextView total=(TextView) findViewById(R.id.total);
        //total.setText(Integer.toString(Data.CxC.get(newString).Total));
        //final EditText nom= (EditText) findViewById(R.id.NomDeta);
        //final EditText pre= (EditText) findViewById(R.id.PrecioDeta);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder ab=new AlertDialog.Builder(DetalleCategoria.this);
                View abView = getLayoutInflater().inflate(R.layout.custom_popup,null);
                final EditText nombre= (EditText) abView.findViewById(R.id.nomdet);
                final EditText precio= (EditText) abView.findViewById(R.id.pecdet);
                Button con=(Button) abView.findViewById(R.id.confirmacion);
                Button can=(Button) abView.findViewById(R.id.cancelar);
                /*con.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(!nombre.getText().toString().isEmpty() && !precio.getText().toString().isEmpty()){
                            Data.CxC.get(newString).AddCompra(new Compra( nombre.getText().toString(), Integer.parseInt(precio.getText().toString())));
                            //Intent intent = new Intent(DetalleCategoria.this, Perfil.class);
                            //startActivity(intent);
                            adapter.add(nombre.getText().toString()+": "+precio.getText().toString());
                            adapter.notifyDataSetChanged();
                         Toast.makeText(DetalleCategoria.this,"Detalle añadido a la lista de "+newString,Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(DetalleCategoria.this,"Debes ingresar todos los datos",Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/
                ab.setView(abView);
                final AlertDialog a=ab.create();
                a.show();
                con.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(!nombre.getText().toString().isEmpty() && !precio.getText().toString().isEmpty()){
                            Data.CxC.get(newString).AddCompra(new Compra( nombre.getText().toString(), Integer.parseInt(precio.getText().toString())));
                            //Intent intent = new Intent(DetalleCategoria.this, Perfil.class);
                            //startActivity(intent);
                            adapter.add(nombre.getText().toString()+": "+precio.getText().toString());
                            adapter.notifyDataSetChanged();
                            Toast.makeText(DetalleCategoria.this,"Detalle añadido a la lista de "+newString,Toast.LENGTH_SHORT).show();
                            a.dismiss();
                        }else{
                            Toast.makeText(DetalleCategoria.this,"Debes ingresar todos los datos",Toast.LENGTH_SHORT).show();
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


    }

}
