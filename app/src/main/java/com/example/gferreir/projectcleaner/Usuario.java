package com.example.gferreir.projectcleaner;

import java.io.Serializable;

public class Usuario implements Serializable {


    Usuario(){

    }

    public Usuario(String nome,String senha,String confirmarSenha){
        this.nome=nome;
        this.senha=senha;
        this.confirmarSenha=senha;

    }

    private String nome;
    private String senha;
    private String confirmarSenha;

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


}
