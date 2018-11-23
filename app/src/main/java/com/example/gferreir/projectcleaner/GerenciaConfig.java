package com.example.gferreir.projectcleaner;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

public class GerenciaConfig {

    private Context context;

    public GerenciaConfig(Context context){this.context = context;}

    public void salvaUser(Usuario usuario){
        DBAdapterReg dba = new DBAdapterReg(context);
        String sql = usuario.id == 0 ? "INSERT INTO Utilizador(username,password)" +
                " VALUES ('%s','%s')" : "UPDATE Utilizador SET username='%s',password='%s'" +
                " WHERE id=" + usuario.id;

        sql = String.format(sql, usuario.nome, usuario.senha);
        dba.execComandoSql(sql);
    }

    public void excluirUser(int id){
        DBAdapterReg dba = new DBAdapterReg(context);
        String sql = "DELETE FROM Utilizador WHERE id=" + id;
        dba.execComandoSql(sql);
    }

    public List<Usuario> retornaUsers(){
        return retornaUsers(null);
    }

    public List<Usuario> retornaUsers(String rasqe){
        String sql = "SELECT id,username,password FROM Utilizador";
        if (rasqe != null && !rasqe.equals(""))
            sql += "WHERE username LIKE %";

        List<Usuario> usuario = new ArrayList<>();
        DBAdapterReg dba = new DBAdapterReg(context);
        Cursor cursor = dba.execConsultSql(sql);

        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String username = cursor.getString(1);
            String password = cursor.getString(2);
            Usuario usr = new Usuario(id,username,password);
            usuario.add(usr);
        }
        dba.fecharConexao();
        return usuario;
    }

}
