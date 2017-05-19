package estudiante.example.com.herrera.tallerhernanherrera.Data;

/**
 * Created by hherrera on 18/05/2017.
 */

public class Compra {
    int Precio;
    String Nombre= "";

    public int getPrecio() {
        return Precio;
    }

    public Compra(String nombre, int precio ){
        this.Nombre=nombre;
        this.Precio=precio;
    }

    public String getNombre() {
        return Nombre;
    }
}
