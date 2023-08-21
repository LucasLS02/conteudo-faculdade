package Questao_2;

import java.util.Random;

public class Aplicacao {

	public static void main(String[] args) {
		
		Random rand = new Random();
		Data[] datas = new Data[6];
		
		System.out.println("Antes da Ordenação");
		System.out.println("");
		
		for(int i = 0; i < datas.length;i++) {
			datas[i] = new Data(rand.nextInt(31),rand.nextInt(12), rand.nextInt(3000));
			System.out.println(i + ") " + datas[i].dataPorExtenso());
		}
		
		Data[] datasCrescentes = (Data[]) Ordenador.crescente(datas);
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("Ordenação Crescente");
		System.out.println("");
		for(int j = 0; j < datasCrescentes.length; j++) {
			System.out.println(j + ") " + datasCrescentes[j].dataPorExtenso());
		}
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("Ordenação Decrescente");
		System.out.println("");
		Data[] datasDecrescente = (Data[]) Ordenador.decrescente(datas);
		for(int l = 0; l < datasDecrescente.length; l++) {
			System.out.println(l + ") " + datasDecrescente[l].dataPorExtenso());
		}
	}

}
