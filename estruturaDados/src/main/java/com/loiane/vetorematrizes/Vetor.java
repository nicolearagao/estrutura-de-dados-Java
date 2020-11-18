/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loiane.vetorematrizes;

/**
 *
 * @author nicole
 */
public class Vetor {

    public static void main(String[] args) {

        //5 alunos e 3 notas 
        double[][] notaAlunos = new double[2][3];

        notaAlunos[0][0] = 10.0;
        notaAlunos[0][1] = 10.0;
        notaAlunos[0][2] = 8.0;

        notaAlunos[1][0] = 5.0;
        notaAlunos[1][1] = 8.0;
        notaAlunos[1][2] = 9.0;

        //iterando na matriz
        for (int i = 0; i < notaAlunos.length; i++) {
            for (int j = 0; j < notaAlunos[i].length; j++) {
                System.out.print(notaAlunos[i][j] + " - ");
            }
            System.out.println("");
        }

        //somando as notas 
        double soma;
        for (int i = 0; i < notaAlunos.length; i++) {
            soma = 0;

            for (int j = 0; j < notaAlunos[i].length; j++) {
                soma = soma + notaAlunos[i][j];
            }
            
            System.out.println("Media do aluno " +i +" e " +soma/4);
        }

    }

}
