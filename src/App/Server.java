package App;

public class Server {
  private Client tail;
  private int size;

  public Server() {
    this.tail = null;
    this.size = 0;
  }

  public void setTail(Client tail) {
    this.tail = tail;
  }

  public Client getTail() {
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

  public Client first() {
    return this.tail.getNext();
  }

  public Client dequeue() {
    Client oldhead = this.tail.getNext();
    if (this.size == 1) {
      this.tail = null;
    } else {
      this.tail.setNext(oldhead.getNext());
    }
    this.size -= 1;
    return oldhead;
  }

  public void enqueue(String name) {
    Client newest = new Client(null, name);
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
