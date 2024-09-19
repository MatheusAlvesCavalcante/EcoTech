package br.com.local.ecotech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class GrupoRes extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grupo_res);

        Button abrindo_tela_home = findViewById(R.id.btn_bem_vindo);

        abrindo_tela_home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(GrupoRes.this,   Home.class );
                startActivity (intent);
            }
        });
    }
}
