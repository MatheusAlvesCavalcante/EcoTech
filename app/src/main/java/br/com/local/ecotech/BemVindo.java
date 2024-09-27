package br.com.local.ecotech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class BemVindo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bemvindo);

        AppCompatButton abrindo_tela_home = findViewById(R.id.btn_bem_vindo1);

        abrindo_tela_home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(BemVindo.this,   Home.class );
                startActivity (intent);
            }
        });
    }
}
