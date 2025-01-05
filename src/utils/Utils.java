package utils;

import models.*;

import java.util.Scanner;

public class Utils {
    public static void limpiarpantalla(){
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public static void animacionFinSesion(){
        System.out.print("CERRANDO SU SESIÓN");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
        }
        System.out.println();
    }

    public static void pulsaContinuar(){
        Scanner s = new Scanner(System.in);
        System.out.println("Pulsa para continuar...");
        s.nextLine();
    }

    public static void pintaCatalogo() {
        Productos prod1 = new Productos("PlayStation 5", 469.99);
        Productos prod2 = new Productos("El Árbol de la ciencia - Pio Baroja", 10.40);
        Productos prod3 = new Productos("IPhone 16 Pro Max", 1550);
        Productos prod4 = new Productos("Xiaomi 11T", 233.83);
        Productos prod5 = new Productos("Netflix Tarjeta Regalo 100 euros", 100);
        Productos prod6 = new Productos("Playmobil Casa de Campo", 54.99);
        Productos prod7 = new Productos("Zootrópolis - DVD", 13.89);
        Productos prod8 = new Productos("FunkoPop! - Arcane Jinx", 15.99);

        System.out.println("=== CATÁLOGO DE PRODUCTOS ===");
        System.out.println(prod1.pintaCatalogo());
        System.out.println(prod2.pintaCatalogo());
        System.out.println(prod3.pintaCatalogo());
        System.out.println(prod4.pintaCatalogo());
        System.out.println(prod5.pintaCatalogo());
        System.out.println(prod6.pintaCatalogo());
        System.out.println(prod7.pintaCatalogo());
        System.out.println(prod8.pintaCatalogo());
    }




}
