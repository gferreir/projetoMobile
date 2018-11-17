package com.example.gferreir.projectcleaner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class EdicaoActivity extends AppCompatActivity{

    BuscaActivity busca;
    EditText txtSalaEdita, txtFuncionarioEdita;
    Spinner txtTipoLimpezaEdita, txtProdutoEdita;

    Limpeza limpeza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edicao_activity);
        txtSalaEdita = (EditText)findViewById(R.id.txtSalaEdita);
        txtFuncionarioEdita = (EditText)findViewById(R.id.txtFuncionarioEdita);
        txtTipoLimpezaEdita = (Spinner)findViewById(R.id.txtTipoLimpezaEdita);
        txtProdutoEdita = (Spinner)findViewById(R.id.txtProdutoEdita);

        txtSalaEdita.setText(busca.sala);
        txtFuncionarioEdita.setText(busca.funcionario);

        if(busca.tipo.equals("Leve"))
            txtTipoLimpezaEdita.setSelection(0);
        if(busca.tipo.equals("Média"))
            txtTipoLimpezaEdita.setSelection(1);
        if(busca.tipo.equals("Pesada"))
            txtTipoLimpezaEdita.setSelection(2);

        if(busca.produto.equals("Básicos"))
            txtProdutoEdita.setSelection(0);
        if(busca.produto.equals("Compostos"))
            txtProdutoEdita.setSelection(1);
        if(busca.produto.equals("Químicos"))
            txtProdutoEdita.setSelection(2);
    }

    public void mostraLista(){
        List<Limpeza> listinha = new GerenciaLimpeza(this).retornaLimpezas();
        if(listinha.size() == 0)
            Toast.makeText(this,"Nenhum registro localizado",Toast.LENGTH_SHORT).show();

        ArrayAdapter<Limpeza> limpezinha = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listinha);

        busca.listView.setAdapter(limpezinha);
    }

    public void salvarEdicao(View view){
        String sala = txtSalaEdita.getText().toString();
        String funcionario = txtFuncionarioEdita.getText().toString();
        String tipoLimpeza = txtTipoLimpezaEdita.getSelectedItem().toString();
        String produto = txtProdutoEdita.getSelectedItem().toString();

        limpeza = new Limpeza(busca.idd,sala,funcionario,tipoLimpeza,produto);
        new GerenciaLimpeza(this).salvarLimpeza(limpeza);
        Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_SHORT).show();
        mostraLista();
        finish();
    }
}
