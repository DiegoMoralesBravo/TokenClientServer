package App;

import java.net.ServerSocket;

public class App {
    public static void main(String[] args) throws Exception {

        ServerSocket SocketServidor = new ServerSocket(9090);
        Server server = new Server();
        server.start();

        while (true) {
            // Imprimimos un mensaje para indicar que estamos esperando a los clientes
            System.out.println("Esperando a multi clientes...");

            // El servidor espera a que un cliente se conecte y acepta la conexión
            java.net.Socket Socket = SocketServidor.accept();

            System.out.println("Se ha conectado un cliente: " + Socket);

            server.enqueue(Socket);
            System.out.println(Socket);
        }
        // SocketServidor.close();
    }
}
