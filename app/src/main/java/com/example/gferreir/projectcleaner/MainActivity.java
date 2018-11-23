package com.example.gferreir.projectcleaner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // variáveis referente ao EditText da tela de login
    private EditText usuario, senha;

    Button btnCadastrar,btnLogar;

    DBHelperReg db;

    // método onCreate responsável por fazer todas as ações da tela enquanto ativa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // responsável por fazer a tela login_activity ser chamada
        setContentView(R.layout.login_activity);

        db = new DBHelperReg(this);

        // campos de usuário e senha estão declarados
        usuario = (EditText)findViewById(R.id.edtLogin);
        senha = (EditText)findViewById(R.id.edtSenha);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnLogar =(Button) findViewById(R.id.btnEntrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegistrarActivity.class));
            }
        });


    }

    // método responsável por fazer a verificação dos dados preenchidos nos campos
    // a classe InicioActivity é chamada

    public void entrarOnClick(View view){

        String username = usuario.getText().toString();
        String password = senha.getText().toString();

        if(username.equals("")) {
            Toast.makeText(MainActivity.this, "Nome não inserido, tente novamente", Toast.LENGTH_SHORT).show();
        }
        else if(password.equals("")){
            Toast.makeText(MainActivity.this, "Senha não inserida, tente novamente", Toast.LENGTH_SHORT).show();

        }
        else {

            String res = db.ValidarLogin(username,password);
            if(res.equals("OK")){
                startActivity(new Intent(MainActivity.this, InicioActivity.class));

            }
            else{
                Toast.makeText(MainActivity.this, "Login errado, tente novamente", Toast.LENGTH_SHORT).show();

            }

        }

    }
}



