package com.company;


public class ListaDupla {
    public Pessoas primeiro;
    public Pessoas ultimo;
    public int qtd;
    public int contador;
    public int contadordelete;

    public int getContadordelete() {
        return contadordelete;
    }

    public void setContadordelete(int contadordelete) {
        this.contadordelete = contadordelete;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Pessoas getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Pessoas primeiro) {
        this.primeiro = primeiro;
    }

    public Pessoas getUltimo() {
        return ultimo;
    }

    public void setUltimo(Pessoas ultimo) {
        this.ultimo = ultimo;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }



    public void listar() {
        Pessoas aux = this.primeiro;
        for (int i = 0; i < this.qtd; i++) {
            System.out.println("Nome:" + aux.getNome());
            System.out.println("Endereço:" + aux.getEndereco());
            System.out.println("Profissão:" + aux.getProfissão());
            aux.email.listar();
            aux.telefones.listar();
            aux = aux.proximo;
        }
    }

    public boolean addInicio(Pessoas p) {
        if (this.primeiro == null) {
            this.primeiro = p;
            this.ultimo = p;
            this.qtd++;
            this.contador++;
            return true;
        } else {
            p.proximo = this.primeiro;
            primeiro.anterior = p;
            this.primeiro = p;
            this.qtd++;
            this.contador++;
            return true;
        }
    }

    public boolean addFim(Pessoas p) {
        if (this.primeiro == null) {
            return addInicio(p);

        } else {
            this.ultimo.proximo = p;
            p.anterior = this.ultimo;
            this.ultimo = p;
            this.qtd++;
            return true;
        }
    }

    public boolean addPosicao(Pessoas c, int p) {
        if (this.primeiro == null || p <= 0) {
            return addInicio(c);
        }
        if (p >= this.qtd) {
            return addFim(c);
        }
        Pessoas aux = this.primeiro;
        for (int i = 0; i < p; i++) {
            aux = aux.proximo;
        }
        c.anterior = aux.anterior;
        aux.anterior.proximo = c;
        c.proximo = aux;
        this.qtd++;
        return true;
    }

    public boolean addOrdem(Pessoas p) {
        int tamanho = 0;
        Pessoas aux = this.primeiro;

        if (this.primeiro == null) {
            return addInicio(p);
        }
        while (p.getNome().compareTo(aux.getNome()) >= 0 && tamanho != this.qtd) {
            aux = aux.getProximo();
            tamanho++;
            if (tamanho == this.qtd)
                return addFim(p);
        }
        return addPosicao(p, tamanho);

    }


    public void gerais() {
        Meio m = new Meio();
        System.out.println("Total de contatos:" + getContador());
        System.out.println("Total adição:" + getContador());
        System.out.println("Total remoção:"+getContadordelete());

    }

    public void list() {
        Pessoas aux = this.primeiro.anterior;
        while (aux != null) {
            System.out.println(aux.getNome());
            aux = aux.proximo;
        }
    }


    public void removeDoComeco() {

        this.primeiro = this.primeiro.getProximo();
        this.qtd--;
        this.contadordelete++;

        if (this.qtd == 0) {
            this.ultimo = null;
        }
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.qtd;
    }

    private Pessoas pegaCelula(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        Pessoas atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    public void removeDoFim() {
        if (!this.posicaoOcupada(this.qtd - 1)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        if (this.qtd == 1) {
            this.removeDoComeco();
        } else {
            Pessoas penultima = this.ultimo.getAnterior();
            penultima.setProximo(null);
            this.ultimo = penultima;
            this.qtd--;
            this.contadordelete++;
        }
    }

    public void remove(int posicao) {

        if (posicao == 0) {
            this.removeDoComeco();
        } else if (posicao == this.qtd - 1) {
            this.removeDoFim();
        } else {
            Pessoas anterior = this.pegaCelula(posicao - 1);
            Pessoas atual = anterior.getProximo();
            Pessoas proxima = atual.getProximo();

            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);
            this.contadordelete++;
            this.qtd--;
        }
    }

    public void pega(int posicao) {
        System.out.println(this.pegaCelula(posicao).getNome());
        System.out.println(this.pegaCelula(posicao).getEndereco());
        System.out.println(this.pegaCelula(posicao).getProfissão());


    }

    public boolean editar(int posicao) {
        Pessoas aux = this.primeiro;
        Pessoas proximo = this.primeiro;
        if (posicao < qtd && posicao > 0) {
            for (int i = 0; i < posicao; i++) {
                proximo = aux.proximo;
                aux = proximo;
            }
        }
        KeyBoard n=new KeyBoard();
        System.out.println("Digite o novo nome:");
        aux.setNome(n.string());
        System.out.println("Digite o novo endereço:");
        aux.setEndereco(n.string());
        System.out.println("Digite a sua profissão:");
        aux.setProfissão(n.string());
        Meio m=new Meio();
        m.lerFone();
        m.lerEmail();
        return true;
    }
}









