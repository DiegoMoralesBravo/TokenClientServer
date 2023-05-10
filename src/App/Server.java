package App;

import java.awt.Color;

public class Server extends Thread {
  private Node tail;
  private int size;
  private VentanaServidor ventana;

  public Server() {
    this.tail = null;
    this.size = 0;
  }

  public void setTail(Node tail) {
    this.tail = tail;
  }

  public Node getTail() {
    return tail;
  }

  public int getSize() {
    return size;
  }

  public boolean is_empty() {
    if (this.size == 0) {
      return true;
    }
    return false;
  }

  public Node first() {
    return this.tail.getNext();
  }

  public void enqueue(java.net.Socket Socket, VentanaServidor ventana) {
    this.ventana = ventana;
    Node newest = new Node(null, Socket, ventana);
    newest.start();
    if (this.is_empty()) {
      newest.setNext(newest);
    } else {
      newest.setNext(this.tail.getNext());
      this.tail.setNext(newest);
    }
    this.setTail(newest);
    this.size += 1;
  }

  public void rotate() {

    if (this.size > 0) {
      this.tail.setToken(false);
      this.tail.isToken();
      this.tail = this.tail.getNext();
      this.tail.setToken(true);
      this.tail.isToken();
    }
  }

  public void run() {
    while (true) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      rotate();
    }
  }
}
