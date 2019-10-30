package com.company;

import java.util.Scanner;
//para evitar erros de leitura, caso contrário ele estava pulando comandos no main.

public class KeyBoard {
    public int Inteiro(){
        Scanner tc = new Scanner(System.in);
        return tc.nextInt();
    }

    public Float Float(){
        Scanner tc = new Scanner(System.in);
        return tc.nextFloat();
    }

    public String string(){
        Scanner tc = new Scanner(System.in);
        return tc.nextLine();
    }

}
