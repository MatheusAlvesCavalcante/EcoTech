package br.com.local.ecotech;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Cidade extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.cidade);

            Spinner spinner = findViewById(R.id.spinner);


            // Crie um ArrayAdapter usando o array de strings e um layout padrão do Spinner
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.cities_array, android.R.layout.simple_spinner_item);

            // Especifique o layout a ser usado quando a lista de escolhas aparecer
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // Aplique o adaptador ao Spinner
            spinner.setAdapter(adapter);

            // Adicione um listener ao Spinner
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    String city = parentView.getItemAtPosition(position).toString();
                    Toast.makeText(parentView.getContext(), "Cidade selecionada: " + city, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // Do nothing
                }
            });

            // Adicione um listener ao botão de próximo

        }
    }



