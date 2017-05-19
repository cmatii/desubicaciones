package estudiante.example.com.herrera.tallerhernanherrera.Data;

import java.util.ArrayList;

/**
 * Created by hherrera on 18/05/2017.
 */

public class ComprasCategoria {
    public int Total;
    public String Nombre;
    public ArrayList<Compra> compras = new ArrayList<>();

    public ComprasCategoria(String nombre){
        this.Nombre=nombre;
    }

    public void AddCompra (Compra compra){
        Total += compra.Precio;
        compras.add(compra);
    }

    public String toString(){
        return Nombre + ": " + Total;
    }
}
