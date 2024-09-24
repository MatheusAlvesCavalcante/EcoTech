package br.com.local.ecotech;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

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

    LinearLayout collectionPoint1, collectionPoint2, collectionPoint3, collectionPoint4, collectionPoint5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        // Referências aos elementos de layout
        spinnerCidade = findViewById(R.id.spinnerCidade);
        cidade = findViewById(R.id.txtCidade);
        collectionPoint1 = findViewById(R.id.collection_point_1);
        collectionPoint2 = findViewById(R.id.collection_point_2);
        collectionPoint3 = findViewById(R.id.collection_point_3);
        collectionPoint4 = findViewById(R.id.collection_point_4);
        collectionPoint5 = findViewById(R.id.collection_point_5);

        preencherCidade();

        spinnerCidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cidadeSelecionada = spinnerCidade.getItemAtPosition(position).toString();
                cidade.setText(cidadeSelecionada);
                filtrarPontosDeColeta(cidadeSelecionada);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private void preencherCidade() {
        spinnerCidade.setAdapter(new ArrayAdapter<>(
                this,
                R.layout.text_spinner, listaCidades
        ));
    }

    private void filtrarPontosDeColeta(String cidade) {
        if (cidade.equals("Selecione a Cidade")) {
            mostrarTodosPontosDeColeta();
        } else {
            collectionPoint1.setVisibility(collectionPoint1.getTag().equals(cidade) ? View.VISIBLE : View.GONE);
            collectionPoint2.setVisibility(collectionPoint2.getTag().equals(cidade) ? View.VISIBLE : View.GONE);
            collectionPoint3.setVisibility(collectionPoint3.getTag().equals(cidade) ? View.VISIBLE : View.GONE);
            collectionPoint4.setVisibility(collectionPoint4.getTag().equals(cidade) ? View.VISIBLE : View.GONE);
            collectionPoint5.setVisibility(collectionPoint5.getTag().equals(cidade) ? View.VISIBLE : View.GONE);
        }
    }

    private void mostrarTodosPontosDeColeta() {
        collectionPoint1.setVisibility(View.VISIBLE);
        collectionPoint2.setVisibility(View.VISIBLE);
        collectionPoint3.setVisibility(View.VISIBLE);
        collectionPoint4.setVisibility(View.VISIBLE);
        collectionPoint5.setVisibility(View.VISIBLE);
    }
}
