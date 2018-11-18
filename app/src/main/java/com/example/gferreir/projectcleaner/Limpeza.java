package com.example.gferreir.projectcleaner;

import java.io.Serializable;

public class Limpeza implements Serializable {

    // declaração das variáveis
    int id;
    String sala, funcionario, tipoLimpeza, produto;

    // método construtor
    public Limpeza(int id, String sala, String funcionario, String tipoLimpeza, String produto){
        this.id = id;
        this.sala = sala;
        this.funcionario = funcionario;
        this.tipoLimpeza = tipoLimpeza;
        this.produto = produto;
    }

    @Override
    public String toString(){
        return this.sala;
    }

}
