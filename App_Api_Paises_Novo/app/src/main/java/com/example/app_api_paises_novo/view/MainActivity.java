package com.example.app_api_paises_novo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.app_api_paises_novo.R;
import com.example.app_api_paises_novo.controller.PaisController;

public class MainActivity extends AppCompatActivity {

    private Button botaoBuscar;
    private Button botaoAbrirLista;
    private TextView textViewCodigo;
    private TextView textViewDescricao;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCodigo = findViewById(R.id.textViewCodigo);
        textViewDescricao = findViewById(R.id.textViewDescricao);
        botaoBuscar = findViewById(R.id.botaoBuscar);
        botaoAbrirLista = findViewById(R.id.botaoAbrirLista);

        botaoBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaisController.getViaPais(MainActivity.this);
            }
        });

        botaoAbrirLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lista.class);
                startActivity(intent);

            }
        });
    }
}