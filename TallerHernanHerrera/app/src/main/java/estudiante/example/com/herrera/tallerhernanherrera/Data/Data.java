package estudiante.example.com.herrera.tallerhernanherrera.Data;

import java.util.Hashtable;

/**
 * Created by hherrera on 18/05/2017.
 */

public class Data {
    static public Hashtable<String, ComprasCategoria> CxC = new Hashtable<>();

    static public void AddCategoria (String Nombre){
        CxC.put(Nombre, new ComprasCategoria(Nombre));

    }
}
