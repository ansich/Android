package com.example.david.calculararea;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.david.calculararea.R.string.ancho;
import static com.example.david.calculararea.R.string.largo;

public class MainActivity extends AppCompatActivity{
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    @Override
    public void onCreate(Bundle appState) {
        super.onCreate(appState);
        this.setContentView(R.layout.activity_main);

        //Ahora eventos(?)
        EditText plargo = (EditText) this.findViewById(R.id.plargo);
        EditText pancho = (EditText) this.findViewById(R.id.pancho);
        Button calcular = (Button) this.findViewById(R.id.boton);

        calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcula();
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    private void calcula() {
        EditText largo = (EditText) this.findViewById(R.id.plargo);
        EditText ancho = (EditText) this.findViewById(R.id.pancho);
        TextView lblResult = (TextView) this.findViewById(R.id.lblResult);

        try {
            String value = largo.getText().toString();
            int l = Integer.parseInt(value);
            String value2 = ancho.getText().toString();
            int a = Integer.parseInt(value2);
            int result = l * a;
            String r = "El area es ";
            r += (Integer.toString(result));
            lblResult.setText(r);
        } catch (NumberFormatException exc) {
            lblResult.setText(R.string.label_default_result);
            Toast.makeText(this.getApplicationContext(), R.string.label_default_result, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2.connect();
        AppIndex.AppIndexApi.start(client2, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client2, getIndexApiAction());
        client2.disconnect();
    }
}

