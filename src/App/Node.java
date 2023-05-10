package App;

import java.awt.Color;
import java.io.*;
import java.net.*;

public class Node extends Thread {
  private Node next;
  private boolean token = false;
  private String name;
  private Socket socketCliente;
  private PrintWriter salida;
  private BufferedReader entrada;
  private VentanaServidor ventana;
  private int posicion;

  public Node(Node next, Socket socketCliente, VentanaServidor ventana) {
    this.next = next;
    this.socketCliente = socketCliente;
    this.ventana = ventana;
    this.posicion = ventana.posicionLista();
    try {
      this.entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));
      this.salida = new PrintWriter(this.socketCliente.getOutputStream(), true);
      this.name = entrada.readLine();
      ventana.agregarLineaLog("Cliente agregado: " + this.name);
      ventana.agregarElementoLista(this.name);
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
    if (token) {
      this.ventana.seleccionarElementoLista(this.posicion, Color.GREEN);
    } else {
      this.ventana.seleccionarElementoLista(this.posicion, Color.BLACK);
    }
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
      if (mensaje.equals("imagen")) {
        try (InputStream inputStream = this.socketCliente.getInputStream()) {
          byte[] buffer = new byte[1024];
          int bytesRead;
          long timestamp = System.currentTimeMillis();
          String fileName = "imagen-" + timestamp + ".png";
          FileOutputStream fileOutputStream = new FileOutputStream(fileName);
          while ((bytesRead = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, bytesRead);
          }
          this.ventana.eliminarElementoLista(this.posicion);
          fileOutputStream.close();
          inputStream.close();

        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      } else {
        this.salida.println("Mensaje recibido " + this.name + ": " + mensaje);
        this.ventana.agregarLineaLog("Mensaje recibido " + this.name + ": " + mensaje);
      }
    }
  }
}
