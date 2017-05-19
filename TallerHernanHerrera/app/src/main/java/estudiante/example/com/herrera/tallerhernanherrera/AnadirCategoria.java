package estudiante.example.com.herrera.tallerhernanherrera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import estudiante.example.com.herrera.tallerhernanherrera.Data.Data;

public class AnadirCategoria extends AppCompatActivity {

    String cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_categoria);
        Button anadir= (Button) findViewById(R.id.anadir);
        anadir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                TextView categoria = (TextView) findViewById(R.id.nomcat);
                cat=categoria.getText().toString();
                if(!cat.isEmpty()){
                    Data.AddCategoria(cat);
                    Intent intent= new Intent(AnadirCategoria.this,Perfil.class);
                    startActivity(intent);}
                else{
                    Toast.makeText(AnadirCategoria.this,"Debes colocar un nombre a la categoria",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
