package com.example.gferreir.projectcleaner;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;

public class ConfiguracaoActivity extends AppCompatActivity {

    static ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostra_usuarios);
        listView = (ListView)findViewById(R.id.listViewB);
        mostraLista();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Context context = view.getContext();
                final Usuario usuario= (Usuario) listView.getItemAtPosition(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Excluir").setMessage("Excluir registro?").setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new GerenciaConfig(getBaseContext()).excluirUser(usuario.id);
                        Toast.makeText(context,"Exclusão realizada", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).setNegativeButton("Cancelar",null).create().show();
                return true;
            }
        });
    }

    public void mostraLista(){
        List<Usuario> listinha = new GerenciaConfig(this).retornaUsers();
        if(listinha.size() == 0)
            Toast.makeText(this,"Nenhum registro localizado",Toast.LENGTH_SHORT).show();

        ArrayAdapter<Usuario> userzinho = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listinha);

        listView.setAdapter(userzinho);
    }

}
