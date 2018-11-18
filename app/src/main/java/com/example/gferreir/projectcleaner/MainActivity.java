package com.example.gferreir.projectcleaner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // variáveis referente ao EditText da tela de login
    private EditText usuario, senha;

    // método onCreate responsável por fazer todas as ações da tela enquanto ativa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // responsável por fazer a tela login_activity ser chamada
        setContentView(R.layout.login_activity);

        // campos de usuário e senha estão declarados
        usuario = (EditText)findViewById(R.id.edtLogin);
        senha = (EditText)findViewById(R.id.edtSenha);
    }

    // método responsável por fazer a verificação dos dados preenchidos nos campos
    // se a condição de o usuário for: admin e a senha: 123
    // a classe InicioActivity é chamada
    // caso contrário aparecerá uma menssagem de erro

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
