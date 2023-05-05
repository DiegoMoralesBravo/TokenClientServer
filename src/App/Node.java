package App;

import java.io.*;
import java.net.*;

public class Node extends Thread {
  private Node next;
  private boolean token = false;
  private String name;
  private Socket socketCliente;
  private PrintWriter salida;
  private BufferedReader entrada;

  public Node(Node next, Socket socketCliente) {
    this.next = next;
    this.socketCliente = socketCliente;
    try {
      this.entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));
      this.salida = new PrintWriter(this.socketCliente.getOutputStream(), true);
      System.out.println("Esperando nombre");
      this.name = entrada.readLine();
      System.out.println("Nombre asignado: ");
      System.out.println(this.name);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public String getNameNode() {
    return name;
  }

  public Node getNext() {
    return next;
  }

  public boolean isToken() {
    this.salida.println(this.name + " token: " + this.token);
    return token;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public void setToken(boolean token) {
    this.token = token;
  }

  public void run() {
    String mensaje = "";
    while (true) {
      try {
        mensaje = this.entrada.readLine();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println("Mensaje recibido " + this.name + ": " + mensaje);
      this.salida.println("Mensaje recibido " + this.name + ": " + mensaje);
    }
  }
}
