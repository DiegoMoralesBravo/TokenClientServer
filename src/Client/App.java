package Client;

import java.io.*;
import java.net.*;

public class App {
  public static void main(String[] args) throws Exception {
    boolean flag = true;
    String mensaje = "";
    try {
      InetAddress AdressServidor = InetAddress.getByName("sofi");
      Socket SocketCliente = new Socket(AdressServidor, 9090);
      PrintWriter salida = new PrintWriter(SocketCliente.getOutputStream(), true);
      BufferedReader entrada = new BufferedReader(new InputStreamReader(SocketCliente.getInputStream()));
      Ventana ventana = new Ventana();

      String clientName = "";
      while (ventana.getName().equals("")) {
        try {
          System.out.println("Esperando nombre cliente");
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      clientName = ventana.getName();
      salida.println(clientName);
      VentanaConexion ventanaConexion = new VentanaConexion(clientName);
      SendData sendData = new SendData(SocketCliente, ventanaConexion);
      sendData.start();

      while (flag) {
        mensaje = entrada.readLine();
        // System.out.println(mensaje);
        if (mensaje.equals(clientName + " token: true")) {
          sendData.setToken(true);
          ventanaConexion.setColorToken(true);
        } else if (mensaje.equals(clientName + " token: false")) {
          sendData.setToken(false);
          ventanaConexion.setColorToken(false);
        } else {
          ventanaConexion.setLog(mensaje);
        }
      }

      SocketCliente.close();
      salida.close();

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("No hay conexion con server");
      System.out.println(e);
    }
  }
}
