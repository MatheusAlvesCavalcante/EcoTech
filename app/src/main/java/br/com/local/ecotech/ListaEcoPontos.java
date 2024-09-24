package br.com.local.ecotech;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaEcoPontos extends AppCompatActivity {

    Spinner spinnerCidade;
    CheckBox checkBoxPequeno, checkBoxMedio, checkBoxGrande;
    String[] listaCidades = {
            "Selecione a Cidade",
            "Carapicuíba", // Aceita grande
            "Osasco",       // Aceita pequeno e médio
            "Barueri",      // Configure conforme necessário
            "Jandira",      // Configure conforme necessário
            "Santana de Parnaíba", // Configure conforme necessário
            "Itapevi",      // Configure conforme necessário
            "Pirapora do Bom Jesus" // Configure conforme necessário
    };

    List<String> cidadesFiltradas;
    LinearLayout collectionPoint1, collectionPoint2, collectionPoint3, collectionPoint4, collectionPoint5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        spinnerCidade = findViewById(R.id.spinnerCidade);
        checkBoxPequeno = findViewById(R.id.checkboxPequeno);
        checkBoxMedio = findViewById(R.id.checkboxMedio);
        checkBoxGrande = findViewById(R.id.checkboxGrande);

        collectionPoint1 = findViewById(R.id.collection_point_1);
        collectionPoint2 = findViewById(R.id.collection_point_2);
        collectionPoint3 = findViewById(R.id.collection_point_3);
        collectionPoint4 = findViewById(R.id.collection_point_4);
        collectionPoint5 = findViewById(R.id.collection_point_5);

        preencherCidade();

        checkBoxPequeno.setOnClickListener(v -> filtrarCidades());
        checkBoxMedio.setOnClickListener(v -> filtrarCidades());
        checkBoxGrande.setOnClickListener(v -> filtrarCidades());

        spinnerCidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cidadeSelecionada = spinnerCidade.getItemAtPosition(position).toString();
                // Exibir um Toast com a cidade selecionada
                Toast.makeText(ListaEcoPontos.this, "Cidade selecionada: " + cidadeSelecionada, Toast.LENGTH_SHORT).show();
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

    private void filtrarCidades() {
        cidadesFiltradas = new ArrayList<>();

        if (checkBoxPequeno.isChecked()) {
            cidadesFiltradas.add("Osasco"); // Exemplo de cidade que aceita pequeno
            // Adicione mais cidades conforme necessário
        }
        if (checkBoxMedio.isChecked()) {
            cidadesFiltradas.add("Osasco"); // Exemplo de cidade que aceita médio
            // Adicione mais cidades conforme necessário
        }
        if (checkBoxGrande.isChecked()) {
            cidadesFiltradas.add("Carapicuíba"); // Exemplo de cidade que aceita grande
            // Adicione mais cidades conforme necessário
        }

        atualizarSpinner();
    }

    private void atualizarSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.text_spinner, cidadesFiltradas);
        spinnerCidade.setAdapter(adapter);
        spinnerCidade.setSelection(0); // Reseta a seleção do spinner
    }

    private void filtrarPontosDeColeta(String cidade) {
        // Adicione a lógica de filtragem de pontos de coleta aqui
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