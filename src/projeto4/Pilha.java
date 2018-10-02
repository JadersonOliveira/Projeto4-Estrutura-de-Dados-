/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto4;

import java.util.LinkedList;

/**
 *
 * @author jaderson
 */
public class Pilha<T> {
    private LinkedList<T> conteudo;

    public Pilha() {
        conteudo = new LinkedList<>();
    }

    public void empilha(T novoElemento) {
        conteudo.addFirst(novoElemento);
    }

    public T desempilha() {
        if(conteudo.isEmpty())
        throw new Error(" A pilha está vazia");
        return conteudo.removeFirst();
    }

    public boolean estaVazia(){
        return conteudo.isEmpty();
    }
    
    public T topo() {
        if(conteudo.isEmpty())
        throw new Error(" A pilha está vazia");
        return conteudo.getFirst();
    }
    
    public void reinicialize() {
        while (!conteudo.isEmpty())
            conteudo.pop();
    }
    
    public String toString() {         
        String s = "[";
            for (int i = 0; i < this.conteudo.size(); i++) {
                s = s + this.conteudo.get(i).toString();
		if (i == 0 ) {
			s = s + ",";
                }
            }
	s = s + "]";
	return s;
    }
    
     public String toStringInverse() {         

        String s = "[";
		for (int i = this.conteudo.size() - 1; i >= 0; i--) {
			s += this.conteudo.get(i).toString();
			if (i != 0) {
				s += ", ";
			}
		}
		s += "]";

		return s;
    }
    
    static void test1() {
        Pilha<Double> aPilha = new Pilha<Double>();
        aPilha.empilha(1.1);
        aPilha.empilha(2.1);
        aPilha.empilha(3.1);
        aPilha.empilha(4.1);
        aPilha.empilha(5.1);
        double valor = 0.0;
        valor = aPilha.topo();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.topo();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
    }
    
    static void test2() {
        Pilha<Double> aPilha = new Pilha<Double>();
        System.out.println(aPilha);
        aPilha.empilha(1.1);
        System.out.println(aPilha);
        aPilha.empilha(2.1);
        System.out.println(aPilha);
        aPilha.empilha(3.1);
        System.out.println(aPilha);
        double valor = 0.0;
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor );
        System.out.println(aPilha);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor );
        System.out.println(aPilha);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor );
        System.out.println(aPilha);
    }
    
    public static void main(String[] args) {
        test1();
        test2();
    }

   
    
}
