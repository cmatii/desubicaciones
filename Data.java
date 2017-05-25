package alguello.com.example.estudiante.tallercarlosalguello.Data;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by estudiante on 12-05-17.
 */

public class Data {
    static public Hashtable<String, ComprasCategoria> CxC = new Hashtable<>();
    static public Hashtable<String, ComprasCategoria> PxC = new Hashtable<>();

    static public void AddCategoria (String Nombre){
        CxC.put(Nombre, new ComprasCategoria(Nombre));
    }
    static public void AddPrestamo (String Nombre){
        PxC.put(Nombre, new ComprasCategoria(Nombre));
    }

}
