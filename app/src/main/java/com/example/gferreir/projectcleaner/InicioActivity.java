package com.example.gferreir.projectcleaner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InicioActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_activity);
    }

    public void btnCadastrarOnClick(View view){
        startActivity(new Intent(this, GravaActivity.class));
    }

    public void btnConsultarOnClick(View view){
        startActivity(new Intent(this, BuscaActivity.class));
    }

}
