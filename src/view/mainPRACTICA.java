package view;

import models.Administrador;
import models.Cliente;
import models.Productos;
import models.Trabajadores;
import utils.Utils;

import java.util.Scanner;

public class mainPRACTICA {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Cliente c1 = new Cliente("hola@hola", "1234", "avda gran via", "Martos", "Jaén", 642353455, "hola");
        Cliente c2 = null;
        Trabajadores t1 = new Trabajadores("Jose Luis", "1234");
        Trabajadores t2 = null;
        Trabajadores t3 = null;
        Administrador admin = new Administrador("Admin", "root");
        Productos prod1 = new Productos("PlayStation 5", 469.99);
        Productos prod2 = new Productos("El Árbol de la ciencia - Pio Baroja", 10.40);
        Productos prod3 = new Productos("IPhone 16 Pro Max", 1550);
        Productos prod4 = new Productos("Xiaomi 11T", 233.83);
        Productos prod5 = new Productos("Netflix Tarjeta Regalo 100 euros", 100);
        Productos prod6 = new Productos("Playmobil Casa de Campo", 54.99);
        Productos prod7 = new Productos("Zootrópolis - DVD", 13.89);
        Productos prod8 = new Productos("FunkoPop! - Arcane Jinx", 15.99);
        boolean inicioCorrectoC1 = false, inicioCorrectoC2 = false, inicioCorrectoT1 = false, inicioCorrectoT2 = false,
                inicioCorrectoT3 = false, inicioCorrectoAdmin = false, inicioCorrectoCliente = false, inicioCorrectoTrabajador = false;
        String op, correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, nombreTeclado;
        int telefonoTeclado;

        do { //Bucle infinito
            System.out.print("""
                    BIENVENIDO.
                    1. Iniciar sesión
                    2. Registrarse
                    ELIGA UNA OPCIÓN:\s""");
            op = s.nextLine();

            switch (op) {
                case "1"://Iniciar sesión
                    System.out.print("""
                            INICIO DE SESIÓN:
                            Introduzca correo electrónico (Cliente) o nombre (Trabajador o Admininistrador):\s""");
                    correoTeclado = s.nextLine();
                    System.out.print("Introduce tu contraseña: ");
                    contraTeclado = s.nextLine();
                    if (c1 != null && c1.iniciaSesion(contraTeclado, correoTeclado)) inicioCorrectoC1 = true;
                    else if (c2 != null && c2.iniciaSesion(contraTeclado, correoTeclado)) inicioCorrectoC2 = true;
                    else if (t1 != null && t1.iniciaSesion(contraTeclado, correoTeclado)) inicioCorrectoT1 = true;
                    else if (t2 != null && t2.iniciaSesion(contraTeclado, correoTeclado)) inicioCorrectoT2 = true;
                    else if (t3 != null && t3.iniciaSesion(contraTeclado, correoTeclado)) inicioCorrectoT3 = true;
                    else if (admin != null && admin.iniciaSesion(contraTeclado, correoTeclado)) inicioCorrectoAdmin = true;
                    else System.out.println("Datos incorrectos...");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                    break;
                case "2"://Registrarse
                    if (c1 != null && c2 != null) System.out.println("No se pueden crear más clientes");
                    else {
                        System.out.print("""
                                REGISTRO:
                                Introduzca correo electrónico:\s""");
                        correoTeclado = s.nextLine();
                        System.out.print("Introduce la contraseña de tu cuenta: ");
                        contraTeclado = s.nextLine();
                        System.out.print("Introduce un nombre para su cuenta: ");
                        nombreTeclado = s.nextLine();
                        System.out.print("Introduce tu direccion: ");
                        direccionTeclado = s.nextLine();
                        System.out.print("Introduce su localidad: ");
                        localidadTeclado = s.nextLine();
                        System.out.print("Introduce su provincia: ");
                        provinciaTeclado = s.nextLine();
                        System.out.print("Introduzca su teléfono: ");
                        telefonoTeclado = Integer.parseInt(s.nextLine());
                        if (c1 == null)
                            c1 = new Cliente(correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado, nombreTeclado);
                        else
                            c2 = new Cliente(correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado, nombreTeclado);

                        System.out.println("Registro guardado correctamente");
                    }
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
                    break;
                default://Opción no existente
                    System.out.println("Valor no válido");
                    Utils.pulsaContinuar();
                    Utils.limpiarpantalla();
            }

            if (inicioCorrectoC1 || inicioCorrectoC2) {//Si el login es correcto para los clientes
                do {
                    if (inicioCorrectoC1) System.out.println(c1.menuCliente());
                    if (inicioCorrectoC2) System.out.println(c2.menuCliente());
                    op = s.nextLine();
                    switch (op) {
                        case "1"://Consultar el catálogo de productos
                            System.out.println("=== CATÁLOGO DE PRODUCTOS ===");
                            System.out.println(prod1.pintaCatalogo());
                            System.out.println(prod2.pintaCatalogo());
                            System.out.println(prod3.pintaCatalogo());
                            System.out.println(prod4.pintaCatalogo());
                            System.out.println(prod5.pintaCatalogo());
                            System.out.println(prod6.pintaCatalogo());
                            System.out.println(prod7.pintaCatalogo());
                            System.out.println(prod8.pintaCatalogo());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "2"://Realizar un pedido en clientes
                            break;
                        case "3"://Ver pedidos realizados de clientes
                            break;
                        case "4"://Ver datos personales cliente
                            if (inicioCorrectoC1) System.out.println(c1.pintaCliente());
                            if (inicioCorrectoC2) System.out.println(c2.pintaCliente());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "5"://Modificar datos personales clientes
                            System.out.print("""
                                REGISTRO:
                                Introduzca nuevo correo electrónico:\s""");
                            correoTeclado = s.nextLine();
                            System.out.print("Introduce la nueva contraseña de tu cuenta: ");
                            contraTeclado = s.nextLine();
                            System.out.print("Introduce un nuevo nombre para su cuenta: ");
                            nombreTeclado = s.nextLine();
                            System.out.print("Introduce tu nueva direccion (o repita datos): ");
                            direccionTeclado = s.nextLine();
                            System.out.print("Introduce su nueva localidad (o repita datos): ");
                            localidadTeclado = s.nextLine();
                            System.out.print("Introduce su nueva provincia (o repita datos): ");
                            provinciaTeclado = s.nextLine();
                            System.out.print("Introduzca su nuevo teléfono (o repita datos): ");
                            telefonoTeclado = Integer.parseInt(s.nextLine());
                            if (inicioCorrectoC1)
                                c1 = new Cliente(correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado, nombreTeclado);
                            if (inicioCorrectoC2)
                                c2 = new Cliente(correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, telefonoTeclado, nombreTeclado);
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "6"://Cerrar sesión clientes
                            if (inicioCorrectoC1) inicioCorrectoC1 = false;
                            if (inicioCorrectoC2) inicioCorrectoC2 = false;
                            Utils.animacionFinSesion();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        default://Opción no existente
                            System.out.println("Valor no válido");
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                    }
                } while (!op.equals("6"));
            }

            if (inicioCorrectoT1 || inicioCorrectoT2 || inicioCorrectoT3) {
                do {
                    System.out.print(t1.menuTrabajador());
                    op = s.nextLine();
                    switch (op) {
                        case "1": //Consultar los pedidos que tengo asignados
                            break;
                        case "2": //Modificar el estado de un pedido
                            break;
                        case "3": //Consultar el catálogo de productos
                            System.out.println("=== CATÁLOGO DE PRODUCTOS ===");
                            System.out.println(prod1.pintaCatalogo());
                            System.out.println(prod2.pintaCatalogo());
                            System.out.println(prod3.pintaCatalogo());
                            System.out.println(prod4.pintaCatalogo());
                            System.out.println(prod5.pintaCatalogo());
                            System.out.println(prod6.pintaCatalogo());
                            System.out.println(prod7.pintaCatalogo());
                            System.out.println(prod8.pintaCatalogo());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "4": //Modificar un producto del catálogo
                            break;
                        case "5": //Ver mi perfil
                            if (inicioCorrectoT1) System.out.println(t1.pintaTrabajadores());
                            if (inicioCorrectoT2) System.out.println(t2.pintaTrabajadores());
                            if (inicioCorrectoT3) System.out.println(t3.pintaTrabajadores());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "6": //Modificar mis datos personales
                            break;
                        case "7": //Cerrar sesión
                            if (inicioCorrectoT1) inicioCorrectoT1 = false;
                            if (inicioCorrectoT2) inicioCorrectoT2 = false;
                            if (inicioCorrectoT3) inicioCorrectoT3 = false;
                            Utils.animacionFinSesion();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        default://Opción no existente
                            System.out.println("Valor no válido");
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                    }
                } while (!op.equals("7"));
            }

            if (inicioCorrectoAdmin) { //Si el login es correcto de admin
                do {
                    System.out.println(admin.menuAdministrador());
                    op = s.nextLine();
                    switch (op) {
                        case "1": //Asignar un pedido a un trabajador
                            break;
                        case "2": //Modificar el estado de un pedido
                            break;
                        case "3": //Dar de alta un trabajador
                            break;
                        case "4": //Ver todos los pedidos

                            break;
                        case "5": //Ver todos los clientes
                            if (c1 != null) System.out.println(c1.pintaCliente());
                            if (c2 != null) System.out.println(c2.pintaCliente());
                            if (c1 == null && c2 == null) System.out.println("No hay clientes registrados...");
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "6": //Ver todos los trabajadores
                            if (t1 != null) System.out.println(t1.pintaTrabajadores());
                            if (t2 != null) System.out.println(t2.pintaTrabajadores());
                            if (t3 != null) System.out.println(t3.pintaTrabajadores());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "7": //Cerrar sesión
                            inicioCorrectoAdmin = false;
                            Utils.animacionFinSesion();
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        default://Opción no existente
                            System.out.println("Valor no válido");
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                    }
                } while (!op.equals("7"));
            }
        } while (true);

    }
}