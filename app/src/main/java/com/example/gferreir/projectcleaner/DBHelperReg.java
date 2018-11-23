package com.example.gferreir.projectcleaner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperReg extends SQLiteOpenHelper {

    static final int database_version = 1;
    static final String database_nome = "registroUsuario1.db";

    public DBHelperReg(Context context){
        super(context,database_nome,null,database_version);
    }

    // método responsável pela criação da tabela onde ficará registrado as informações
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Utilizador(id integer primary key autoincrement, " +
                "username text not null, password text not null);");
        /*String str = "CREATE TABLE Utilizador(id interger primary key autoincrement, " +
                "username text not null, password text not null);";
        db.execSQL(str);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int old_Version, int new_Version){
    }

    /*
    @Override
    public void onUpgrade(SQLiteDatabase db,int old_Version, int new_Version){
        db.execSQL("DROP TABLE IF EXISTS Utilizador;");
        onCreate(db);
    }

    public long CriarUtilizador(String username, String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("password",password);

        long result = db.insert("Utilizador",null,cv);

        return result;
    }
    */
    public String ValidarLogin(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Utilizador WHERE username=? AND password =?", new String[]{username, password});
        if (c.getCount() > 0) {
            return "OK";
        }
        return "ERRO";
    }

}