package Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;

    try {
      InetAddress AdressServidor = InetAddress.getByName("sofi");
      Socket SocketCliente = new Socket(AdressServidor, 9090);
      PrintWriter salida = new PrintWriter(SocketCliente.getOutputStream(), true);
      System.out.println("Conexion aceptada!");
      System.out.println("Enter client name");
      String clientName = scanner.nextLine();
      salida.println(clientName);
      while (flag)

      scanner.close();
      SocketCliente.close();
      salida.close();
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println(e);
    }
  }
}
