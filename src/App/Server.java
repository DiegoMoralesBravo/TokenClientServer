package App;

public class Server {
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

  public Node dequeue() {
    Node oldhead = this.tail.getNext();
    if (this.size == 1) {
      this.tail = null;
    } else {
      this.tail.setNext(oldhead.getNext());
    }
    this.size -= 1;
    return oldhead;
  }

  public void enqueue(String name) {
    Node newest = new Node(null, name);
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
    }
  }
}
