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
  private boolean flag;

  public SendData(Socket socketCliente, VentanaConexion ventanaConexion, boolean flag) {
    this.token = false;
    this.socketCliente = socketCliente;
    this.ventanaConexion = ventanaConexion;
    this.flag = flag;
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

  public boolean getFlag() {
    return this.flag;
  }

  public void run() {
    File file;
    String mensaje = "";

    while (this.flag) {
      System.out.println("Se llega arriba");
      while (this.ventanaConexion.getFile() == null && this.ventanaConexion.getMensaje().equals("")) {
        try {
          System.out.println("Esperando archivo");
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      if (this.ventanaConexion.getFile() != null) {
        file = this.ventanaConexion.getFile();
        this.ventanaConexion.clearFile();
        this.ventanaConexion.setLog("Se enviara la imagen cuando se tenga el token");
        while (!this.token) {
          System.out.println(this.token);
          try {
            Thread.sleep(1000); // Revisar este tiempo
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
        this.salida.println("imagen");
        this.ventanaConexion.closeWindow();
        try (OutputStream outputStream = this.socketCliente.getOutputStream()) {
          FileInputStream fileInputStream = new FileInputStream(file);
          byte[] buffer = new byte[1024];
          int bytesRead;
          while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
          }
          fileInputStream.close();
          outputStream.close();
          this.flag = false;
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      } else {
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
}
