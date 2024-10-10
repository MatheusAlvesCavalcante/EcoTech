package br.com.local.ecotech;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatRatingBar;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Avaliacao extends AppCompatActivity {

    private AppCompatEditText editTextNome, editTextEmail;
    private AppCompatRatingBar ratingBar;
    private ListView listViewAvaliacoes;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> avaliacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);

        editTextNome = findViewById(R.id.edit_text_nome);
        editTextEmail = findViewById(R.id.edit_text_email);
        ratingBar = findViewById(R.id.ratingBar);
        Button buttonEnviar = findViewById(R.id.button_enviar);
        listViewAvaliacoes = findViewById(R.id.listViewAvaliacoes);

        avaliacoes = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, avaliacoes);
        listViewAvaliacoes.setAdapter(adapter);


        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCadastro();
            }
        });
    }


    private void validarCadastro() {
        String nome = editTextNome.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        if (TextUtils.isEmpty(nome)) {
            editTextNome.setError("Nome é obrigatório");
            return;
        }
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Email inválido");
            return;
        }

        // Coletar a avaliação em estrelas
        float rating = ratingBar.getRating();
        if (rating == 0) {
            Toast.makeText(this, "Por favor, avalie com estrelas", Toast.LENGTH_SHORT).show();
            return;
        }

        //TODO - enviar dados para o banco
        inserirUsuario(nome, email, rating);

        // Adicionar a avaliação à lista
        String avaliacao = "Nome: " + nome + "\nEmail: " + email + "\nAvaliação: " + rating + " estrelas";
        avaliacoes.add(avaliacao);
        adapter.notifyDataSetChanged();

        // Limpar os campos
        editTextNome.setText("");
        editTextEmail.setText("");
        ratingBar.setRating(0);
    }

    private void inserirUsuario(String nome, String email, float avaliacao){
        try{
            PreparedStatement pst =
                    ConexaoBD.conectar().prepareStatement("insert into UsuarioApp (nome, email, avaliacao) values (?,?,?)");


            pst.setString(1, nome);
            pst.setString(2, email);
            pst.setFloat(3, avaliacao);
            pst.executeUpdate();
            Toast.makeText(getApplicationContext(), "AVALIAÇÃO ENVIADA COM SUCESSO!",
            Toast.LENGTH_SHORT).show();
        }catch(SQLException e){
            Toast.makeText(getApplicationContext(), e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}


