package com.example.gferreir.projectcleaner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static String DATABASE_NAME = "user_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "users";
    private static final String KEY_ID = "id";
    private static final String KEY_SALA = "sala";
    private static final String KEY_FUNCIONARIO = "funcionario";
    private static final String KEY_TIPO = "tipo";
    private static final String KEY_PRODUTO = "produto";

    private static final String CREATE_TABLE_EMPRESA = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_SALA + " TEXT, "+ KEY_FUNCIONARIO
            + " TEXT, " + KEY_TIPO + " TEXT, " + KEY_PRODUTO + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d("table", CREATE_TABLE_EMPRESA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EMPRESA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER + "'");
        onCreate(db);
    }

    public long addUserDetail(String sala, String funcionario, String tipo, String produto) {

        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values
        ContentValues values = new ContentValues();
        values.put(KEY_SALA, sala);
        values.put(KEY_FUNCIONARIO, funcionario);
        values.put(KEY_TIPO, tipo);
        values.put(KEY_PRODUTO, produto);
        // insert row in students table
        long insert = db.insert(TABLE_USER, null, values);

        return insert;
    }

    public ArrayList<UserModel> getAllUsers() {
        ArrayList<UserModel> userModelArrayList = new ArrayList<UserModel>();

        String selectQuery = "SELECT  * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                UserModel userModel = new UserModel();
                userModel.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                userModel.setSala(c.getString(c.getColumnIndex(KEY_SALA)));
                userModel.setFuncionario(c.getString(c.getColumnIndex(KEY_FUNCIONARIO)));
                userModel.setTipoLimpeza(c.getString(c.getColumnIndex(KEY_TIPO)));
                userModel.setProduto(c.getString(c.getColumnIndex(KEY_PRODUTO)));
                // adding to Students list
                userModelArrayList.add(userModel);
            } while (c.moveToNext());
        }
        return userModelArrayList;
    }

    public int updateUser(int id, String sala, String funcionario, String tipo, String produto) {

        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values
        ContentValues values = new ContentValues();
        values.put(KEY_SALA, sala);
        values.put(KEY_FUNCIONARIO, funcionario);
        values.put(KEY_TIPO, tipo);
        values.put(KEY_PRODUTO, produto);
        // update row in students table base on students.is value
        return db.update(TABLE_USER, values, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    public void deleteUSer(int id) {

        // delete row in students table based on id
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

}
