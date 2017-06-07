public class ComprasCategoria {
    public int Total;
    public String Nombre;
    //cambio compras private a public
    public ArrayList<Compra> compras = new ArrayList<>();

    public ComprasCategoria(String nombre){
        this.Nombre=nombre;
    }

    public void AddCompra (Compra compra){
        Total += compra.Precio;
        compras.add(compra);
    }

    public void EditTotal(Compra compra){ //Funcion para editar el nuevo total de los montos
        Total += compra.Precio;
    }

    public void RemoveCompra(Compra compra){ //Funcion para remover una compra del total
        Total = Total - compra.Precio;
    }
    public String GetNombre (){
        return Nombre;

    }

    public String toString(){
        return Nombre + ": " + Total;
    }

}
