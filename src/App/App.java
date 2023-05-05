package App;

import java.net.ServerSocket;

public class App {
    public static void main(String[] args) throws Exception {

        boolean flag = true;
        ServerSocket SocketServidor = new ServerSocket(9090);
        Server server = new Server();
        server.start();

        VentanaServidor ventana = new VentanaServidor();
        ventana.agregarLineaLog("El servidor ha iniciado.");

        while (flag) {
            System.out.println("Esperando a multi clientes...");

            java.net.Socket Socket = SocketServidor.accept();
            ventana.agregarLineaLog("Se ha conectado un cliente: " + Socket);
            server.enqueue(Socket, ventana);
            System.out.println(Socket);
        }
        SocketServidor.close();
    }
}
