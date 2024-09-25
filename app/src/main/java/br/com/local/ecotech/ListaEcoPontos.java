package br.com.local.ecotech;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.widget.Button;
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
            "Carapicuíba",
            "Osasco",
            "Barueri",
            "Jandira",
            "Santana de Parnaíba",
            "Itapevi",
            "Pirapora do Bom Jesus"
    };

    List<String> cidadesFiltradas;
    LinearLayout collectionPoint1, collectionPoint2, collectionPoint3, collectionPoint4, collectionPoint5;
    Button btnDetalhes1, btnDetalhes2, btnDetalhes3, btnDetalhes4, btnDetalhes5;

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

        btnDetalhes1 = findViewById(R.id.view_details);
        btnDetalhes2 = findViewById(R.id.view_details2);
        btnDetalhes3 = findViewById(R.id.view_details3);
        btnDetalhes4 = findViewById(R.id.view_details4);
        btnDetalhes5 = findViewById(R.id.view_details5);

        setupDetailsButtons();

        preencherCidade();

        checkBoxPequeno.setOnClickListener(v -> filtrarCidades());
        checkBoxMedio.setOnClickListener(v -> filtrarCidades());
        checkBoxGrande.setOnClickListener(v -> filtrarCidades());

        spinnerCidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cidadeSelecionada = spinnerCidade.getItemAtPosition(position).toString();

                Toast.makeText(ListaEcoPontos.this, "Cidade selecionada: " + cidadeSelecionada, Toast.LENGTH_SHORT).show();
                filtrarPontosDeColeta(cidadeSelecionada);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setupDetailsButtons() {
        btnDetalhes1.setOnClickListener(v -> mostrarDetalhes("Detalhes do ponto de coleta em Barueri..."));
        btnDetalhes2.setOnClickListener(v -> mostrarDetalhes("Detalhes do ponto de coleta em Carapicuíba..."));
        btnDetalhes3.setOnClickListener(v -> mostrarDetalhes("Detalhes do ponto de coleta em Itapevi..."));
        btnDetalhes4.setOnClickListener(v -> mostrarDetalhes("Detalhes do ponto de coleta em Osasco..."));
        btnDetalhes5.setOnClickListener(v -> mostrarDetalhes("Detalhes do ponto de coleta em São Paulo..."));
    }

    private void mostrarDetalhes(String detalhes) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Detalhes do Ponto de Coleta");
        builder.setMessage(detalhes);
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
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
            cidadesFiltradas.add("Osasco");

        }
        if (checkBoxMedio.isChecked()) {
            cidadesFiltradas.add("Osasco");

        }
        if (checkBoxGrande.isChecked()) {
            cidadesFiltradas.add("Carapicuíba");
        }

        atualizarSpinner();
    }

    private void atualizarSpinner() {
        if (cidadesFiltradas.isEmpty()) {
            cidadesFiltradas.add(0, "Selecione a Cidade");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.text_spinner, cidadesFiltradas);
        spinnerCidade.setAdapter(adapter);
        spinnerCidade.setSelection(0);
    }

    private void filtrarPontosDeColeta(String cidade) {
        if (cidade.equals("Selecione a Cidade")) {
            mostrarTodosPontosDeColeta();
        }  else {
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