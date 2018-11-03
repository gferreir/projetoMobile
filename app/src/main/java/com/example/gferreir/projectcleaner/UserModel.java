package com.example.gferreir.projectcleaner;

import java.io.Serializable;

public class UserModel implements Serializable {

    private String sala, funcionario, tipoLimpeza, produto;
    private int id;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getSala(){
        return sala;
    }

    public void setSala(String sala){
        this.sala = sala;
    }

    public String getFuncionario(){
        return funcionario;
    }

    public void setFuncionario(String funcionario){
        this.funcionario = funcionario;
    }

    public String getTipoLimpeza(){
        return tipoLimpeza;
    }

    public void setTipoLimpeza(String tipoLimpeza){
        this.tipoLimpeza = tipoLimpeza;
    }

    public String getProduto(){
        return produto;
    }

    public void setProduto(String produto){
        this.produto = produto;
    }

}
