package estudiante.example.com.herrera.tallerhernanherrera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import estudiante.example.com.herrera.tallerhernanherrera.Data.Data;

import static android.R.layout.simple_list_item_1;

public class Perfil extends AppCompatActivity {
    @Override
    //protected void onCreate(Bundle savedInstanceState) {
    public void onResume(){
        super.onResume();
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Button anadir= (Button) findViewById(R.id.anadirc);
        anadir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent intent= new Intent(Perfil.this,AnadirCategoria.class);
                startActivity(intent);
            }
        });
        //Button anadir2= (Button) findViewById(R.id.anadird);
        //anadir2.setOnClickListener(new View.OnClickListener(){
        //    @Override
        //    public void onClick (View v){
        //        Intent intent= new Intent(Perfil.this,AnadirCategoria.class);
        //        startActivity(intent);
        //    }
        //});
        //Data.AddCategoria("Almuerzos");
        //Data.CxC.get("Almuerzos").AddCompra(new Compra( "Papas", 2000));
        //Data.CxC.get("Almuerzos").AddCompra(new Compra( "Tosti", 3000));
        //Data.CxC.get("Almuerzos").AddCompra(new Compra( "Torti", 1000));
        final ListView Categorias = (ListView) findViewById(R.id.PerfilCategorias);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, simple_list_item_1);
        Categorias.setAdapter(adapter);

        for(String key:Data.CxC.keySet()){
            adapter.add(Data.CxC.get(key).toString());
        }

        //Manejando ListView en Perfil
        Categorias.setClickable(true);
        Categorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Perfil.this, DetalleCategoria.class); //DetalleCategorias es su nueva pantalla a llenar
                String selectedValue=(String) Categorias.getItemAtPosition(position).toString();
                intent.putExtra("position",selectedValue);
                startActivity(intent);
            }
        });
        //Manejando ListView

        ListView Prestamos = (ListView) findViewById(R.id.PerfilPrestamo);
        ArrayAdapter<String> adapterP = new ArrayAdapter<String>(this, simple_list_item_1);
        Prestamos.setAdapter(adapterP);
    }
}
