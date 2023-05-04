package App;

public class Node {
  private Node next;
  private boolean token = false;
  private String name;

  public Node(Node next, String name) {
    this.next = next;
    this.name = name;
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
