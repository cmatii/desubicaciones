public class DetalleCategorias extends AppCompatActivity {
    String newString;
    String[] separated;

    @Override
    protected void onResume() {

        super.onResume();
        setContentView(R.layout.activity_detalle_categorias);
        Bundle extras = getIntent().getExtras();
        newString= extras.getString("item-seleccionado");


        separated=newString.split(":");
        newString=separated[0];
        TextView tv = (TextView)findViewById(R.id.tituloDetalleCategoria);
        tv.setText("Detalle de "+newString);
        final ListView detalle = (ListView) findViewById(R.id.listadoDetalleCategoria);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        detalle.setAdapter(adapter);
        for(int x=0;x<Data.CxC.get(newString).compras.size();x++) {
            adapter.add(Data.CxC.get(newString).compras.get(x).getNombre()+": "+String.valueOf(Data.CxC.get(newString).compras.get(x).getPrecio()));
        }
        //PopUp Edit-Borrar

        detalle.setClickable(true);
        detalle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder ab=new AlertDialog.Builder(DetalleCategorias.this);
                View abView = getLayoutInflater().inflate(R.layout.user_input_dialog_box3,null);
                Button borrar=(Button) abView.findViewById(R.id.BorrarPopUpDetalle);
                Button editar=(Button) abView.findViewById(R.id.EditarPopUpDetalle);
                ab.setView(abView);
                final AlertDialog a = ab.create();
                a.show();
                borrar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        adapter.remove(adapter.getItem(position));//Remueve el item a borrar del adapter
                        Data.CxC.get(newString).RemoveCompra(Data.CxC.get(newString).compras.get(position));//Resta el monto del item al total para mostrar el correcto en Perfil
                        Data.CxC.get(newString).compras.remove(Data.CxC.get(newString).compras.get(position));//Remueve el item Data
                        adapter.notifyDataSetChanged();
                        a.dismiss();
                    }
                });
                editar.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View view){
                                AlertDialog.Builder bc=new AlertDialog.Builder(DetalleCategorias.this);
                                View bcView = getLayoutInflater().inflate(R.layout.user_input_dialog_box,null);
                                final EditText nombre= (EditText) bcView.findViewById(R.id.NuevoItem);
                                final EditText precio= (EditText) bcView.findViewById(R.id.NuevoPrecio);
                                Button con=(Button) bcView.findViewById(R.id.aceptarPopup);
                                Button can=(Button) bcView.findViewById(R.id.cancelarPopup);
                                bc.setView(bcView);
                                final AlertDialog b = bc.create();
                                b.show();
                                con.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view){
                                        if(!nombre.getText().toString().isEmpty() && !precio.getText().toString().isEmpty()){
                                            Data.CxC.get(newString).RemoveCompra(Data.CxC.get(newString).compras.get(position));//Resta el monto del item al total para mostrar el correcto en Perfil
                                            Data.CxC.get(newString).compras.get(position).setNombre(nombre.getText().toString());//Edita el nombre del item
                                            Data.CxC.get(newString).compras.get(position).setPrecio( Integer.parseInt(precio.getText().toString()) );//Edita el precio del item
                                            adapter.remove(adapter.getItem(position));//Remueve el item del adapter
                                            adapter.insert(nombre.getText().toString()+": "+precio.getText().toString(), position);//Inserta el nuevo item editado en la misma posicion del adapter
                                            adapter.notifyDataSetChanged();
                                            Data.CxC.get(newString).EditTotal(Data.CxC.get(newString).compras.get(position));//Edita el nuevo total para mostrar el monto correcto en Perfil
                                            Toast.makeText(DetalleCategorias.this,"Detalle editado a la lista de "+newString,Toast.LENGTH_SHORT).show();
                                            b.dismiss();
                                        }else{
                                            Toast.makeText(DetalleCategorias.this,"Debes ingresar todos los datos",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                can.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view){
                                        b.dismiss();
                                    }
                                });

                                a.dismiss();
                            }
                        });

                    }


                //PopUp Edit-Borrar

        });

        //POPUPCATEGORIA
        Button mButton;
        mButton = (Button) findViewById(R.id.openUserInputDialog);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder ab=new AlertDialog.Builder(DetalleCategorias.this);
                View abView = getLayoutInflater().inflate(R.layout.user_input_dialog_box,null);
                final EditText nombre= (EditText) abView.findViewById(R.id.NuevoItem);
                final EditText precio= (EditText) abView.findViewById(R.id.NuevoPrecio);
                Button con=(Button) abView.findViewById(R.id.aceptarPopup);
                Button can=(Button) abView.findViewById(R.id.cancelarPopup);
                ab.setView(abView);
                final AlertDialog a = ab.create();
                a.show();
                con.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if(!nombre.getText().toString().isEmpty() && !precio.getText().toString().isEmpty()){
                            Data.CxC.get(newString).AddCompra(new Compra( nombre.getText().toString(), Integer.parseInt(precio.getText().toString())));

                            adapter.add(nombre.getText().toString()+": "+precio.getText().toString());
                            adapter.notifyDataSetChanged();
                            Toast.makeText(DetalleCategorias.this,"Detalle añadido a la lista de "+newString,Toast.LENGTH_SHORT).show();
                            a.dismiss();
                        }else{
                            Toast.makeText(DetalleCategorias.this,"Debes ingresar todos los datos",Toast.LENGTH_SHORT).show();
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
