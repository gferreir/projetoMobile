package com.example.gferreir.projectcleaner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // botões referente ao layout inicio.xml
    private Button btnInserirInicio, btnConsultInicio;

    // textos e botões referente ao layout activity_main.xml
    private EditText txtSalaInsere, txtFuncionarioInsere, txtTipoLimpezaInsere, txtProdutosInsere;
    private Button btnGravarInsere, btnVoltarInsere;

    // texto e botão referente ao layout busca.xml
    private EditText txtConsultSala;
    private Button btnBuscaConsult;

    // textos e botões referente ao layout mosta_busca.xml
    private EditText txtSalaBusca, txtFuncBusca, txtTipoLimpBusca, txtProdBusca;
    private Button btnDeletaBusca, btnEditaBusca, btnVoltaBusca;

    // textos e botões referente ao layout edicao.xml
    private EditText txtSalaEdicao, txtFuncEdicao, txtTipoEdicao, txtProdEdicao;
    private Button btnGravaEdicao, btnVoltaEdicao;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        databaseHelper = new DatabaseHelper(this);

        btnStore = (Button) findViewById(R.id.btnstore);
        btnGetall = (Button) findViewById(R.id.btnget);
        etname = (EditText) findViewById(R.id.etname);
        ethobby = (EditText) findViewById(R.id.ethobby);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addUserDetail(etname.getText().toString(), ethobby.getText().toString());
                etname.setText("");
                ethobby.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btnGetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GetAllUsersActivity.class);
                startActivity(intent);
            }
        });

    }
}
