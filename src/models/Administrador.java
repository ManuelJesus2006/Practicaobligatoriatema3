package models;

public class Administrador {
    private Trabajadores trabajador1;
    private Trabajadores trabajador2;
    private Trabajadores trabajador3;
    private Pedidos pedidos1;
    private Pedidos pedidos2;
    private String nombre;
    private String clave;
    private static int numTrabajador = 1;
    private int contPedidosTrabajador = 0;


    //Constructor
    public Administrador(String nombre, String clave, Trabajadores trabajador1, Trabajadores trabajador2, Trabajadores trabajador3) {
        this.nombre = nombre;
        this.clave = clave;
        this.trabajador1 = trabajador1;
        this.trabajador2 = trabajador2;
        this.trabajador3 = trabajador3;
        pedidos1 = null;
        pedidos2 = null;
    }

    //Getters y setters

    public Trabajadores getTrabajador1() {
        return trabajador1;
    }

    public void setTrabajador1(Trabajadores trabajador1) {
        this.trabajador1 = trabajador1;
    }

    public Trabajadores getTrabajador2() {
        return trabajador2;
    }

    public void setTrabajador2(Trabajadores trabajador2) {
        this.trabajador2 = trabajador2;
    }

    public Trabajadores getTrabajador3() {
        return trabajador3;
    }

    public void setTrabajador3(Trabajadores trabajador3) {
        this.trabajador3 = trabajador3;
    }

    public Pedidos getPedidos1() {
        return pedidos1;
    }

    public void setPedidos1(Pedidos pedidos1) {
        this.pedidos1 = pedidos1;
    }

    public Pedidos getPedidos2() {
        return pedidos2;
    }

    public void setPedidos2(Pedidos pedidos2) {
        this.pedidos2 = pedidos2;
    }

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

    //Métodos

    public int cuentaPedidos() {
        int contador = 0;
        if (pedidos1 != null) contador++;
        if (pedidos2 != null) contador++;
        return contador;
    }

    public String menuAdministrador() {
        String salida = "";
        salida += "FERNANSHOP\n";
        salida += "Bienvenido " + nombre + ". Tienes " + (cuentaPedidos() > 1 ? cuentaPedidos() + " Pedidos" : "un pedido") + " por asignar." + "\n";
        salida += "1.- Asignar un pedido a un trabajador" + "\n";
        salida += "2.- Modificar el estado de un pedido" + "\n";
        salida += "3.- Dar de alta un trabajador" + "\n";
        salida += "4.- Ver todos los pedidos" + "\n";
        salida += "5.- Ver todos los clientes" + "\n";
        salida += "6.- Ver todos los trabajadores" + "\n";
        salida += "7.- Cerrar sesión" + "\n";
        salida += "Introduce una opción: ";
        return salida;
    }

    public boolean iniciaSesion(String contraTeclado, String nombreTeclado) {
        return (contraTeclado.equals(getClave()) && nombreTeclado.equals(getNombre()));
    }



    public String menuAsignar(){String salida = "";
        numTrabajador = 1;
        if (trabajador1 != null) salida += numTrabajador++ + ". - " +
                trabajador1.getNombre() + " " + trabajador1.sumarPedidosAsignados() + (trabajador1.sumarPedidosAsignados() == 1 ? " pedido" : " pedidos") + " en proceso\n";
        if (trabajador1 != null && trabajador2 != null) salida += numTrabajador++ + ". - " +
                trabajador2.getNombre() + " " + contPedidosTrabajador + (trabajador2.sumarPedidosAsignados() == 1 ? " pedido" : " pedidos") + " en proceso\n";
        if (trabajador1 != null && trabajador2 != null && trabajador3 != null) salida += numTrabajador++ + ". - " +
                trabajador3.getNombre() + " " + contPedidosTrabajador + (trabajador3.sumarPedidosAsignados() == 1 ? " pedido" : " pedidos") + " en proceso\n";
        return salida;
    }

    public String pintaMenuModificacionPedido(Pedidos pedido){
        String salida = "";
        salida += "==== Actualización del pedido " + pedido.getId() + " ====\n";
        salida += "Estado del pedido: " + (pedido.getEstado() == null ? "Sin estado" : pedido.getEstado()) + "\n";
        salida += "Nuevo estado:\n";
        salida += "1. Recibido\n";
        salida += "2. En preparación\n";
        salida += "3. Retrasado\n";
        salida += "4. Cancelado\n";
        salida += "5. Enviado\n";
        return salida;
    }

}
