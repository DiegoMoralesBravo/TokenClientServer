package Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SendData extends Thread {

  private boolean token;
  private PrintWriter salida;
  private Socket socketCliente;
  private Scanner scanner;

  public SendData(Socket socketCliente) {
    this.token = false;
    this.socketCliente = socketCliente;
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
    while(true){
      System.out.println("Mensaje a enviar:");
      String mensaje = scanner.nextLine();
      System.out.println("Se enviara cuando se tenga el token");
      while(!this.token){
        System.out.println(this.token);
        try {
          Thread.sleep(1000); //Revisar este tiempo
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      this.salida.println(mensaje);
      System.out.println("Se envio el mensaje: " + mensaje);
    }
  }
}
