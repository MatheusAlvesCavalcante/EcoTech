package br.com.local.ecotech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import br.com.local.ecotech.placeholder.EcoPontoModel;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatImageView imageView = findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
            }
        });


    }


    public void onListFragmentInteraction(EcoPontoModel item) {
        Intent it = new Intent(MainActivity.this, DetalhesActivity.class);
        startActivity(it);

    }
}