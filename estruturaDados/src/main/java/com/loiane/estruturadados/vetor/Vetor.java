/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loiane.estruturadados.vetor;

import java.util.Arrays;

/**
 *
 * @author nicole
 */
public class Vetor {

    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    /*Opcao ineficiente para adicionar elementos a uma array dependendo de seu tamanho
    public void adiciona(String elemento) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] == null) {
                this.elementos[i] = elemento;
                break;
            }
        }
    } */
    //Metodo que adiciona elementos ao vetor e retorna excecao se vetor ja estiver lotado 
    public void adiciona(String elemento) throws Exception {
         this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("Vetor ja esta cheio!");
        }
    }

    //Metodo que adiciona elementos a uma array e retorna true ou false de acordo com o sucesso da operacao 
    public boolean adiciona2(String elemento) {
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }
    // metodo para adicionar um elemento a uma posicao especifica da array
    public void adiciona(int posicao, String elemento){
        this.aumentaCapacidade();
        if(!(posicao >=0 && posicao < this.tamanho )){
            throw new IllegalArgumentException("Posicao invalida");
        }
        // i precisa ser igual a tamanho -1 para evitar o lancamento de uma outOfBounds excecao caso o tamanho seja = 1, significando que ele apenas possui o index 0 
        for(int i = this.tamanho -1; i >= posicao; i-- ){
            this.elementos[i +1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho ++;
    }
    
    public void remover(int posicao){
        if(!(posicao >=0 && posicao < this.tamanho )){
            throw new IllegalArgumentException("Posicao invalida");
        }
        for(int i = posicao; i < this.tamanho -1; i++){
            this.elementos[i]= this.elementos[i+1];
        }
        this.tamanho --;
    }

    // metodo que busca elementos numa array, lancando excecao caso posicao requerida nao seja valida
    public String busca(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posicao invalida");
        }

        return this.elementos[posicao];
    }
    //metodo para dobrar capacidade do array toda vez que seu tamanho real for o mesmo do length. criar uma array nova e atribuir a nova array como o this
    public void aumentaCapacidade(){
        if(this.tamanho == this.elementos.length){
            String [] novaLista = new String[this.tamanho *2];
            
            for(int i = 0; i < this.elementos.length; i ++){
                novaLista[i] = this.elementos[i];
            }
            
            this.elementos = novaLista;
        }
    }

    /* busca sequencial de elemento, retorn um boolean 
    public boolean busca(String elemento){
    for(int i = 0; i < this.tamanho; i++){
        if (this.elementos[i].equals(elemento)){
            return true;
        }
        
    }    
        return false;
    } */
    
    //busca sequencial um pouco mais eficiente, retorna -1 index inexistente, caso numero nao seja encontrado 
    public int busca(String elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }

        }
        return -1;
    }


    /* Metodo ineficiente, vai imprimir todos as posicoes da Array, mesmo NULL
    @Override
    public String toString() {
        return Arrays.toString(elementos); 
                
    }
     */
    //Retorna tamanho real da Array 
    public int getTamanhoReal() {
        return this.tamanho;
    }

    //Usando StringBuilder para construir uma lista com os elementos presentes na Array sem ocupar espaco desnecessario da memoria
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }
        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }
        s.append("]");
        return s.toString();
    }

}
