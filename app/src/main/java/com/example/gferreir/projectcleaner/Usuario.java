package com.example.gferreir.projectcleaner;

import java.io.Serializable;

public class Usuario implements Serializable {

    String nome, senha;
    //String confirmarSenha;
    int id;

    public Usuario(int id, String nome,String senha){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        //this.confirmarSenha = senha;
    }

    @Override
    public String toString(){
        return this.nome;
    }

    /*
    Usuario(){
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getConfirmarSenha() {
        return confirmarSenha;
    }
    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
    */

}
