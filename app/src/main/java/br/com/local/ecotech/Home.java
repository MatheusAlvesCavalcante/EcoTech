package br.com.local.ecotech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AppCompatImageView abrindo_tela_avaliacao = findViewById(R.id.btn_estrela);
        abrindo_tela_avaliacao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(Home.this, Avaliacao.class );
                startActivity (intent);
            }
        });

        AppCompatButton abrindo_tela_bem_vindo = findViewById(R.id.btn_bem_vindo);

        abrindo_tela_bem_vindo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(Home.this, BemVindo.class );
                startActivity (intent);
            }
        });


        AppCompatButton abrindo_tela_descarte = findViewById(R.id.btn_lista);

        abrindo_tela_descarte.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(Home.this, GrupoRes.class );
                startActivity (intent);
            }
        });


        AppCompatButton abrindo_tela_importancia = findViewById(R.id.appCompatButton);

        abrindo_tela_importancia.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(Home.this,ImportanciaREC.class );
                startActivity (intent);
            }
        });


        }
}


