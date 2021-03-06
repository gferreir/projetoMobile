package com.example.gferreir.projectcleaner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity {

    EditText edtNome,edtSenha,edtConfirmarSenha;
    Button btnCadastrar,btnCancelar;
    DBHelperReg db;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_activity);

        db = new DBHelperReg(this);

        edtNome=(EditText) findViewById(R.id.edtNome);
        edtSenha =(EditText) findViewById(R.id.edtSenha);
        edtConfirmarSenha=(EditText) findViewById(R.id.edtConfirmSenha);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrarActivity.this, MainActivity.class));
            }
        });
    }

    public void salvaUser(View view){
        int id = usuario == null ? 0 : usuario.id;
        String user = edtNome.getText().toString();
        String pwd = edtSenha.getText().toString();
        String confirm = edtConfirmarSenha.getText().toString();

        if (user.equals("")) {
            Toast.makeText(RegistrarActivity.this, "Usuário não inserido, por favor" +
                    " preencha com um usuário válido", Toast.LENGTH_SHORT).show();
        } else if (pwd.equals("") || confirm.equals("")) {
            Toast.makeText(RegistrarActivity.this, "Senha vazia, por favor preencha " +
                    "com uma senha válida", Toast.LENGTH_SHORT).show();
        } else if (!pwd.equals(confirm)) {
            Toast.makeText(RegistrarActivity.this, "As senhas não correspondem," +
                    " tente novamente", Toast.LENGTH_SHORT).show();
        } else {
            usuario = new Usuario(id,user,pwd);
            new GerenciaConfig(this).salvaUser(usuario);
            Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
