package estudiante.example.com.herrera.tallerhernanherrera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnButtonClickEnter(View v)  ////ingreso de texto son los view
    {
        TextView Usuario = (TextView) findViewById(R.id.MainUser);
        TextView Pass = (TextView) findViewById(R.id.MainPass);
        if(Usuario.getText().toString().equals("Pedro")){
            if(Pass.getText().toString().equals("Petra")){
                startActivity(new Intent(this, Perfil.class));
            }
            else{
                Toast.makeText(this, "Error en Pass", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
        }
    }
}
