package models;

public class Productos {
    private String nombre;
    private double precio;
    private static int cantProductos = 1;

    //Constructor
    public Productos(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static int getCantProductos() {
        return cantProductos;
    }

    public static void setCantProductos(int cantProductos) {
        Productos.cantProductos = cantProductos;
    }


    //Métodos
    public String pintaCatalogo(){
        String salida = "";
        if (cantProductos > 8) cantProductos = 1;
        salida += "= PRODUCTO " + cantProductos++ + " =\n";
        salida += nombre + " - " + precio + "\n";
        salida += "=============================\n";
        return salida;
    }

    public String pintarProductoPedido(){
        return "- " + nombre + " (" + precio + "€)";
    }
}