package com.devbaltasarq.listacompra;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;


public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private ArrayAdapter<String> itemsAdapter;
    private ArrayList<String> items;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        this.items = new ArrayList<String>();

        Button btAdd = (Button) this.findViewById( R.id.btAdd );
        ListView lvItems = (ListView) this.findViewById( R.id.lvItems );

        lvItems.setLongClickable( true );
        this.itemsAdapter = new ArrayAdapter<String>(
                this.getApplicationContext(),
                android.R.layout.simple_selectable_list_item,
                this.items
        );


        lvItems.setAdapter( this.itemsAdapter );

        //Apartado 1.3 practica sobre listas
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int pos, long l) {

                if ( pos >= 0 ) {

                    final AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);

                    alerta.setTitle("Modificar o elminar");
                    alerta.setMessage("¿Desea elminar o modificar el elemento?");
                    alerta.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            MainActivity.this.items.remove( pos );
                            MainActivity.this.itemsAdapter.notifyDataSetChanged();
                            MainActivity.this.updateStatus();
                        }

                    });

                    alerta.setNegativeButton("Modificar", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            final AlertDialog.Builder alerta2 = new AlertDialog.Builder(MainActivity.this);

                            final EditText edMod = new EditText(MainActivity.this.getApplicationContext());

                            alerta2.setTitle("Modifcar elemento de la lista");
                            alerta2.setMessage("Introduzca el nuevo valor");
                            alerta2.setView(edMod);
                            alerta2.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    MainActivity.this.items.set(pos,edMod.getText().toString());
                                }
                            });

                            alerta2.setNegativeButton("Cancelar", null);
                            alerta2.create().show();
                        }
                    });
                    alerta.create().show();

                }
                return false;
            }
        });

        //Apartado 1.4 practica sobre listas
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                if(position >= 0){

                    AlertDialog.Builder alertanueva = new AlertDialog.Builder(MainActivity.this);
                    final EditText edMensaje = new EditText(MainActivity.this.getApplicationContext());

                    alertanueva.setTitle("Modificar elemento");
                    alertanueva.setMessage("Introduzca el nuevo nombre");
                    alertanueva.setView(edMensaje);

                    alertanueva.setPositiveButton("Modifcar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            AlertDialog.Builder alertasalir = new AlertDialog.Builder(MainActivity.this);
                            alertasalir.setTitle("Alerta sobre la modificacion");
                            alertasalir.setMessage("¿Esta seguro que quiere modificar?");

                            alertasalir.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    MainActivity.this.items.set(position,edMensaje.getText().toString());
                                }
                            });
                            alertasalir.setNegativeButton("No", null);
                            alertasalir.create().show();
                        }
                    });

                    alertanueva.setNegativeButton("Salir", null);
                    alertanueva.create().show();


                }
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.onAdd();
            }
        });
    }


    private void onAdd() {
        final EditText edText = new EditText( this.getApplicationContext() );

        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle("A comprar...");
        builder.setMessage( "Nombre" );
        builder.setView( edText );
        builder.setPositiveButton( "+", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                final String text = edText.getText().toString();

                MainActivity.this.itemsAdapter.add( text );
                MainActivity.this.updateStatus();
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.create().show();
    }


    private void updateStatus() {
        TextView txtNum = (TextView) this.findViewById( R.id.lblNum );
        txtNum.setText( Integer.toString( this.itemsAdapter.getCount() ) );
    }


}
