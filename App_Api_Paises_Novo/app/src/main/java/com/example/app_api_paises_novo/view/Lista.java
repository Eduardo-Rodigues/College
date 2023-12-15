package com.example.app_api_paises_novo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.app_api_paises_novo.R;
import com.example.app_api_paises_novo.adapter.PaisAdapter;
import com.example.app_api_paises_novo.controller.PaisController;
import com.example.app_api_paises_novo.model.Pais_Model;
import java.util.ArrayList;

public class Lista extends AppCompatActivity {

    private PaisController controller;
    private RecyclerView recylerViewPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        recylerViewPais = findViewById(R.id.recylerViewPais);
        carregar_Lista_Alunos();
    }
    private void carregar_Lista_Alunos(){
        ArrayList<Pais_Model> listaPais = controller.retornar(this);
        PaisAdapter adapter = new PaisAdapter(this, listaPais);
        recylerViewPais.setLayoutManager(new LinearLayoutManager(this));
        recylerViewPais.setAdapter(adapter);
    }

}