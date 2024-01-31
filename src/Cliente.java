import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    static boolean salir = false;

    public static void main(String[] args) throws Exception {
        System.out.println(
                "******************************************\r\n" + //
                        "\r\n" + //
                        "*PSP - Tarea Individual 4 - Cliente / Servidor*\r\n" + //
                        "\r\n" + //
                        "******************************************\r\n" + //
                        "\r\n" + //
                        "* Miriam Gallardo González-Amor *\r\n" + //
                        "\r\n" + //
                        "******************************************\r\n" + //
                        "\r\n" + //
                        "* 53772609N     *                     \r\n" + //
                        "");

        // Pedimos al usuario una direccion IP y un Puerto para poder conectarnos al
        // servidor
        System.out.println("Insertar dirección IP");
        Scanner scanner = new Scanner(System.in);
        String IPseleccionada = scanner.nextLine();
        System.out.println("Introducir puerto");
        Integer puertoSeleccionado = scanner.nextInt();

        // Creamos un objeto de tipo socket(una conexión) desde el cliente
        Socket socket = new Socket(IPseleccionada, puertoSeleccionado);

        ConexionServidor conexionServidor = new ConexionServidor(socket);
        conexionServidor.start();

        while (!salir) {

            // LLamamos al método menú para mostrar al usuario las distintas opciones
            // disponibles
            menu();
            Integer opcionElegida = scanner.nextInt();
            if (opcionElegida == 4) {
                salir = true;
            }
            

        }
    }

    public static String menu() {
        return "Pulse 1 para consultar el stock\nPulse 2 para aumentar el stock\nPulse 3 para disminuir el stock\nPulse 4 para desconectarse";
    }

}
