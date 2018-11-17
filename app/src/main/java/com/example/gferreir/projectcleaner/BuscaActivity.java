package com.example.gferreir.projectcleaner;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class BuscaActivity extends AppCompatActivity{

    ListView listView;
    String sala, funcionario, tipo, produto;
    int idd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostra_busca);
        listView = (ListView)findViewById(R.id.listView);
        mostraLista();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Limpeza limpeza = (Limpeza)listView.getItemAtPosition(position);
                sala = limpeza.sala;
                funcionario = limpeza.funcionario;
                tipo = limpeza.tipoLimpeza;
                produto = limpeza.produto;
                idd = limpeza.id;
                startActivity(new Intent(getBaseContext(), EdicaoActivity.class));
            }
        });
    }

    public void mostraLista(){
        List<Limpeza> listinha = new GerenciaLimpeza(this).retornaLimpezas();
        if(listinha.size() == 0)
            Toast.makeText(this,"Nenhum registro localizado",Toast.LENGTH_SHORT).show();

        ArrayAdapter<Limpeza> limpezinha = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listinha);

        listView.setAdapter(limpezinha);
    }


}
