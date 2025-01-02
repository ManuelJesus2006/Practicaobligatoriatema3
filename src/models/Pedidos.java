package models;

import java.time.LocalDate;

public class Pedidos {
    private LocalDate fecha;
    private LocalDate fechaLlegada;
    private double precioTotal;
    private String comentario;
    private String estado;
    private Productos producto1;
    private Productos producto2;
    private Productos producto3;
    private Cliente cliente;
    private static int contadorPedidos;

    //Constructor con 1 pedido
    public Pedidos (Productos producto1){
        this.producto1 = producto1;
        fecha = LocalDate.now();
        fechaLlegada = fecha.plusDays(5);
        contadorPedidos++;
    }
    //Constructor con 2 pedidos
    public Pedidos (Productos producto1, Productos producto2){
        this.producto1 = producto1;
        this.producto2 = producto2;
        fecha = LocalDate.now();
        fechaLlegada = fecha.plusDays(5);
        contadorPedidos++;
    }
    //Constructor con 3 pedidos
    public Pedidos (Productos producto1, Productos producto2, Productos producto3){
        this.producto1 = producto1;
        this.producto2 = producto2;
        this.producto3 = producto3;
        fecha = LocalDate.now();
        fechaLlegada = fecha.plusDays(5);
        contadorPedidos++;
    }

    //Getters y setters


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Productos getProducto1() {
        return producto1;
    }

    public void setProducto1(Productos producto1) {
        this.producto1 = producto1;
    }

    public Productos getProducto2() {
        return producto2;
    }

    public void setProducto2(Productos producto2) {
        this.producto2 = producto2;
    }

    public Productos getProducto3() {
        return producto3;
    }

    public void setProducto3(Productos producto3) {
        this.producto3 = producto3;
    }

    public static int getContadorPedidos() {
        return contadorPedidos;
    }

    public static void setContadorPedidos(int contadorPedidos) {
        Pedidos.contadorPedidos = contadorPedidos;
    }

    //Métodos
    public double sumarPrecioProductos(){
        double precioTotal = -1;
        if (producto1 != null && producto2 == null && producto3 == null) precioTotal = producto1.getPrecio();
        if (producto1 != null && producto2 != null && producto3 == null) precioTotal = producto1.getPrecio() + producto2.getPrecio();
        if (producto1 != null && producto2 != null && producto3 != null) precioTotal = producto1.getPrecio() + producto2.getPrecio() + producto3.getPrecio();
        return precioTotal;
    }



    public String pintarProducto1Pedido(){
        return "- " + producto1.getNombre() + " (" + producto1.getPrecio() + "€)";
    }

    public String pintarProducto2Pedido(){
        return "- " + producto2.getNombre() + " (" + producto2.getPrecio() + "€)";
    }

    public String pintarProducto3Pedido(){
        return "- " + producto3.getNombre() + " (" + producto3.getPrecio() + "€)";
    }
}
