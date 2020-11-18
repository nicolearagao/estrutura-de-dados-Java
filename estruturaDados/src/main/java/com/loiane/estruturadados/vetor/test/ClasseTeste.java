/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loiane.estruturadados.vetor.test;

import com.loiane.estruturadados.vetor.VetorObjetos;
import java.util.Objects;

/**
 *
 * @author nicole
 */
public class ClasseTeste {
   
    private String nome;
    private int age;

    public ClasseTeste(String nome, int age) {
        this.nome = nome;
        this.age = age;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ClasseTeste{" + "nome=" + nome + ", age=" + age + '}';
    }

 

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClasseTeste other = (ClasseTeste) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        ClasseTeste ob1 = new ClasseTeste("Nicole", 31);
        ClasseTeste ob2 = new ClasseTeste("Fabio", 33);
        
        VetorObjetos vetor = new VetorObjetos(5);
        
        vetor.adiciona(ob1);
        vetor.adiciona(ob2);
        
        System.out.println(vetor);
        
        //operacao possivel por conta do autoboxing que transforma int em Integer 
        vetor.adiciona(1);
        vetor.adiciona("Oe");
        
        System.out.println(vetor);
        
    }
    
    
}
