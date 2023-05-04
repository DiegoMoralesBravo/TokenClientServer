package App;

import java.net.ServerSocket;

public class App {
    public static void main(String[] args) throws Exception {
        ServerSocket SocketServidor = new ServerSocket(9090);
        Server server = new Server();

        while (true) {
            // Imprimimos un mensaje para indicar que estamos esperando a los clientes
            System.out.println("Esperando a multi clientes...");

            // El servidor espera a que un cliente se conecte y acepta la conexión
            java.net.Socket Socket = SocketServidor.accept();

            System.out.println("Se ha conectado un cliente: " + Socket);

            // server.enqueue("Diego");
            System.out.println(Socket);
            Thread.sleep(6000);

            // // Creamos un nuevo hilo para manejar la conexión del cliente
            // ServerThread hiloCliente = new ServerThread(Socket, SocketServidor);
            // hiloCliente.start();
            SocketServidor.close();
        }
    }
}
