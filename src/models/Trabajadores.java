package models;

public class Trabajadores {
    private String nombre;
    private String clave;
    private Pedidos pedido1;
    private Pedidos pedido2;
    private static int contadorPedidos = 1;
    private int contadorPedidosAsignados = 0;

    //Constructor
    public Trabajadores(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
        pedido1 = null;
        pedido2 = null;
    }

    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Pedidos getPedido1() {
        return pedido1;
    }

    public void setPedido1(Pedidos pedido1) {
        this.pedido1 = pedido1;
    }

    public Pedidos getPedido2() {
        return pedido2;
    }

    public void setPedido2(Pedidos pedido2) {
        this.pedido2 = pedido2;
    }

    //Métodos
    public String pintaTrabajadores() {
        return  "================================\n" +
                "Trabajador: " + nombre + "\n" +
                "Clave: " + clave + "\n" +
                "================================";
    }

    public String cuentaPedidos(){
        int contador = 0;
        if (pedido1 != null) contador++;
        if (pedido2 != null) contador++;

        if (contador == 1) return "un pedido";
        if (contador == 2) return "2 pedido";
        return "0 pedidos";
    }

    public String menuTrabajador(){
        String salida = "";
        salida += "FERNANSHOP" + "\n";
        salida += "Bienvenido " + nombre + ". Tienes " + cuentaPedidos() + " que gestionar\n";
        salida += "1.- Consultar los pedidos que tengo asignados" + "\n";
        salida += "2.- Modificar el estado de un pedido" + "\n";
        salida += "3.- Consultar el catálogo de productos" + "\n";
        salida += "4.- Modificar un producto del catálogo" + "\n";
        salida += "5.- Ver mi perfil" + "\n";
        salida += "6.- Modificar mis datos personales" + "\n";
        salida += "7.- Cerrar sesión" + "\n";
        salida += "Introduce una opción:";
        return salida;
    }

    public boolean iniciaSesion(String contrateclado, String nombreteclado){
        return (contrateclado.equals(getClave()) && nombreteclado.equals(getNombre()));
    }

    public void asignaPedido(Pedidos pedido){
        if (pedido1 == null && pedido2 == null) pedido1 = pedido;
        else pedido2 = pedido;
    }

    public int sumarPedidosAsignados(){
        if (pedido1 != null && pedido2 == null) contadorPedidosAsignados = 1;
        if (pedido1 != null && pedido2 != null) contadorPedidosAsignados = 2;
        return contadorPedidosAsignados;
    }

    public String pedidosAsignados1(){
        String salida = "";
        boolean error = false;
        contadorPedidos = 1;
        salida += (pedido1 != null ? contadorPedidos + ". " + pedido1.getId() + " - " + pedido1.getClientePedido().getNombre() + " (" + pedido1.getClientePedido().getLocalidad() + ") - " +
                pedido1.sumarProductosPedido() + " productos - " + pedido1.sumarPrecioProductos() + "€\n" : (error = true));
        if (error){
            salida = "No tienes pedidos asignados";
            contadorPedidos--;
        }
        return salida;
    }
    public String pedidosAsignados2(){
        String salida = "";
        boolean error = false;
        contadorPedidos = 2;
        salida += (pedido2 != null ? contadorPedidos + ". " + pedido2.getId() + " - " + pedido2.getClientePedido().getNombre() + " (" + pedido2.getClientePedido().getLocalidad() + ") - " +
                pedido2.sumarProductosPedido() + " productos - " + pedido2.sumarPrecioProductos() + "€\n" : (error = true));
        if (error){
            salida = "";
            contadorPedidos--;
        }
        return salida;
    }

}
