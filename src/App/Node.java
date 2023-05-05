package App;

import java.io.*;
import java.net.*;

public class Node {
  private Node next;
  private boolean token = false;
  private String name;
  private Socket socketCliente;

  public Node(Node next, Socket socketCliente) {
    this.next = next;
    this.name = "Por definir";
    this.socketCliente = socketCliente;
    try {
      BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
      this.name = entrada.readLine();
      System.out.println("Nombre asignado: ");
      System.out.println(this.name);
      entrada.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public String getName() {
    return name;
  }

  public Node getNext() {
    return next;
  }

  public boolean isToken() {
    return token;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public void setToken(boolean token) {
    this.token = token;
  }
}
