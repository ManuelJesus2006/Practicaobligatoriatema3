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
        Productos productoSeleccionado1 = null;
        Productos productoSeleccionado2 = null;
        Productos productoSeleccionado3 = null;
        boolean inicioCorrectoC1 = false, inicioCorrectoC2 = false, inicioCorrectoT1 = false, inicioCorrectoT2 = false,
                inicioCorrectoT3 = false, inicioCorrectoAdmin = false, productoFinalizado = false;
        String op, correoTeclado, contraTeclado, direccionTeclado, localidadTeclado, provinciaTeclado, nombreTeclado,
                productoTeclado;
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
                            if (inicioCorrectoC1){//Realizar el pedido en cliente 1
                                if (!c1.hayHueco()) System.out.println("No se pueden realizar más pedidos");
                                else{
                                    productoFinalizado = false;
                                    int contadorProductos = 0;
                                    System.out.print("Introduce el número del producto mostrado en el catálogo (máximo 3 productos): ");
                                    productoTeclado = s.nextLine();
                                    switch (productoTeclado){//Switch producto 1 cliente 1
                                        case "1":
                                            productoSeleccionado1 = prod1;
                                            contadorProductos++;
                                            break;
                                        case "2":
                                            productoSeleccionado1 = prod2;
                                            contadorProductos++;
                                            break;
                                        case "3":
                                            productoSeleccionado1 = prod3;
                                            contadorProductos++;
                                            break;
                                        case "4":
                                            productoSeleccionado1 = prod4;
                                            contadorProductos++;
                                            break;
                                        case "5":
                                            productoSeleccionado1 = prod5;
                                            contadorProductos++;
                                            break;
                                        case "6":
                                            productoSeleccionado1 = prod6;
                                            contadorProductos++;
                                            break;
                                        case "7":
                                            productoSeleccionado1 = prod7;
                                            contadorProductos++;
                                            break;
                                        case "8":
                                            productoSeleccionado1 = prod8;
                                            contadorProductos++;
                                            break;
                                        default:
                                            System.out.println("Dicho producto no existe");
                                            Utils.pulsaContinuar();
                                            Utils.limpiarpantalla();
                                    }
                                    System.out.println("Producto agregado a la cesta");
                                    Utils.pulsaContinuar();
                                    Utils.limpiarpantalla();



                                    System.out.println("¿Desea agregar otro producto? (llevas " + ((contadorProductos == 1)
                                            ? "un producto)" : contadorProductos + " productos)") + "(S/N)");
                                    op = s.nextLine();
                                    if (op.equalsIgnoreCase("S")){//Añadir producto 2
                                        System.out.print("Introduce el número del producto mostrado en el catálogo: ");
                                        productoTeclado = s.nextLine();
                                        switch (productoTeclado){
                                            case "1":
                                                productoSeleccionado2 = prod1;
                                                contadorProductos++;
                                                break;
                                            case "2":
                                                productoSeleccionado2 = prod2;
                                                contadorProductos++;
                                                break;
                                            case "3":
                                                productoSeleccionado2 = prod3;
                                                contadorProductos++;
                                                break;
                                            case "4":
                                                productoSeleccionado2 = prod4;
                                                contadorProductos++;
                                                break;
                                            case "5":
                                                productoSeleccionado2 = prod5;
                                                contadorProductos++;
                                                break;
                                            case "6":
                                                productoSeleccionado2 = prod6;
                                                contadorProductos++;
                                                break;
                                            case "7":
                                                productoSeleccionado2 = prod7;
                                                contadorProductos++;
                                                break;
                                            case "8":
                                                productoSeleccionado2 = prod8;
                                                contadorProductos++;
                                                break;
                                            default:
                                                System.out.println("Dicho producto no existe");
                                                Utils.pulsaContinuar();
                                                Utils.limpiarpantalla();

                                        }
                                        System.out.println("Producto agregado a la cesta");
                                        Utils.pulsaContinuar();
                                        Utils.limpiarpantalla();


                                    }else{
                                        productoFinalizado = true;
                                        c1.realizaPedido(productoSeleccionado1);//Realizar pedido solo con un producto
                                        System.out.println("Su precio a pagar en total es de " + c1.recibirPrecioTotal());
                                        Utils.pulsaContinuar();
                                        Utils.limpiarpantalla();


                                    }
                                    if (!productoFinalizado){
                                        System.out.println("¿Desea agregar otro producto? (llevas " + ((contadorProductos == 1)
                                                ? "un producto)" : contadorProductos + " productos)") + "(S/N)");
                                        op = s.nextLine();
                                    }
                                    if (op.equalsIgnoreCase("S") && contadorProductos == 2){//Añadir producto 3 y último
                                        System.out.print("Introduce el número del producto mostrado en el catálogo: ");
                                        productoTeclado = s.nextLine();
                                        switch (productoTeclado){
                                            case "1":
                                                productoSeleccionado3 = prod1;
                                                contadorProductos++;
                                                break;
                                            case "2":
                                                productoSeleccionado3 = prod2;
                                                contadorProductos++;
                                                break;
                                            case "3":
                                                productoSeleccionado3 = prod3;
                                                contadorProductos++;
                                                break;
                                            case "4":
                                                productoSeleccionado3 = prod4;
                                                contadorProductos++;
                                                break;
                                            case "5":
                                                productoSeleccionado3 = prod5;
                                                contadorProductos++;
                                                break;
                                            case "6":
                                                productoSeleccionado3 = prod6;
                                                contadorProductos++;
                                                break;
                                            case "7":
                                                productoSeleccionado3 = prod7;
                                                contadorProductos++;
                                                break;
                                            case "8":
                                                productoSeleccionado3 = prod8;
                                                contadorProductos++;
                                                break;
                                            default:
                                                System.out.println("Dicho producto no existe");

                                        }
                                        System.out.println("Producto agregado a la cesta");
                                        Utils.pulsaContinuar();
                                        Utils.limpiarpantalla();



                                        System.out.println("No se pueden añadir más productos");
                                        productoFinalizado = true;
                                        c1.realizaPedido(productoSeleccionado1, productoSeleccionado2, productoSeleccionado3);//Realizar pedido con los tres productos
                                        System.out.println("Su precio a pagar en total es de " + c1.recibirPrecioTotal());
                                        Utils.pulsaContinuar();
                                        Utils.limpiarpantalla();


                                    }if (op.equalsIgnoreCase("N") && contadorProductos == 2){
                                        productoFinalizado = true;
                                        c1.realizaPedido(productoSeleccionado1, productoSeleccionado2);//Realizar pedido solo con dos productos
                                        System.out.println("Su precio a pagar en total es de " + c1.recibirPrecioTotal());
                                        Utils.pulsaContinuar();
                                        Utils.limpiarpantalla();
                                    }
                                }
                            }
                            if (inicioCorrectoC2){//Realizar el pedido en cliente 1
                                if (!c2.hayHueco()) System.out.println("No se pueden realizar más pedidos");
                                else{
                                    productoFinalizado = false;
                                    int contadorProductos = 0;
                                    System.out.print("Introduce el número del producto mostrado en el catálogo (máximo 3 productos): ");
                                    productoTeclado = s.nextLine();
                                    switch (productoTeclado){//Switch producto 1 cliente 1
                                        case "1":
                                            productoSeleccionado1 = prod1;
                                            contadorProductos++;
                                            break;
                                        case "2":
                                            productoSeleccionado1 = prod2;
                                            contadorProductos++;
                                            break;
                                        case "3":
                                            productoSeleccionado1 = prod3;
                                            contadorProductos++;
                                            break;
                                        case "4":
                                            productoSeleccionado1 = prod4;
                                            contadorProductos++;
                                            break;
                                        case "5":
                                            productoSeleccionado1 = prod5;
                                            contadorProductos++;
                                            break;
                                        case "6":
                                            productoSeleccionado1 = prod6;
                                            contadorProductos++;
                                            break;
                                        case "7":
                                            productoSeleccionado1 = prod7;
                                            contadorProductos++;
                                            break;
                                        case "8":
                                            productoSeleccionado1 = prod8;
                                            contadorProductos++;
                                            break;
                                        default:
                                            System.out.println("Dicho producto no existe");
                                            Utils.pulsaContinuar();
                                            Utils.limpiarpantalla();
                                    }
                                    System.out.println("Producto agregado a la cesta");
                                    Utils.pulsaContinuar();
                                    Utils.limpiarpantalla();



                                    System.out.println("¿Desea agregar otro producto? (llevas " + ((contadorProductos == 1)
                                            ? "un producto)" : contadorProductos + " productos)") + "(S/N)");
                                    op = s.nextLine();
                                    if (op.equalsIgnoreCase("S")){//Añadir producto 2
                                        System.out.print("Introduce el número del producto mostrado en el catálogo: ");
                                        productoTeclado = s.nextLine();
                                        switch (productoTeclado){
                                            case "1":
                                                productoSeleccionado2 = prod1;
                                                contadorProductos++;
                                                break;
                                            case "2":
                                                productoSeleccionado2 = prod2;
                                                contadorProductos++;
                                                break;
                                            case "3":
                                                productoSeleccionado2 = prod3;
                                                contadorProductos++;
                                                break;
                                            case "4":
                                                productoSeleccionado2 = prod4;
                                                contadorProductos++;
                                                break;
                                            case "5":
                                                productoSeleccionado2 = prod5;
                                                contadorProductos++;
                                                break;
                                            case "6":
                                                productoSeleccionado2 = prod6;
                                                contadorProductos++;
                                                break;
                                            case "7":
                                                productoSeleccionado2 = prod7;
                                                contadorProductos++;
                                                break;
                                            case "8":
                                                productoSeleccionado2 = prod8;
                                                contadorProductos++;
                                                break;
                                            default:
                                                System.out.println("Dicho producto no existe");
                                                Utils.pulsaContinuar();
                                                Utils.limpiarpantalla();

                                        }
                                        System.out.println("Producto agregado a la cesta");
                                        Utils.pulsaContinuar();
                                        Utils.limpiarpantalla();


                                    }else{
                                        productoFinalizado = true;
                                        c2.realizaPedido(productoSeleccionado1);//Realizar pedido solo con un producto
                                        System.out.println("Su precio a pagar en total es de " + c2.recibirPrecioTotal());
                                        Utils.pulsaContinuar();
                                        Utils.limpiarpantalla();


                                    }
                                    if (!productoFinalizado){
                                        System.out.println("¿Desea agregar otro producto? (llevas " + ((contadorProductos == 1)
                                                ? "un producto)" : contadorProductos + " productos)") + "(S/N)");
                                        op = s.nextLine();
                                    }
                                    if (op.equalsIgnoreCase("S") && contadorProductos == 2){//Añadir producto 3 y último
                                        System.out.print("Introduce el número del producto mostrado en el catálogo: ");
                                        productoTeclado = s.nextLine();
                                        switch (productoTeclado){
                                            case "1":
                                                productoSeleccionado3 = prod1;
                                                contadorProductos++;
                                                break;
                                            case "2":
                                                productoSeleccionado3 = prod2;
                                                contadorProductos++;
                                                break;
                                            case "3":
                                                productoSeleccionado3 = prod3;
                                                contadorProductos++;
                                                break;
                                            case "4":
                                                productoSeleccionado3 = prod4;
                                                contadorProductos++;
                                                break;
                                            case "5":
                                                productoSeleccionado3 = prod5;
                                                contadorProductos++;
                                                break;
                                            case "6":
                                                productoSeleccionado3 = prod6;
                                                contadorProductos++;
                                                break;
                                            case "7":
                                                productoSeleccionado3 = prod7;
                                                contadorProductos++;
                                                break;
                                            case "8":
                                                productoSeleccionado3 = prod8;
                                                contadorProductos++;
                                                break;
                                            default:
                                                System.out.println("Dicho producto no existe");

                                        }
                                        System.out.println("Producto agregado a la cesta");
                                        Utils.pulsaContinuar();
                                        Utils.limpiarpantalla();



                                        System.out.println("No se pueden añadir más productos");
                                        productoFinalizado = true;
                                        c2.realizaPedido(productoSeleccionado1, productoSeleccionado2, productoSeleccionado3);//Realizar pedido con los tres productos
                                        System.out.println("Su precio a pagar en total es de " + c2.recibirPrecioTotal());
                                        Utils.pulsaContinuar();
                                        Utils.limpiarpantalla();


                                    }if (op.equalsIgnoreCase("N") && contadorProductos == 2){
                                        productoFinalizado = true;
                                        c2.realizaPedido(productoSeleccionado1, productoSeleccionado2);//Realizar pedido solo con dos productos
                                        System.out.println("Su precio a pagar en total es de " + c2.recibirPrecioTotal());
                                        Utils.pulsaContinuar();
                                        Utils.limpiarpantalla();
                                    }
                                }
                            }
                            break;
                        case "3"://Ver pedidos realizados de clientes
                            if (inicioCorrectoC1){
                                System.out.println(c1.pintaPedidoCliente());
                                Utils.pulsaContinuar();
                                Utils.limpiarpantalla();
                            }
                            if (inicioCorrectoC2){
                                System.out.println(c2.pintaPedidoCliente());
                                Utils.pulsaContinuar();
                                Utils.limpiarpantalla();
                            }
                            break;
                        case "4"://Ver datos personales cliente
                            if (inicioCorrectoC1) System.out.println(c1.pintaCliente());
                            if (inicioCorrectoC2) System.out.println(c2.pintaCliente());
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "5"://Modificar datos personales clientes
                            System.out.print("""
                                MODIFICACIÓN DE DATOS:
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
                    if (inicioCorrectoT1) System.out.print(t1.menuTrabajador());
                    if (inicioCorrectoT2) System.out.print(t2.menuTrabajador());
                    if (inicioCorrectoT3) System.out.print(t3.menuTrabajador());
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
                            System.out.print("""
                                    MODIFICACIÓN DE DATOS:
                                    Introduce el nuevo nombre del trabajador:\s""");
                            nombreTeclado = s.nextLine();
                            System.out.print("Introduce la nueva clave del trabajador: ");
                            contraTeclado = s.nextLine();
                            if (inicioCorrectoT1) t1 = new Trabajadores(nombreTeclado, contraTeclado);
                            if (inicioCorrectoT2) t2 = new Trabajadores(nombreTeclado, contraTeclado);
                            if (inicioCorrectoT3) t3 = new Trabajadores(nombreTeclado, contraTeclado);
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
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
                            if (t1 != null && t2 != null && t3 != null) System.out.println("No se pueden dar de alta más trabajadores.");
                            else {
                                System.out.print("Introduce el nombre del trabajador: ");
                                nombreTeclado = s.nextLine();
                                System.out.print("Introduce la clave del trabajador: ");
                                contraTeclado = s.nextLine();
                                if (t1 == null) t1 = new Trabajadores(nombreTeclado, contraTeclado);
                                else if (t1 != null && t2 == null) t2 = new Trabajadores(nombreTeclado, contraTeclado);
                                else if (t2 != null && t3 == null) t3 = new Trabajadores(nombreTeclado, contraTeclado);
                            }
                            Utils.pulsaContinuar();
                            Utils.limpiarpantalla();
                            break;
                        case "4": //Ver todos los pedidos
                            if (c1 == null) System.out.println("El cliente 1 no existe");
                            else if (c1.nohayPedidos()) System.out.println("El cliente 1 no ha realizado ningún pedido");
                            else{
                                System.out.println("===== Cliente 1 =====");
                                System.out.println(c1.pintaPedidoCliente());
                            }
                            if (c2 == null) System.out.println("El cliente 2 no existe");
                            else if (c2.nohayPedidos()) System.out.println("El cliente 2 no ha realizado ningún pedido");
                            else{
                            System.out.println("===== Cliente 2 =====");
                            System.out.println(c2.pintaPedidoCliente());
                            }
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