/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto4;

/**
 *
 * @author jaderson
 */
public class operacao {
    private char code;
    private double a, b;
    
    public operacao(char code, double a, double b){
        this.code = code;
        this.a = a;
        this.b = b;
    }
    
    public operacao(double a){
        this.code = 'e';
        this.a = a;
    }
    
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public char getCode() {
        return code;
    }

    public String toString() {
        double tempa = getA();
        String temp = String.valueOf(tempa);
        char tempCode = getCode();
        String tempC = Character.toString(tempCode);

        if (code == 'e')
            return temp; //retornar a
        else
            return tempC; //retornar code
    }
    
    public static void main (String[] args) {
        operacao[] op = new operacao[9];
        op[0] = new operacao(16.0);
        op[1] = new operacao(8.0);
        op[2] = new operacao(4.0);op[3] = new operacao(2.0);
        op[4] = new operacao(1.0);
        op[5] = new operacao('+', 2.0, 1.0);
        op[6] = new operacao('-', 4.0, 3.0);
        op[7] = new operacao('*', 8.0, 1.0);
        op[8] = new operacao('/', 16.0, 8.0);
        for (int i=0; i<op.length; i++)
        System.out.print(op[i] + " ");
        System.out.println();
}
}
