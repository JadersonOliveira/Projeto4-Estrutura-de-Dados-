/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jaderson
 */
public class CalcRPN {
    Pilha<operacao> hist;
    Pilha<Double> aPilha;
    
    // construtor
    CalcRPN () {
        aPilha = new Pilha<>();
        hist = new Pilha<>();
    }
    // Adiçao de dois elementos do topo da pilha
    void mais() {
        double a = aPilha.desempilha();
        double b = aPilha.desempilha();
        double resultado = b + a;
        aPilha.empilha(resultado);
    }
    // Subtraçao de dois elementos do topo da pilha
    void menos() {
        double a = aPilha.desempilha();
        double b = aPilha.desempilha();
        double resultado = b - a;
        aPilha.empilha(resultado);
    }
    // Multiplicaçao de dois elementos do topo da pilha
    void vezes() {
        double a = aPilha.desempilha();
        double b = aPilha.desempilha();
        double resultado = b * a;
        aPilha.empilha(resultado);
    }
    // Divisao de dois elementos no topo da pilha
    void dividido() {
        double a = aPilha.desempilha();
        double b = aPilha.desempilha();
        double resultado = b / a;
        aPilha.empilha(resultado);
    }
    // retorna o conteudo do topo da pilha
    Double resultado() {
        return aPilha.topo();
        
    }
    
    void cancela(){
        
    }
    // interpretador de comandos
    void exec(String cmd) {
        double valor;

        try {
            valor = (Double.parseDouble(cmd));
            aPilha.empilha(valor);
            hist.empilha(new operacao(valor));

        } catch (NumberFormatException e) {
            if (null == cmd) {
                throw new Error("");

            } else
                switch (cmd) {
                case "+":
                    mais();
                    break;

                case "-":
                    menos();
                    break;

                case "*":
                    vezes();
                    break;

                case "/":
                    dividido();
                    break;
                    
                case "undo":
                    cancela();
                    break;
                    
                case "clear":
                    aPilha.reinicialize();
                    hist.reinicialize();
                    break;
                    
                case "hist":
                    System.out.println(hist.toString());
                    break;

                default:
                    throw new Error("A operacão não é válida!.");
                }

        }
    }
  
    static void test() {
        CalcRPN calc = new CalcRPN() ;
        System.out.print("3 2 + = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.mais();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 - = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.menos();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 * = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.vezes();
        System.out.println(calc.resultado());calc = new CalcRPN();
        System.out.print("3 2 / = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.dividido();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("1 2 + 3 4 - / 10 3 - * = ");
        calc.aPilha.empilha(1.0);
        calc.aPilha.empilha(2.0);
        calc.mais();
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(4.0);
        calc.menos();
        calc.dividido();
        calc.aPilha.empilha(10.0);
        calc.aPilha.empilha(3.0);
        calc.menos();
        calc.vezes();
        System.out.println(calc.resultado());
    }
    
    static void interfaceUsuario() throws IOException {
        CalcRPN calc = new CalcRPN() ;
        String line;
        BufferedReader reader = new BufferedReader
        (new InputStreamReader (System.in));
        while((line = reader.readLine()) != null) {
        if (line.isEmpty())
        continue;
        for (String s : line.split(" "))
        calc.exec(s);
        System.out.println("Pilha = " + calc.aPilha);
        }
        System.out.println("Até logo");
    }
    
    
    
    public static void main(String[] args) throws IOException {
        test(); 
        interfaceUsuario();
    }

}
