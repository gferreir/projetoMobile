package com.example.gferreir.projectcleaner;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class BuscaActivity extends AppCompatActivity{

    static ListView listView;
    static String sala, funcionario, tipo, produto;
    static int idd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostra_busca);
        listView = (ListView)findViewById(R.id.listView);
        mostraLista();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Context context = view.getContext();
                final Limpeza limpeza = (Limpeza)listView.getItemAtPosition(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Excluir").setMessage("Excluir registro?").setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new GerenciaLimpeza(getBaseContext()).excluirLimpeza(limpeza.id);
                        mostraLista();
                        Toast.makeText(context,"Exclusão realizada", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancelar",null).create().show();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Limpeza limpeza = (Limpeza)listView.getItemAtPosition(position);
                sala = limpeza.sala;
                funcionario = limpeza.funcionario;
                tipo = limpeza.tipoLimpeza;
                produto = limpeza.produto;
                idd = limpeza.id;
                Intent coisinha = new Intent(BuscaActivity.this, EdicaoActivity.class);
                startActivity(coisinha);
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
