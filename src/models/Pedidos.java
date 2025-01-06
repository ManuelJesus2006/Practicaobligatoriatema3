package models;

import java.time.LocalDate;

public class Pedidos {
    private String id;
    private String fecha;
    private String fechaLlegada;
    private double precioTotal;
    private String comentario;
    private String estado;
    private Productos producto1;
    private Productos producto2;
    private Productos producto3;
    private int codPedido;
    private static int contadorPedidos;
    private Cliente cliente;
    private static int contid = 0;

    //Constructor con 1 productos
    public Pedidos (Productos producto1){
        id = "" + LocalDate.now().getMonthValue() + LocalDate.now().getYear() + LocalDate.now().getDayOfMonth() + contid++;
        this.producto1 = producto1;
        fecha = LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        fechaLlegada = (LocalDate.now().getDayOfMonth() + 5) + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        contadorPedidos++;
    }
    //Constructor con 2 productos
    public Pedidos (Productos producto1, Productos producto2){
        id = "" + LocalDate.now().getMonthValue() + LocalDate.now().getYear() + LocalDate.now().getDayOfMonth() + contid++;
        this.producto1 = producto1;
        this.producto2 = producto2;
        fecha = LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        fechaLlegada = (LocalDate.now().getDayOfMonth() + 5) + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        contadorPedidos++;
    }
    //Constructor con 3 productos
    public Pedidos (Productos producto1, Productos producto2, Productos producto3){
        id = "" + LocalDate.now().getMonthValue() + LocalDate.now().getYear() + LocalDate.now().getDayOfMonth() + contid++;
        this.producto1 = producto1;
        this.producto2 = producto2;
        this.producto3 = producto3;
        fecha = LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        fechaLlegada = (LocalDate.now().getDayOfMonth() + 5) + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        contadorPedidos++;
    }

    //Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getContid() {
        return contid;
    }

    public static void setContid(int contid) {
        Pedidos.contid = contid;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
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

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    //Métodos
    public double sumarPrecioProductos(){
        double precioTotal = -1;
        if (producto1 != null && producto2 == null && producto3 == null) precioTotal = producto1.getPrecio();
        if (producto1 != null && producto2 != null && producto3 == null) precioTotal = producto1.getPrecio() + producto2.getPrecio();
        if (producto1 != null && producto2 != null && producto3 != null) precioTotal = producto1.getPrecio() + producto2.getPrecio() + producto3.getPrecio();
        return precioTotal;
    }

    public int sumarProductosPedido(){
        int contador = 0;
        if (producto1 != null && producto2 == null && producto3 == null) contador = 1;
        if (producto1 != null && producto2 != null && producto3 == null) contador = 2;
        if (producto1 != null && producto2 != null && producto3 != null) contador = 3;
        return contador;
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
