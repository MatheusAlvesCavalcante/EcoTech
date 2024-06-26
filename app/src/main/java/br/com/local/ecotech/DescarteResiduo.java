package br.com.local.ecotech;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DescarteResiduo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton backButton = findViewById(R.id.backButton);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button smallWasteButton = findViewById(R.id.smallWasteButton);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button mediumWasteButton = findViewById(R.id.mediumWasteButton);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button largeWasteButton = findViewById(R.id.largeWasteButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action for back button
                onBackPressed();
            }
        });

        smallWasteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action for small waste button
                Toast.makeText(DescarteResiduo.this, "Resíduos de pequeno porte", Toast.LENGTH_SHORT).show();
            }
        });

        mediumWasteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action for medium waste button
                Toast.makeText(DescarteResiduo.this, "Resíduos de médio porte", Toast.LENGTH_SHORT).show();
            }
        });

        largeWasteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action for large waste button
                Toast.makeText(DescarteResiduo.this, "Resíduos de grande porte", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
