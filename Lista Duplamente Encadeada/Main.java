package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int op=0;
        Scanner scan=new Scanner(System.in);

        ListaDupla l=new ListaDupla();
	do{
        System.out.println("\nAGENDA ESTRUTURA DE DADOS COM LISTA DUPLAMENTE ENCADEADA\n\n1- Adicionar contato\n2- Editar contato\n3- Listar contato\n4- Remover contato\n5- Buscar contato\n0- Sair");
        l.gerais();
        op = scan.nextInt();

        if (op==1) {
            Pessoas p=new Pessoas();
            p.ler();
            l.addInicio(p);
        }
            else if (op==2) {
            System.out.println("Digite a posição no qual deseja editar:");
                int posicao=scan.nextInt();
                l.editar(posicao);
        }
        else if (op==3){
            l.listar();

        }
        else if (op==4){
            KeyBoard tc=new KeyBoard();
            System.out.println("Qual posição deseja remover?");
            int posicao= tc.Inteiro();
            l.remove(posicao);
        }
        else if (op==5){

            KeyBoard tc=new KeyBoard();
            System.out.println("Digite o elemento na posição que deseja buscar:");
            int posicao= tc.Inteiro();
            l.pega(posicao);


        }
        else{
            System.out.println("FIM");
            break;

        }


    }while(op!=0);


    }
}
