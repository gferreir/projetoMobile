package com.example.gferreir.projectcleaner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class EdicaoActivity extends AppCompatActivity{

    // declaração das variáveis
    BuscaActivity busca;
    EditText txtSalaEdita, txtFuncionarioEdita;
    Spinner txtTipoLimpezaEdita, txtProdutoEdita;

    // intanciação da classe Limpeza
    Limpeza limpeza;

    // quando essa classe for chamada
    // onCreate responsável por exibir a tela edicao_activity
    // esta tela tem como função fazer a edição de um registro
    // campos txtSalaEdita, txtFuncionarioEdita, txtTipoLimpezaEdita e txtProdutoEdita
    // estão sendo declarados
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edicao_activity);
        txtSalaEdita = (EditText)findViewById(R.id.txtSalaEdita);
        txtFuncionarioEdita = (EditText)findViewById(R.id.txtFuncionarioEdita);
        txtTipoLimpezaEdita = (Spinner)findViewById(R.id.txtTipoLimpezaEdita);
        txtProdutoEdita = (Spinner)findViewById(R.id.txtProdutoEdita);

        // recebendo os valores dos atributos vindo da classe BuscaActivity
        // settando os valores recebidos nos respectivos campos
        txtSalaEdita.setText(busca.sala);
        txtFuncionarioEdita.setText(busca.funcionario);

        // condicional necessária para settar os valores do spinner tipoLimpeza
        if(busca.tipo.equals("Leve"))
            txtTipoLimpezaEdita.setSelection(0);
        if(busca.tipo.equals("Média"))
            txtTipoLimpezaEdita.setSelection(1);
        if(busca.tipo.equals("Pesada"))
            txtTipoLimpezaEdita.setSelection(2);

        // condicional necessária para settar os valores do spinner tipoProduto
        if(busca.produto.equals("Básicos"))
            txtProdutoEdita.setSelection(0);
        if(busca.produto.equals("Compostos"))
            txtProdutoEdita.setSelection(1);
        if(busca.produto.equals("Químicos"))
            txtProdutoEdita.setSelection(2);
    }

    // método responsável por mostrar e atualizar a List View (refresh na página)
    public void mostraLista(){
        List<Limpeza> listinha = new GerenciaLimpeza(this).retornaLimpezas();
        if(listinha.size() == 0)
            Toast.makeText(this,"Nenhum registro localizado",Toast.LENGTH_SHORT).show();

        ArrayAdapter<Limpeza> limpezinha = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listinha);

        busca.listView.setAdapter(limpezinha);
    }

    // método responsável por salvar a edição
    // pega os novos valores dos campos
    // chama método salvaLimpeza
    // chama método mostraLista()
    // chama método finish() reponsável por voltar para a tela anterior
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
