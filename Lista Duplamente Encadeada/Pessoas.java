package com.company;

import java.util.Scanner;

public class Pessoas {
    Scanner teclado = new Scanner(System.in);
    private String nome;
    private String profissão;
    private String endereco;
    public Pessoas proximo;
    public Pessoas anterior;

   public ListaMeio email;
   public ListaMeio telefones;

public Pessoas(){
    email=new ListaMeio();
    telefones=new ListaMeio();
}

    public Pessoas getAnterior() {
        return anterior;
    }

    public void setAnterior(Pessoas anterior) {
        this.anterior = anterior;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissão() {
        return profissão;
    }

    public void setProfissão(String profissão) {
        this.profissão = profissão;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public Pessoas getProximo() {
        return proximo;
    }

    public void setProximo(Pessoas proximo) {
        this.proximo = proximo;
    }
    public boolean pergunta(){
        System.out.println("Deseja adicionar mais?");
        String resp=teclado.next();
        if (resp.equals("s")){
        return true;
    }else {
            return false;

        }
    }
    public void ler(){
    KeyBoard teclado=new KeyBoard();
        System.out.println("Digite o nome:");
            this.setNome(teclado.string());
            System.out.println("Digite Endereço: ");
             this.setEndereco(teclado.string());
             System.out.println("Digite a Profissao: ");
             this.setProfissão(teclado.string());
            do {
                Meio mail= new Meio();
                mail.lerEmail();
                email.add(mail);
            }while (this.pergunta());
            do {
                Meio fone= new Meio();
                fone.lerFone();
                telefones.add(fone);
            }while (this.pergunta());

        }




        }




