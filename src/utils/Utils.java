package utils;

import java.util.Scanner;

public class Utils {
    public static void limpiarpantalla(){
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public static void animacionFinSesion(){
        System.out.print("CERRANDO SU SESIÓN");
        for (int i = 0; i < ; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
        }
    }

    public static void pulsaContinuar(){
        Scanner s = new Scanner(System.in);
        System.out.println("Pulsa para continuar...");
        s.nextLine();
    }
}
