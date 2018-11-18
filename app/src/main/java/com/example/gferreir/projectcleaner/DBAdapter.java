package com.example.gferreir.projectcleaner;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {

    SQLiteDatabase db = null;
    DBHelper dbhelper = null;

    // classe responsável por execução dos comandos SQL
    public DBAdapter(Context context){
        dbhelper = new DBHelper(context);
    }

    // método abre conexão com o banco de dados
    public void abreConexecao(){
        if(db == null)
            db = dbhelper.getWritableDatabase();
    }

    // método fecha conexão com o banco de dados
    public void fecharConexao(){
        if(db != null && db.isOpen()){
            db.close();
            db = null;
        }
    }

    // método chama método do plugin do SQLite
    public void execComandoSql(String sql){
        abreConexecao();
        db.execSQL(sql);
        fecharConexao();
    }

    // método abre conexão com o banco de dados
    // e consulta
    public Cursor execConsultSql(String sql){
        abreConexecao();
        return db.rawQuery(sql,null);
    }

}
