package com.example.gferreir.projectcleaner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InicioActivity extends AppCompatActivity{

    // quando essa classe for chamada
    // onCreate responsável por exibir a tela inicio_activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_activity);
    }

    // método onClick, quando apertar o botão de cadastrar
    // a classe GravaActivity é chamada
    public void btnCadastrarOnClick(View view){
        startActivity(new Intent(this, GravaActivity.class));
    }

    // método onClick, quando apertar o botão de consultar
    // a classe BuscaActivity é chamada
    public void btnConsultarOnClick(View view){
        startActivity(new Intent(this, BuscaActivity.class));
    }

}
