package Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {

    try {
      InetAddress AdressServidor = InetAddress.getByName("sofi");

      Socket SocketCliente = new Socket(AdressServidor, 9090);
      Thread.sleep(1000);

      SocketCliente.close();

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println(e);
    }
  }
}
