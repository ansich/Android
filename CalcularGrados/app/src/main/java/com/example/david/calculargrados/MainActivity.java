package com.example.david.calculargrados;

import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText cel_result = (EditText) this.findViewById(R.id.edCelsius);
        final EditText far_result = (EditText) this.findViewById(R.id.edFarenheit);


        cel_result.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(cel_result.hasFocus()) {
                    MainActivity.this.calcularF();
                }
            }
        });

        far_result.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(far_result.hasFocus()) {
                    MainActivity.this.calcularC();
                }
            }
        });



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void calcularF() {
        EditText cel_result = (EditText) this.findViewById(R.id.edCelsius);
        EditText far_result = (EditText) this.findViewById(R.id.edFarenheit);

        try {
            String cel = cel_result.getText().toString();
            double c = Double.parseDouble(cel);
            double f_f;
            f_f = (1.8 * c) + 32;
            String f_f_f = Double.toString(f_f);
            far_result.setText(f_f_f);
        } catch (NumberFormatException exc) {
            far_result.setText(R.string.v_i);
            Toast.makeText(this.getApplicationContext(), R.string.error, Toast.LENGTH_SHORT).show();
        }
    }

    private void calcularC() {
        EditText cel_result = (EditText) this.findViewById(R.id.edCelsius);
        EditText far_result = (EditText) this.findViewById(R.id.edFarenheit);

        try {
            String far = far_result.getText().toString();
            double f = Double.parseDouble(far);
            double c_c;
            c_c = (f - 32) * 5/9;
            String c_c_c = Double.toString(c_c);
            cel_result.setText(c_c_c);
        } catch (NumberFormatException exc) {
            cel_result.setText(R.string.v_i);
            Toast.makeText(this.getApplicationContext(), R.string.error2, Toast.LENGTH_SHORT).show();
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
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
