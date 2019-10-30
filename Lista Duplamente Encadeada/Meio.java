package com.company;

import java.util.Scanner;

public class Meio {
    Scanner teclado=new Scanner(System.in);

    public Meio proximo;
    private String dado;
    private String tipo;


    public Meio getProximo() {
        return proximo;
    }

    public void setProximo(Meio proximo) {
        this.proximo = proximo;
    }

    public String getDado() {
        return dado;
    }

    public void setDado(String dado) {
        this.dado = dado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void lerEmail(){
        KeyBoard tc=new KeyBoard();
        System.out.println("Digite o Email:");
        this.setDado(tc.string());

    }
    public void lerFone(){
        KeyBoard tc=new KeyBoard();
        System.out.println("Digite o telefone:");
        this.setDado(tc.string());

    }
}

