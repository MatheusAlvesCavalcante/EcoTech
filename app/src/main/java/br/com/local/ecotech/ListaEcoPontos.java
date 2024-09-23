package br.com.local.ecotech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.TextAppearanceInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ListaEcoPontos extends AppCompatActivity {

    TextView cidade;
    Spinner spinnerCidade;
    String[] listaCidades = {
            "Selecione a Cidade",
            "Carapicuíba",
            "Osasco",
            "Barueri",
            "Jandira",
            "Santana de Parnaíba",
            "Itapevi",
            "Pirapora do Bom Jesus"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        spinnerCidade = findViewById(R.id.spinnerCidade);
        cidade =findViewById(R.id.txtCidade);


        preencherCidade();
        spinnerCidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    Toast toast = Toast.makeText(Toast.LENGTH_SHORT).show();
               cidade.setText(spinnerCidade.getItemAtPosition(position).toString());
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void preencherCidade() {
        spinnerCidade.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.text_spinner,listaCidades
        ));
    }

}
