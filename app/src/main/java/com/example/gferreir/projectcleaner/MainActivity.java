package com.example.gferreir.projectcleaner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        usuario = (EditText)findViewById(R.id.edtLogin);
        senha = (EditText)findViewById(R.id.edtSenha);
    }

    public void entrarOnClick(View view){
        String usuarioInformado = usuario.getText().toString();
        String senhaInformado = senha.getText().toString();

        if("admin".equals(usuarioInformado) && "123".equals(senhaInformado)){
            startActivity(new Intent(this, InicioActivity.class));
        }else{
            String mensagemErro = getString(R.string.erro_autenticacao);
            Toast toast = Toast.makeText(this, mensagemErro, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
