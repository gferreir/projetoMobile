package com.example.gferreir.projectcleaner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // declaração do nome do banco de dados e versão
    static final String database_name = "bancoLimpeza.db";
    static final int database_version = 1;

    public DBHelper(Context context){
        super(context,database_name,null,database_version);
    }

    // método responsável pela criação da tabela onde ficará registrado as informações
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE limpeza(id integer primary key autoincrement, sala text not null," +
                "funcionario text not null, tipo text not null, produto text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int old_Version, int new_Version){
    }

}
