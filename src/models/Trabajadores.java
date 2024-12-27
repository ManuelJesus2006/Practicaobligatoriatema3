package models;

public class Trabajadores {
    private String nombre;
    private String clave;
    private Pedidos pedido1;
    private Pedidos pedido2;

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
}
