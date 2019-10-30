package com.company;

public class ListaMeio {
    Meio inicio;
    Meio fim;
    int qtd;

    public boolean add(Meio meio){
        if (this.inicio==null){
            this.inicio=meio;
            this.fim=meio;

        }else {
            this.fim.proximo=meio;
            this.fim=meio;
        }
        qtd++;
        return true;
    }
    public void listar(){
        Meio aux=this.inicio;
        for (int i=0;i<this.qtd;i++){
            System.out.println("dado:"+ aux.getDado());
        }
    }
}
