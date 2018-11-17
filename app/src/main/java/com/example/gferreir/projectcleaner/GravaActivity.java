package com.example.gferreir.projectcleaner;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class GravaActivity extends AppCompatActivity{

    EditText edtSala, edtFuncionario;
    Spinner spinnTipoLimpeza, spinnProduto;

    Limpeza limpeza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grava_activity1);
        edtSala = (EditText)findViewById(R.id.edtSala);
        edtFuncionario = (EditText)findViewById(R.id.edtFuncionario);
        spinnTipoLimpeza = (Spinner)findViewById(R.id.spinnTipoLimpeza);
        spinnProduto = (Spinner)findViewById(R.id.spinnProduto);
    }

    public void salvarLimpeza(View view){
        int id = limpeza == null ? 0 : limpeza.id;
        String sala = edtSala.getText().toString();
        String funcionario = edtFuncionario.getText().toString();
        String tipoLimpeza = spinnTipoLimpeza.getSelectedItem().toString();
        String produto = spinnProduto.getSelectedItem().toString();

        limpeza = new Limpeza(id,sala,funcionario,tipoLimpeza,produto);
        new GerenciaLimpeza(this).salvarLimpeza(limpeza);
        Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_SHORT).show();

        finish();
    }


}
