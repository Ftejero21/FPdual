package edu.fpdual.ejemplo.proyect;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero1;
        int numero2;

        System.out.println("Indiqueme el primer numero");
            numero1 = sc.nextInt();
        System.out.println("Indiqueme el segundo Numero");
            numero2 = sc.nextInt();
        int res = numero1 + numero2;
        System.out.println(res);
    }
}
