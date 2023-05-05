package App;

public class Server extends Thread {
  private Node tail;
  private int size;

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

  public void enqueue(java.net.Socket Socket) {
    Node newest = new Node(null, Socket);
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
      this.tail = this.tail.getNext();
      System.out.println("El nombre de la cola:");
      System.out.println(this.tail.getName());
    }
  }

  public void run() {
    while (true) {
      rotate();
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
