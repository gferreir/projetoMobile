package com.example.gferreir.projectcleaner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;

public class EdicaoActivity extends AppCompatActivity{

    BuscaActivity busca;
    EditText txtSalaEdita, txtFuncionarioEdita;
    Spinner txtTipoLimpezaEdita, txtProdutoEdita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edicao_activity);
        txtSalaEdita = (EditText)findViewById(R.id.txtSalaEdita);
    }
}
