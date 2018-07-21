package com.example.david.calcularareaclase;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        final EditText lado1 = (EditText) this.findViewById(R.id.edLado1);
        final EditText lado2 = (EditText) this.findViewById(R.id.edLado2);
        final EditText resultado = (EditText) this.findViewById(R.id.edResultado);
        Button calcular = (Button) this.findViewById(R.id.btnCalcular);

        calcular.setEnabled(false);

        lado1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                MainActivity.this.calcula();
            }
        });

        /*calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double l1 = Double.parseDouble(lado1.getText().toString());
                double l2 = Double.parseDouble(lado2.getText().toString());
                String res = Double.toString( l1*l2) ;
                resultado.setText( res );
            }
        });*/


    }

    private void calcula(){
        double l1 = 0;
        double l2 = 0;
        final EditText lado1 = (EditText) this.findViewById(R.id.edLado1);
        final EditText lado2 = (EditText) this.findViewById(R.id.edLado2);
        final EditText resultado = (EditText) this.findViewById(R.id.edResultado);

        try{
            l1 = Double.parseDouble(lado1.getText().toString());
        }catch (NumberFormatException exc){
            Log.d( "MainActivity.calcula", "edLado2 vacía" );
        }
        l2 = Double.parseDouble(lado2.getText().toString());
        String res = Double.toString( l1*l2 );
        resultado.setText( res );


    }

}
