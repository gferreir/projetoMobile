package com.example.gferreir.projectcleaner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginConfigActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autenticacao_config);
        usuario = (EditText)findViewById(R.id.edtUserConfig);
        senha = (EditText)findViewById(R.id.edtPwdConfig);
    }

    public void logarOnClick(View view){
        String user = usuario.getText().toString();
        String pwd = senha.getText().toString();

        if("admin".equals(user) && "123".equals(pwd)){
            startActivity(new Intent(this, ConfiguracaoActivity.class));
        }else{
            String msgErro = getString(R.string.erro_autenticacao);
            Toast toast = Toast.makeText(this, msgErro, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
