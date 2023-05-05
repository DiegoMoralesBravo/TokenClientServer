package Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SendData extends Thread {

  private boolean token;
  private PrintWriter salida;
  private Socket socketCliente;
  private Scanner scanner;
  private VentanaConexion ventanaConexion;

  public SendData(Socket socketCliente, VentanaConexion ventanaConexion) {
    this.token = false;
    this.socketCliente = socketCliente;
    this.ventanaConexion = ventanaConexion;
    try {
      this.salida = new PrintWriter(socketCliente.getOutputStream(), true);
      this.scanner = new Scanner(System.in);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void setToken(boolean token) {
    this.token = token;
  }

  public void run() {
    String mensaje = "";

    while (true) {
      while (this.ventanaConexion.getMensaje().equals("")) {
        try {
          System.out.println("Esperando mensaje");
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      mensaje = this.ventanaConexion.getMensaje();
      this.ventanaConexion.clearMensaje();
      this.ventanaConexion.setLog("Se enviara mensaje cuando se tenga el token");
      while (!this.token) {
        System.out.println(this.token);
        try {
          Thread.sleep(1000); // Revisar este tiempo
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      this.salida.println(mensaje);
    }
  }
}
