package br.com.local.ecotech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.local.ecotech.placeholder.EcoPontoConexao;
import br.com.local.ecotech.placeholder.EcoPontoModel;

public class ListaEcoPontos extends AppCompatActivity {

    AppCompatSpinner spinnerCidade;
    AppCompatCheckBox checkBoxPequeno, checkBoxMedio, checkBoxGrande;
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
    AppCompatButton btnDetalhes1, btnDetalhes2, btnDetalhes3, btnDetalhes4, btnDetalhes5;

    private OnListFragmentInteractionListener mListener;
    List<EcoPontoModel> listagem;
    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

       listagem = new ArrayList<>();

        spinnerCidade = findViewById(R.id.spinnerCidade);
        checkBoxPequeno = findViewById(R.id.checkboxPequeno);
        checkBoxMedio = findViewById(R.id.checkboxMedio);
        checkBoxGrande = findViewById(R.id.checkboxGrande);

        collectionPoint1 = findViewById(R.id.collection_point_1);
//        collectionPoint2 = findViewById(R.id.collection_point_2);
//        collectionPoint3 = findViewById(R.id.collection_point_3);
//        collectionPoint4 = findViewById(R.id.collection_point_4);
//        collectionPoint5 = findViewById(R.id.collection_point_5);

        btnDetalhes1 = findViewById(R.id.view_details);
//        btnDetalhes2 = findViewById(R.id.view_details2);
//        btnDetalhes3 = findViewById(R.id.view_details3);
//        btnDetalhes4 = findViewById(R.id.view_details4);
//        btnDetalhes5 = findViewById(R.id.view_details5);



       // setupDetailsButtons();

        spinnerCidade.setAdapter(new ArrayAdapter<>(
                this,
                R.layout.text_spinner, listaCidades
        ));

//        checkBoxPequeno.setOnClickListener(v -> filtrarCidades());
//        checkBoxMedio.setOnClickListener(v -> filtrarCidades());
//        checkBoxGrande.setOnClickListener(v -> filtrarCidades());

//        spinnerCidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String cidadeSelecionada = spinnerCidade.getItemAtPosition(position).toString();
//
//                Toast.makeText(ListaEcoPontos.this, "Cidade selecionada: " + cidadeSelecionada, Toast.LENGTH_SHORT).show();
//                filtrarPontosDeColeta(cidadeSelecionada);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        recyclerView = findViewById(R.id.lista_itens);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        // todo - carregar produtos do banco de dados

        if(spinnerCidade.isSelected()){
            int tipoGrupo = filtrarGrupo();
            listagem = EcoPontoConexao.pesquisarEcoPontos(tipoGrupo, spinnerCidade.toString(), getApplicationContext());
        }else{
            listagem = EcoPontoConexao.pesquisarEcoPontos(getApplicationContext());
        }

        recyclerView.setAdapter(new MyEcoPontoRecyclerViewAdapter(listagem, mListener));


        spinnerCidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                recyclerView.clearDisappearingChildren();
                recyclerView = findViewById(R.id.lista_itens);
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                int tipoGrupo = filtrarGrupo();
                if(position==1)
                    listagem = EcoPontoConexao.pesquisarEcoPontos(tipoGrupo, "Carapicuíba", getApplicationContext());
                else if(position==2)
                    listagem = EcoPontoConexao.pesquisarEcoPontos(tipoGrupo, "Osasco", getApplicationContext());
                else if(position==3)
                    listagem = EcoPontoConexao.pesquisarEcoPontos(tipoGrupo, "Barueri", getApplicationContext());
                else if(position==4)
                    listagem = EcoPontoConexao.pesquisarEcoPontos(tipoGrupo, "Jandira", getApplicationContext());
                else if(position==5)
                    listagem = EcoPontoConexao.pesquisarEcoPontos(tipoGrupo, "Santana de Parnaíba", getApplicationContext());
                else if(position==6)
                    listagem = EcoPontoConexao.pesquisarEcoPontos(tipoGrupo, "Itapevi", getApplicationContext());
                else if(position==7)
                    listagem = EcoPontoConexao.pesquisarEcoPontos(tipoGrupo, "Pirapora do Bom Jesus", getApplicationContext());

                MyEcoPontoRecyclerViewAdapter adapter = new MyEcoPontoRecyclerViewAdapter(listagem, mListener);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private int filtrarGrupo() {
        boolean pequeno = checkBoxPequeno.isChecked();
        boolean medio = checkBoxMedio.isChecked();
        boolean grande = checkBoxGrande.isChecked();
        int resultado = 0;
        if(pequeno){
            resultado= 1;
        } else if(medio){
            resultado= 2;
        } else if(grande){
            resultado= 3;
        } else if(pequeno && medio){
            resultado= 4;
        } else if(pequeno && medio && grande){
            resultado= 5;
        } else if(medio && grande){
            resultado= 6;
        }
        return resultado;
    }


    private void preencherCidade() {

    }

//    private void filtrarCidades() {
//        cidadesFiltradas = new ArrayList<>();
//
//        if (checkBoxPequeno.isChecked() | checkBoxMedio.isChecked()) {
//            cidadesFiltradas.add("Osasco");
//
//        }
//
//        if (checkBoxPequeno.isChecked() | checkBoxMedio.isChecked() | checkBoxGrande.isChecked()) {
//            cidadesFiltradas.add("Carapicuíba");
//
//        }
//        if (checkBoxPequeno.isChecked()  | checkBoxMedio.isChecked() | checkBoxGrande.isChecked()) {
//            cidadesFiltradas.add("Barueri");
//        }
//
//        if (checkBoxPequeno.isChecked() | checkBoxMedio.isChecked()) {
//            cidadesFiltradas.add("Itapevi");
//        }
//
//        if (checkBoxPequeno.isChecked() | checkBoxMedio.isChecked()) {
//        cidadesFiltradas.add("Jandira");
//
//        }
//
//        if (checkBoxGrande.isChecked() | checkBoxMedio.isChecked() | checkBoxGrande.isChecked() ) {
//            cidadesFiltradas.add("Santana de Parnaíba");
//        }
//        if (checkBoxPequeno.isChecked()) {
//            cidadesFiltradas.add("Pirapora do Bom Jesus");
//        }
//
//
//
//        atualizarSpinner();
//    }

//    private void atualizarSpinner() {
//        if (cidadesFiltradas.isEmpty()) {
//            cidadesFiltradas.add(0, "Selecione a Cidade");
//        }
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.text_spinner, cidadesFiltradas);
//        spinnerCidade.setAdapter(adapter);
//        spinnerCidade.setSelection(0);
//    }

//    private void filtrarPontosDeColeta(String cidade) {
//        if (cidade.equals("Selecione a Cidade")) {
//            mostrarTodosPontosDeColeta();
//        }  else {
////            collectionPoint1.setVisibility(collectionPoint1.getTag().equals(cidade) ? View.VISIBLE : View.GONE);
////            collectionPoint2.setVisibility(collectionPoint2.getTag().equals(cidade) ? View.VISIBLE : View.GONE);
////            collectionPoint3.setVisibility(collectionPoint3.getTag().equals(cidade) ? View.VISIBLE : View.GONE);
////            collectionPoint4.setVisibility(collectionPoint4.getTag().equals(cidade) ? View.VISIBLE : View.GONE);
////            collectionPoint5.setVisibility(collectionPoint5.getTag().equals(cidade) ? View.VISIBLE : View.GONE);
//        }
//    }
//
//    private void mostrarTodosPontosDeColeta() {
////        collectionPoint1.setVisibility(View.VISIBLE);
////        collectionPoint2.setVisibility(View.VISIBLE);
////        collectionPoint3.setVisibility(View.VISIBLE);
////        collectionPoint4.setVisibility(View.VISIBLE);
////        collectionPoint5.setVisibility(View.VISIBLE);
//
//
//    }


}