package utils;

public class Menus {

    public static String inicioSesion() {
        String salida = "";
        salida += """
                    BIENVENIDO.
                    1. Iniciar sesión
                    2. Registrarse
                    ELIGA UNA OPCIÓN:\s""";
        return salida;
    }
}
