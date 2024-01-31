import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;



public class ConexionServidor extends Thread{
    Socket socketServidor;
    DataInputStream in;
    DataOutputStream out;

    public ConexionServidor(Socket socketServidor) {
        this.socketServidor=socketServidor;
    }

    public void run() {

        try {
              

            // tenemos el sockeet conectado, entonces conneected es true
            boolean connected = true;

            // Establecemos canales de entrada y salida de la conexión socket

            // canal entrada
            in = new DataInputStream(socketServidor.getInputStream());

            // canal saldida
            out = new DataOutputStream(socketServidor.getOutputStream());

            // mientras estamos conectados, no matamos el hilo
            // repetimos todo el proceso desde el principio, es decir, volvemos al menu,
            // hasta que implicitamente, pulsemos 4 y nos desconectemos
            while (connected) {
                // leemos el canal de entrada
                System.out.println(in.readUTF());

                // el cliente selecciona una opción del menu y la manda al servidor
                

                
            }

        } catch (Exception exception) {
            System.err.println("Excepción: " + exception.getMessage());
            exception.printStackTrace();
        }
        System.out.println("Saliendo del hilo");

    }
}
