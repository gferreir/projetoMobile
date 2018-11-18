package com.example.gferreir.projectcleaner;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

public class GerenciaLimpeza {

    // declaração de variáveis
    private Context context;
    public GerenciaLimpeza(Context context) {
        this.context = context;
    }

    // método responsável por salvar o registro no banco de dados
    public void salvarLimpeza(Limpeza limpeza) {
        DBAdapter dba = new DBAdapter(context);
        String sql = limpeza.id == 0 ? "INSERT INTO limpeza(sala,funcionario,tipo,produto)" +
                " VALUES ('%s','%s','%s','%s')" : "UPDATE limpeza SET sala='%s',funcionario='%s'," +
                "tipo='%s',produto='%s' WHERE id=" + limpeza.id;

        sql = String.format(sql, limpeza.sala, limpeza.funcionario, limpeza.tipoLimpeza, limpeza.produto);

        dba.execComandoSql(sql);
    }

    // método responsável por deletar um registro no banco de dados
    public void excluirLimpeza(int id){
        DBAdapter dba = new DBAdapter(context);
        String sql = "DELETE FROM limpeza WHERE id=" + id;
        dba.execComandoSql(sql);
    }

    public List<Limpeza> retornaLimpezas() {
        return retornaLimpezas(null);
    }

    // método responsável por retornar o registro salvo no bando de dados
    public List<Limpeza> retornaLimpezas(String rasqe) {
        String sql = "SELECT id,sala,funcionario,tipo,produto FROM limpeza";

        if (rasqe != null && !rasqe.equals(""))
            sql += "WHERE sala LIKE %";

        List<Limpeza> limpeza = new ArrayList<>();

        DBAdapter dba = new DBAdapter(context);

        Cursor cursor = dba.execConsultSql(sql);

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String sala = cursor.getString(1);
            String funcionario = cursor.getString(2);
            String tipo = cursor.getString(3);
            String produto = cursor.getString(4);
            Limpeza lmpz = new Limpeza(id,sala,funcionario,tipo,produto);
            limpeza.add(lmpz);
        }

        dba.fecharConexao();
        return limpeza;
    }
}
