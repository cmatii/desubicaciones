public class Compra {
    int Precio;
    String Nombre= "";

    public Compra( String nombre, int precio ){
        this.Nombre=nombre;
        this.Precio=precio;
    }

    public String getNombre(){

        return Nombre;
    }

    public void setNombre(String nombre){ //Nueva funcion
        this.Nombre= nombre;
    }

    public int getPrecio(){
        return Precio;
    }

    public void setPrecio(int precio){ //Nueva Funcion
        this.Precio= precio;
    }


}
